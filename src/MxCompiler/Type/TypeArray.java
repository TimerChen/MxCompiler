package MxCompiler.Type;

import MxCompiler.Util.SemanticError;

public class TypeArray extends Type
{
	private int dim;
	private Type base;
	private Type rootType = null;
	public TypeArray(Type Base)
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
	public Type rootType()
	{
		if(rootType == null)
		{
			if(base instanceof TypeArray)
				rootType = ((TypeArray) base).rootType();
			else
				rootType = base;
		}
		return rootType;
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