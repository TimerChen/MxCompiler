/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.UnaryOpNode
*/


package MxCompiler.AST;

import MxCompiler.Type.Type;

abstract public class UnaryOpNode extends ExprNode
{
	public enum UnaryOp {
		PRE_INC, PRE_DEC, SUF_INC, SUF_DEC,
		MINUS, ADD, LOGIC_NOT, BIT_NOT
	}
	UnaryOp operator;
	ExprNode expr;

	public UnaryOpNode(UnaryOp operator, ExprNode expr)
	{
		this.operator = operator;
		this.expr = expr;
	}

	@Override
	public Type type()
	{
		return expr.type();
	}


	@Override
	public SourcePosition position()
	{
		return expr.position();
	}
}
