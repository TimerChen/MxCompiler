/*
	Coded by timemachine on 18-5-24
	MxCompiler.CodeGen.NaiveAllocator
*/


package MxCompiler.CodeGen;

import MxCompiler.AST.VariableNode;
import MxCompiler.IR.*;

import java.util.*;

public class NaiveAllocator implements IRVisitor
{
	private List<List<InsIR>> irLists;
	private Map<String,Integer> usePos;
	private Map<Integer, Integer> nowDefPos;
	private int nowLine;
	enum Phase
	{
		PreCollect,
		Alloc
	}
	Phase nowPhase;

	public NaiveAllocator(List<List<InsIR>> irLists)
	{
		this.irLists = irLists;
		usePos = new HashMap<>();
		nowDefPos = new HashMap<>();
	}

	public List<InsIR> alloc()
	{
		List<InsIR> irList=null;// = new ArrayList<InsIR>(this.irLists);
		int n = irList.size();

		nowPhase = Phase.PreCollect;
		for(int i=n-1;i>0;--i)
		{
			nowLine = i;
			irList.get(i).accept(this);
		}
		for(int i=n-1;i>0;--i)
		{


		}
		nowPhase = Phase.Alloc;
		return irList;
	}
	String sVar(VarRegIR var, int line)
	{
		return var.regIndex() + "_" + line;
	}
	void setUse(VarIR oVar)
	{
		if(oVar == null) return;
		if(oVar instanceof VarMemIR)
		{
			VarMemIR var = (VarMemIR) oVar;
			setUse(var.base());
			setUse(var.index());
			return;
		}
		if(!(oVar instanceof VarRegIR))
			return;
		VarRegIR var = (VarRegIR) oVar;
		if(!nowDefPos.containsKey(var.regIndex()))
			return;
		int def = nowDefPos.get(var.regIndex());
		String sVar = sVar(var, nowLine);
		usePos.put(sVar, def);
		nowDefPos.remove(var.regIndex());
	}
	void setDef(VarIR oVar)
	{
		if(oVar == null) return;
		if(oVar instanceof VarMemIR)
		{
			VarMemIR var = (VarMemIR) oVar;
			setUse(var.base());
			setUse(var.index());
			return;
		}
		if(!(oVar instanceof VarRegIR))
			return;
		VarRegIR var = (VarRegIR) oVar;
		nowDefPos.put(var.regIndex(), nowLine);
	}
	void setMDef(VarIR oVar)
	{
		if(oVar == null) return;
		if(!(oVar instanceof VarMemIR))
			return;
		VarMemIR var = (VarMemIR) oVar;
		setDef(var.base());
		setDef(var.index());
		return;
	}
	void setCollection(VarIR dest0, VarIR dest1, VarIR src0, VarIR src1)
	{
		//use
		setUse(dest0);
		setUse(dest1);
		setUse(src0);
		setUse(src1);
		//def
		setMDef(dest0);
		setMDef(dest1);
		setDef(src0);
		setDef(src1);

	}
	@Override
	public void visit(AlignIR node)
	{
		//noting
	}

	@Override
	public void visit(TriIR node)
	{
		switch (nowPhase)
		{
			case PreCollect:
			{
				setCollection(node.dest(), null, node.src0(), node.src1());
			}break;
			case Alloc:
			{

			}break;
		}
	}

	@Override
	public void visit(BinaryIR node)
	{
		switch (nowPhase)
		{
			case PreCollect:
			{
				setCollection(node.lhs(), null, node.lhs(), node.rhs());
			}break;
			case Alloc:
			{

			}break;
		}
	}

	@Override
	public void visit(UnaryIR node)
	{
		switch (nowPhase)
		{
			case PreCollect:
			{
				//use
				if(node.has2Dest())
				{
					setCollection(node.dest0(), node.dest1(), node.src(), null);
				}else
					setCollection(node.src(), null, node.src(), null);
			}break;
			case Alloc:
			{

			}break;
		}
	}

	@Override
	public void visit(CJumpIR node)
	{
		switch (nowPhase)
		{
			case PreCollect:
			{
				setCollection(null, null, node.lhs(), node.rhs());
			}break;
			case Alloc:
			{

			}break;
		}
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
		switch (nowPhase)
		{
			case PreCollect:
			{

				setCollection(null, null, node.src(), null);
			}break;
			case Alloc:
			{

			}break;
		}
	}

	@Override
	public void visit(PopIR node)
	{
		switch (nowPhase)
		{
			case PreCollect:
			{
				setCollection(node.dest(), null, null, null);

			}break;
			case Alloc:
			{

			}break;
		}
	}

	@Override
	public void visit(LoadIR node)
	{
		switch (nowPhase)
		{
			case PreCollect:
			{
				setCollection(node.dest(), null, node.src(), null);
			}break;
			case Alloc:
			{

			}break;
		}
	}

	@Override
	public void visit(StoreIR node)
	{
		switch (nowPhase)
		{
			case PreCollect:
			{
				setCollection(node.dest(), null, node.src(), null);
			}break;
			case Alloc:
			{

			}break;
		}
	}

	@Override
	public void visit(MoveIR node)
	{
		switch (nowPhase)
		{
			case PreCollect:
			{
				setCollection(node.lhs(), null, node.rhs(), null);
			}break;
			case Alloc:
			{

			}break;
		}
	}

	@Override
	public void visit(SpecialIR node)
	{
		//Nothing
	}
}
