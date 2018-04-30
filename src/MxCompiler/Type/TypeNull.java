package MxCompiler.Type;

public class TypeNull extends Type
{
	public TypeNull()
	{
		size = TypeTable.AddressLength/8;
	}

	@Override
	public String toString()
	{
		return "null";
	}
}
