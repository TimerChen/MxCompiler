/*
	Coded by timemachine on 18-5-26
	MxCompiler.CodeGen.IRRewriter
*/


package MxCompiler.CodeGen;

import MxCompiler.IR.*;
import MxCompiler.tools.Debuger;

import java.util.*;

public class IRRewriter implements IRVisitor
{
	private List<List<Integer>> colors;
	private List<BasicBlock> blkLists;

	private List<Integer> nowColor;

	public IRRewriter(List<List<Integer>> colors, List<BasicBlock> irs)
	{
		this.colors = colors;
		this.blkLists = irs;
	}
	public void rewrite()
	{
		for(int i=0; i<blkLists.size(); ++i)
		{
			BasicBlock now = blkLists.get(i);
			Debuger.printInfo("size","");
			nowColor = colors.get(i);
			while(now != null)
			{
				List<InsIR> irList = now.irList();
				int n = irList.size();
				for(int j=0; j<n; ++j)
				{
					InsIR ir = irList.get(j);
					ir.accept(this);
				}
				now = now.next0();
			}

		}
	}


	VarIR colorIR(VarIR oVar)
	{
		if(oVar instanceof VarRegIR)
		{
			VarRegIR var = (VarRegIR)oVar;
			int i = var.regIndex();
			if(nowColor.get(i) == -1)
			{
				return new VarMemIR(new VarRegIR(4), new VarIntIR(i));
			}else
			{
				return new VarRegIR(nowColor.get(i));
			}
		}else
			return oVar;
	}
	@Override
	public void visit(AlignIR node)
	{
		//Nothing
	}

	@Override
	public void visit(TriIR node)
	{
		node.setDest(colorIR(node.dest()));
		node.setSrc0(colorIR(node.src0()));
		node.setSrc1(colorIR(node.src1()));
	}

	@Override
	public void visit(BinaryIR node)
	{
		node.setLhs(colorIR(node.lhs()));
		node.setRhs(colorIR(node.rhs()));
	}

	@Override
	public void visit(UnaryIR node)
	{
		node.setSrc(colorIR(node.src()));
	}

	@Override
	public void visit(CJumpIR node)
	{
		node.setLhs(colorIR(node.lhs()));
		node.setRhs(colorIR(node.rhs()));
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
		node.setSrc(colorIR(node.src()));
	}

	@Override
	public void visit(PopIR node)
	{
		node.setDest(colorIR(node.dest()));
	}

	@Override
	public void visit(LoadIR node)
	{
		node.setDest(colorIR(node.dest()));
	}

	@Override
	public void visit(StoreIR node)
	{
		node.setSrc(colorIR(node.src()));
	}

	@Override
	public void visit(MoveIR node)
	{
		node.setLhs(colorIR(node.lhs()));
		node.setRhs(colorIR(node.rhs()));
	}
}
