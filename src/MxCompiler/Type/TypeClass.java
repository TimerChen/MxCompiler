package MxCompiler.Type;

public class TypeClass extends Type
{
	String name;
	TypeClass(String Name, int Size)
	{
		this.name = Name;
		this.size = Size;
	}
	@Override
	public String toString()
	{
		return name;
	}
}