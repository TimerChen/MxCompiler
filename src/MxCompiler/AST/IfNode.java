/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.IfNode
*/


package MxCompiler.AST;

public class IfNode extends StmtNode
{
	private ExprNode Condi;
	private StmtNode trueBody, falseBody;

	public IfNode(SourcePosition pos, ExprNode condi, StmtNode trueBody, StmtNode falseBody)
	{
		super(pos);
		Condi = condi;
		this.trueBody = trueBody;
		this.falseBody = falseBody;
	}

	public ExprNode condi()
	{
		return Condi;
	}

	public StmtNode trueBody()
	{
		return trueBody;
	}

	public StmtNode falseBody()
	{
		return falseBody;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
