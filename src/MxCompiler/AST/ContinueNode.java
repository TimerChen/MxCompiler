/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.ContinueNode
*/


package MxCompiler.AST;

public class ContinueNode extends StmtNode
{
	public ContinueNode(SourcePosition pos)
	{
		super(pos);
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
