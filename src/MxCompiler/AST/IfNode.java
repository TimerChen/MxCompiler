/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.IfNode
*/


package MxCompiler.AST;


public class IfNode extends StmtNode
{
	private ExprNode Condi;
	private BlockNode trueBody, falseBody;

	public IfNode(SourcePosition pos, ExprNode condi, StmtNode trueBody, StmtNode falseBody)
	{
		super(pos);
		Condi = condi;
		if(trueBody instanceof BlockNode)
			this.trueBody = (BlockNode) trueBody;
		else
			this.trueBody = new BlockNode(trueBody);
		if(falseBody == null)
			this.falseBody = null;
		else if(falseBody instanceof BlockNode)
			this.falseBody = (BlockNode) falseBody;
		else
			this.falseBody = new BlockNode(falseBody);
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
