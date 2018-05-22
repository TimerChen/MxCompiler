/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.ExprStmtNode
*/


package MxCompiler.AST;

public class ExprStmtNode extends StmtNode
{
	private ExprNode expr;

	public ExprStmtNode(SourcePosition pos, ExprNode expr)
	{
		super(pos);
		this.expr = expr;
	}

	public ExprNode expr()
	{
		return expr;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
