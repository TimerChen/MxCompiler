/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.IfNode
*/


package MxCompiler.AST;

public class IfNode extends StmtNode
{
	private ExprNode Condi;
	private BlockNode trueBody, falseBody;

	public IfNode(SourcePosition pos, ExprNode condi, BlockNode trueBody, BlockNode falseBody)
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

	public BlockNode trueBody()
	{
		return trueBody;
	}

	public BlockNode falseBody()
	{
		return falseBody;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
