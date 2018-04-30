/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.PrefixOpNode
*/


package MxCompiler.AST;

public class PrefixOpNode extends UnaryOpNode
{
	public PrefixOpNode(UnaryOp operator, ExprNode expr)
	{
		super(operator, expr);
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
