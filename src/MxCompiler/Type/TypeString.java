package MxCompiler.Type;

public class TypeString extends Type
{
	public TypeString()
	{
		size = TypeTable.AddressLength/8;
	}
	@Override
	public String toString()
	{
		return "string";
	}
}
