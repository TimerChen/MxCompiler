/*
	Coded by timemachine on 18-5-25
	MxCompiler.CodeGen.VarAnalyzer
*/


package MxCompiler.CodeGen;

import MxCompiler.Global;
import MxCompiler.IR.*;
import MxCompiler.Options;
import MxCompiler.tools.Debuger;
import org.antlr.runtime.misc.IntArray;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class VarAnalyzer implements IRVisitor
{
	private List<BasicBlock> startBlocks;
	private int []du;
	private int size;
	private BasicBlock currentBlock;
	private List<ConflictGraph> cGraphs;
	private ConflictGraph nowGraph;

	public VarAnalyzer(List<BasicBlock> startBlocks)
	{
		this.startBlocks = startBlocks;
		this.cGraphs = null;
	}

	public List<ConflictGraph> cGraphs()
	{
		if(cGraphs == null)
		{
			this.cGraphs = new LinkedList<>();
			analyze();
		}
		return cGraphs;
	}

	private void analyze()
	{
		ConcurrentLinkedDeque<BasicBlock> bQue;
		for(BasicBlock start: startBlocks)
		{
			cGraphs.add(nowGraph = new ConflictGraph(Global.maxRegNumber));
			size = 0;
			BasicBlock nowBlock = start;
			while(nowBlock!=null)
			{
				size++;
				nowBlock = nowBlock.next0();
			}
			du = new int[size];
			for(int i=0;i<size;++i)du[i]=0;

			nowBlock = start;
			while(nowBlock!=null)
			{
				analyzeBlock(nowBlock);
				BasicBlock b0, b1;
				b0 = nowBlock.next0();
				b1 = nowBlock.next1();
				if(b0 != null)
					du[b0.id()]++;
				if(b1 != null)
					du[b1.id()]++;
				nowBlock = nowBlock.next0();
			}

			analyzeGraph(start);

			buildCGraphLeft(start);
		}
	}
	/*
		Throughout: LiveOut \ VarKill
		IN:         UEVar
		OUT:        LiveOut
		All:        LiveOut U UEVar U VarKill

		Left:
			1)  UEVar x UEVar
			2)  All x Throughout

	 */
	private void buildCGraphLeft(BasicBlock start)
	{
		BasicBlock now = start;
		Set<Integer> T, A;
		while(now!=null)
		{
			T = new HashSet<>(now.liveOut);
			T = subSet(T, now.varKill);
			A = mergeSet(now.liveOut, now.ueVar);
			A.addAll(now.varKill);

			addEdges(now.ueVar, now.ueVar);
			addEdges(A, T);

			now = now.next0();
		}
	}
	private void analyzeBlock(BasicBlock block)
	{
		currentBlock = block;
		List<InsIR> list = block.irList();
		int n = list.size();
		for(int i=n-1;i>=0;--i)
		{
			list.get(i).accept(this);
		}
	}

	void addEdges(int a, Set<Integer> bArray)
	{
		Iterator<Integer> i = bArray.iterator();
		while(i.hasNext())
		{
			nowGraph.addEdge(a,i.next());
		}
	}
	void addEdges(Set<Integer> aArray, Set<Integer> bArray)
	{
		Iterator<Integer> i = aArray.iterator(),j;
		while(i.hasNext())
		{
			int iVal = i.next();
			j = bArray.iterator();
			while(j.hasNext())
			{
				nowGraph.addEdge(iVal, j.next());
			}
		}

	}
	private void destVisit(VarIR oVar)
	{
		if(oVar == null)return;
		if(oVar instanceof VarMemIR)
		{
			VarMemIR var = (VarMemIR) oVar;
			srcVisit(var.base());
			srcVisit(var.index());
			return;
		}
		if(!(oVar instanceof VarRegIR))
			return;
		VarRegIR var = (VarRegIR)oVar;
		
		currentBlock.ueVar.remove(var.regIndex());
		addEdges(var.regIndex(), currentBlock.ueVar);
		currentBlock.varKill.add(var.regIndex());
	}

	private void srcVisit(VarIR oVar)
	{
		if(oVar == null)return;
		if(oVar instanceof VarMemIR)
		{
			VarMemIR var = (VarMemIR) oVar;
			srcVisit(var.base());
			srcVisit(var.index());
			return;
		}
		if(!(oVar instanceof VarRegIR))
			return;
		VarRegIR var = (VarRegIR)oVar;

		currentBlock.ueVar.add(var.regIndex());
	}

	private void regVisit(VarIR dest0, VarIR dest1, VarIR src0, VarIR src1)
	{
		destVisit(dest0);
		destVisit(dest1);
		srcVisit(src0);
		srcVisit(src1);
	}

	@Override
	public void visit(AlignIR node)
	{
		//Nothing
	}

	@Override
	public void visit(TriIR node)
	{
		regVisit(node.dest(), null, node.src0(), node.src1());
	}

	@Override
	public void visit(BinaryIR node)
	{
		regVisit(node.lhs(), null, node.lhs(), node.rhs());
	}

	@Override
	public void visit(UnaryIR node)
	{
		if(node.has2Dest())
			regVisit(node.dest0(), node.dest1(), node.src(), null);
		else
			regVisit(node.src(), null, node.src(), null);
	}

	@Override
	public void visit(CJumpIR node)
	{
		regVisit(null, null, node.lhs(), node.rhs());
	}

	@Override
	public void visit(JumpIR node)
	{
		//Nothing
	}

	@Override
	public void visit(CallIR node)
	{
		//Nothing
		int []idx = {7, 6, 2, 1, 8, 9};
		for(int i=0;i<6&&i<node.pNum();++i)
		{
			destVisit(new VarRegIR(idx[i]));
		}

	}

	@Override
	public void visit(LabelIR node)
	{
		//Nothing
	}

	@Override
	public void visit(ReturnIR node)
	{
		//Nothing
	}

	@Override
	public void visit(PushIR node)
	{
		regVisit(null, null, node.src(), null);
	}

	@Override
	public void visit(PopIR node)
	{
		regVisit(node.dest(), null, null, null);
	}

	@Override
	public void visit(LoadIR node)
	{
		regVisit(node.dest(), null, node.src(), null);
	}

	@Override
	public void visit(StoreIR node)
	{
		regVisit(node.dest(), null, node.src(), null);
	}

	@Override
	public void visit(MoveIR node)
	{
		regVisit(node.lhs(), null, node.lhs(), null);
	}


	/*
	 *************************************
	 *           Analyze Graph
	 *************************************
	 */

	//For Priority Queue
	class BlockPack
	{
		BasicBlock block;
		int du;

		public BlockPack(BasicBlock block, int du)
		{
			this.block = block;
			this.du = du;
		}
	}
	public static Comparator<BlockPack> duComparator = new Comparator<BlockPack>(){

		@Override
		public int compare(BlockPack c1, BlockPack c2) {
			return (c1.du - c2.du);
		}
	};


	Set<Integer> mergeSet(Set<Integer> a, Set<Integer> b)
	{
		Set<Integer> c;
		c = new HashSet<>(a);
		c.addAll(b);
		return c;
	}
	Set<Integer> subSet(Set<Integer> a, Set<Integer> b)
	{
		Set<Integer> c;
		c = new HashSet<>(a);
		c.removeAll(b);
		return c;
	}
	//L(a) = U( (LiveOut(bi)-VarKill(bi)) U UEVar(bi) ) [i=1, 2]
	boolean reCalculate(BasicBlock block)
	{
		int oldSize = block.liveOut.size();
		Set<Integer> ret;
		BasicBlock n = block.next0();
		if(n==null)
			return false;

		ret = mergeSet(n.ueVar, subSet(n.liveOut, n.varKill));
		if(block.next1()!=null)
		{
			n = block.next1();
			ret = mergeSet(ret,
					mergeSet(n.ueVar, subSet(n.liveOut, n.varKill))
			);
		}
		block.liveOut = ret;
		return oldSize != ret.size();
	}

	void analyzeGraph(BasicBlock start)
	{
		boolean change = false;

		while(change)
		{
			int []du = new int[size];
			for(int i=0;i<size;++i)
				du[i] = this.du[i];
			PriorityQueue<BlockPack> bQue = new PriorityQueue<BlockPack>(duComparator);
			BasicBlock now = start;

			for(int i=0;i<size;++i)
			{
				bQue.add(new BlockPack(now, du[i]));
				now = now.next0();
			}
			int left = size-1;
			while(left >= 0)
			{
				BlockPack pack;
				do{
					pack = bQue.poll();
				}while(pack.du!=du[pack.block.id()]);
				now = pack.block;
				//reCalculate
				change = (change || reCalculate(now));
				//update successor
				if(now.next0()!=null)
				{
					bQue.add(new BlockPack(now.next0(), --du[now.next0().id()]));
				}
				if(now.next1()!=null)
				{
					bQue.add(new BlockPack(now.next1(), --du[now.next1().id()]));
				}
				left--;
			}
		}

	}

	@Override
	public void visit(SpecialIR node)
	{
		//Nothing
	}
}
