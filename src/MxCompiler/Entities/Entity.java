package MxCompiler.Entities;
import MxCompiler.AST.SourcePosition;
import MxCompiler.Type.Type;

public class Entity extends Object
{
	protected String name;
	protected Type type;
	protected SourcePosition position;

	public Entity(String name, Type type, SourcePosition position)
	{
		this.name = name;
		this.type = type;
		this.position = position;
	}

	public String name()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Type type()
	{
		return type;
	}

	public void setType(Type type)
	{
		this.type = type;
	}

	public SourcePosition position()
	{
		return position;
	}

	public void setPosition(SourcePosition position)
	{
		this.position = position;
	}
}
