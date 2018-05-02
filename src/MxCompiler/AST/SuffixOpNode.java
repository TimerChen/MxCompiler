/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.SuffixOpNode
*/


package MxCompiler.AST;

public class SuffixOpNode extends UnaryOpNode
{
	public SuffixOpNode(SourcePosition position, UnaryOp operator, ExprNode expr)
	{
		super(position, operator, expr);
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
