/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.ReturnNode
*/


package MxCompiler.AST;

import MxCompiler.Entities.Entity;
import MxCompiler.Entities.FunctionEntity;
import MxCompiler.IR.VarLabelIR;
import MxCompiler.tools.Debuger;

public class ReturnNode extends StmtNode
{
	private ExprNode ret;
	private FunDefNode function;

	public ReturnNode(SourcePosition pos, ExprNode ret)
	{
		super(pos);
		this.ret = ret;
	}

	public FunDefNode function()
	{
		return function;
	}

	public void setFunction(FunDefNode function)
	{
		this.function = function;
	}

	public ExprNode ret()
	{
		return ret;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
