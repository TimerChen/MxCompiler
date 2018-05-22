/*
	Coded by timemachine on 18-5-23
	MxCompiler.CodeGen.NASMTranslator
*/


package MxCompiler.CodeGen;

import MxCompiler.IR.*;

import java.util.*;

public class NASMTranslator implements IRVisitor
{
	List<InsIR> insIrList;
	public NASMTranslator()
	{

	}
	void visit(List<InsIR> list)
	{
		for(InsIR i: list)
		{

		}
	}

	@Override
	public void visit(AlignIR node)
	{

	}

	@Override
	public void visit(BinaryIR node)
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
