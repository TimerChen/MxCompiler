package MxCompiler.Type;

import MxCompiler.AST.SourcePosition;

public class TypeClass extends Type
{
	private String name;
	public SourcePosition defPosition;

	public TypeClass(String name)
	{
		this.name = name;
		this.defPosition = null;
	}

	public String name()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}