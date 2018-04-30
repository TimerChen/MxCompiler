package MxCompiler.Type;

public class TypeArray extends Type
{
	int dim;
	Type base;
	TypeArray(Type Base)
	{
		this.size = TypeTable.AddressLength/8;
		this.base = Base;
		if(Base instanceof TypeClass)
			this.dim = 1;
		else
			this.dim = ((TypeArray)Base).dim + 1;
	}
	@Override
	public String toString()
	{
		return base.toString()+"[]";
	}
}