/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.ReturnNode
*/


package MxCompiler.AST;

public class ReturnNode extends StmtNode
{
	private ExprNode ret;

	public ReturnNode(SourcePosition pos, ExprNode ret)
	{
		super(pos);
		this.ret = ret;
	}

	public ExprNode ret()
	{
		return ret;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
