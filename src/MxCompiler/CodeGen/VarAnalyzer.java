/*
	Coded by timemachine on 18-5-25
	MxCompiler.CodeGen.VarAnalyzer
*/


package MxCompiler.CodeGen;

import MxCompiler.IR.*;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class VarAnalyzer extends IRVisitor
{
	private List<BasicBlock> startBlocks;
	private int []du;
	private int size;

	public VarAnalyzer(List<BasicBlock> startBlocks)
	{
		this.startBlocks = startBlocks;

	}

	void analyze()
	{
		ConcurrentLinkedDeque<BasicBlock> bQue;
		for(BasicBlock start: startBlocks)
		{
			bQue = new ConcurrentLinkedDeque<>();
			size = 0;
			BasicBlock nowBlock = start;
			while(nowBlock.next0()!=null)nowBlock = nowBlock.next0();
			size=nowBlock.number()+1;
			du = new int[size];
			nowBlock = start;
			while(nowBlock!=null)
			{
				analyzeBlock(nowBlock);
				BasicBlock b0, b1;
				bQue.removeFirst();
				b0 = nowBlock.next0();
				b1 = nowBlock.next1();
				if(b0 != null)
					du[b0.number()]++;
				if(b1 != null)
					du[b1.number()]++;
				nowBlock = nowBlock.next0();
			}
			analyzeGraph(start);
		}
	}

	void analyzeBlock(BasicBlock block)
	{
		List<InsIR> list = block.irList();
		int n = list.size();
		for(int i=n-1;i>=0;--i)
		{
			list.get(i).accept(this);
		}
	}
	void analyzeGraph(BasicBlock start)
	{
		boolean change = false;

		while(change)
		{
			int []du0 = new int[size];
			for(int i=0;i<size;++i)
				du0[i] = du[i];
			PriorityQueue<BasicBlock> bQue = new PriorityQueue<>();
			BasicBlock now = start;
			while(now!=null)
			{
				bQue.add(now);
				now = now.next0();
			}
			bQue.add(start);
			int left = size-1;
			while(size >= 0)
			{
				???
				now = bQue.peek();
				bQue.remove();
				//reclac
			}
		}

	}


	private void destVisit(BasicBlock b, VarIR var)
	{
		if(var == null)return;
	}

	private void srcVisit(BasicBlock b, VarIR var)
	{
		if(var == null)return;
	}

	private void regVisit(BasicBlock b, VarIR dest0, VarIR dest1, VarIR src0, VarIR src1)
	{
		destVisit(b, dest0);
		destVisit(b, dest1);
		srcVisit(b, src0);
		srcVisit(b, src1);
	}

	@Override
	public void visit(AlignIR node)
	{

	}

	@Override
	public void visit(TriIR node)
	{

	}

	@Override
	public void visit(BinaryIR node)
	{

	}

	@Override
	public void visit(UnaryIR node)
	{

	}

	@Override
	public void visit(CJumpIR node)
	{

	}

	@Override
	public void visit(JumpIR node)
	{

	}

	@Override
	public void visit(CallIR node)
	{

	}

	@Override
	public void visit(LabelIR node)
	{

	}

	@Override
	public void visit(ReturnIR node)
	{

	}

	@Override
	public void visit(PushIR node)
	{

	}

	@Override
	public void visit(PopIR node)
	{

	}

	@Override
	public void visit(LoadIR node)
	{

	}

	@Override
	public void visit(StoreIR node)
	{

	}

	@Override
	public void visit(MoveIR node)
	{

	}
}
