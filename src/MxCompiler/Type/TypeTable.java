package MxCompiler.Type;

import java.util.*;


public class TypeTable
{
	static final int AddressLength = 32;
	//static final String VOID_NAME = "void";

	Type currentType;

	public Map<String, Type> typeSet;

	private void init()
	{
		//int bool string
		typeSet.put("void", new TypeVoid());
		typeSet.put("null", new TypeNull());
		typeSet.put("bool", new TypeBool());
		typeSet.put("int", new TypeInt());
		typeSet.put("string", new TypeString());
	}

	public TypeTable()
	{
		this.typeSet = new HashMap<String, Type>();
		currentType = null;
		init();
	}
	public Type creatNewType(String name, int size)
	{
		if (typeSet.containsKey(name))
			throw new RuntimeException("Create existed type.");
		TypeClass newType = new TypeClass(name, size);
		typeSet.put(name, newType);
		return newType;
	}
	/*
	public Type setCurrentType(String name)
	{
		return setCurrentType(name, 0);
	}
	public Type setCurrentType(String name, int deepth)
	{
		Type type = typeSet.get(name);
		setCurrentType(type, deepth);
		return type;
	}
	public void setCurrentType(Type idx, int deepth)
	{
		currentType = typeSet.get(idx);
		currentToArray(deepth);
	}
	Type currentToArray()
	{
		return currentToArray(1);
	}
	Type currentToArray(int deepth)
	{
		if(deepth == 0)
			return currentType;
		if(deepth < 0)
			throw new RuntimeException("Deepth of array cannot be minus number.");
		if(currentType == null)
			throw new RuntimeException("No void array.");

		for(int i=1;i<=deepth;++i)
		{
			if (currentType.next != null)
				currentType = currentType.next;
			else
				currentType = createNewArrayType(currentType);
		}
		return currentType;
	}
	private Type createNewArrayType( Type currentType )
	{
		if(currentType.next != null)
			throw new RuntimeException("Create an existed array type.");

		TypeArray newType = new TypeArray(currentType);
		//typeSet.put(newType);
		newType.base = currentType;
		currentType.next = newType;
		return newType;
	}
	public Type getCurretType()
	{
		return currentType;
	}
	*/

}
