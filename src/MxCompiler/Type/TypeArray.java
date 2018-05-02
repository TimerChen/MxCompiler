package MxCompiler.Type;

import MxCompiler.Util.SemanticError;

public class TypeArray extends Type
{
	private int dim;
	private Type base;
	TypeArray(Type Base)
	{
		this.size = TypeTable.AddressLength/8;
		this.base = Base;
		//...
		//void array
		//if(Base instanceof TypeVoid)
		if(Base instanceof TypeArray)
			this.dim = ((TypeArray)Base).dim + 1;
		else
			this.dim = 1;
	}

	public Type base()
	{
		return base;
	}

	@Override
	public String toString()
	{
		return base.toString()+"[]";
	}
	@Override
	public String toRootString()
	{
		return base.toRootString();
	}
}