/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.ForNode
*/


package MxCompiler.AST;

public class ForNode extends StmtNode
{
	private ExprNode init, condi, step;
	private StmtNode body;

	public ForNode(SourcePosition pos, ExprNode init, ExprNode condi, ExprNode step, StmtNode body)
	{
		super(pos);
		this.init = init;
		this.condi = condi;
		this.step = step;
		this.body = body;
	}

	public ExprNode init()
	{
		return init;
	}

	public ExprNode condi()
	{
		return condi;
	}

	public ExprNode step()
	{
		return step;
	}

	public StmtNode body()
	{
		return body;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
