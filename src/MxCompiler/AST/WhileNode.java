/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.WhileNode
*/


package MxCompiler.AST;

public class WhileNode extends StmtNode
{
	private ExprNode condi;
	private StmtNode body;

	public WhileNode(SourcePosition pos, ExprNode condi, StmtNode body)
	{
		super(pos);
		this.condi = condi;
		this.body = body;
	}

	public StmtNode body()
	{
		return body;
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
