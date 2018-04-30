package MxCompiler.AST;

abstract public class StmtNode extends ASTNode
{
	protected SourcePosition position;
	public StmtNode( SourcePosition pos )
	{
		pos = position;
	}

	@Override
	public SourcePosition position()
	{
		return position;
	}

	abstract public <S,E> S accept(ASTVisitor<S,E> visitor);
}
