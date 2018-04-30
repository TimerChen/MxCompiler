package MxCompiler.AST;

abstract public class DefinitionNode extends StmtNode
{
	protected String name;
	public DefinitionNode(SourcePosition pos, String name)
	{
		super(pos);
		this.name = name;

	}
	public String name()
	{
		return name;
	}
}
