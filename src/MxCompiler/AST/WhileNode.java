/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.WhileNode
*/


package MxCompiler.AST;

public class WhileNode extends StmtNode
{
	private ExprNode condi;

	public WhileNode(SourcePosition pos, ExprNode condi)
	{
		super(pos);
		this.condi = condi;
	}

	public ExprNode condi()
	{
		return condi;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
