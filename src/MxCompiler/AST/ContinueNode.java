/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.ContinueNode
*/


package MxCompiler.AST;

public class ContinueNode extends StmtNode
{
	public LoopNode loop = null;
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
