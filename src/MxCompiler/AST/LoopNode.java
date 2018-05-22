/*
	Coded by timemachine on 18-5-2
	MxCompiler.AST.LoopNode
*/


package MxCompiler.AST;

import MxCompiler.IR.VarLabelIR;

import java.util.LinkedList;
import java.util.List;

abstract public class LoopNode extends StmtNode
{
	VarLabelIR continueLabel, exitLabel;
	public LoopNode(SourcePosition pos, StmtNode body)
	{
		super(pos);
		if(body instanceof BlockNode)
		{
			this.body = (BlockNode) body;
		}else
		{
			List<StmtNode> list = new LinkedList<>();
			list.add(body);
			this.body = new BlockNode(pos, list, null);
		}

	}

	public void setLabels(VarLabelIR continueLabel, VarLabelIR exitLabel)
	{
		this.continueLabel = continueLabel;
		this.exitLabel = exitLabel;
	}

	public VarLabelIR continueLabel()
	{
		return continueLabel;
	}

	public VarLabelIR exitLabel()
	{
		return exitLabel;
	}

	protected BlockNode body;

	public BlockNode body()
	{
		return body;
	}
}
