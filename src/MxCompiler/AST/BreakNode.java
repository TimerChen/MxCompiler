/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.BreakNode
*/


package MxCompiler.AST;

public class BreakNode extends StmtNode
{
	public BreakNode(SourcePosition pos)
	{
		super(pos);
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
