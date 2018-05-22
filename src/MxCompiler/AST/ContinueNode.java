/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.ContinueNode
*/


package MxCompiler.AST;

public class ContinueNode extends StmtNode
{
	private LoopNode loop = null;
	public ContinueNode(SourcePosition pos)
	{
		super(pos);
	}

	public LoopNode loop()
	{
		return loop;
	}

	public void setLoop(LoopNode loop)
	{
		this.loop = loop;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
