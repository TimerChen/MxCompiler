package MxCompiler.Type;

import MxCompiler.AST.SourcePosition;
import MxCompiler.Options;
import MxCompiler.Util.SemanticError;

import javax.swing.text.Position;
import java.util.*;


public class TypeTable
{
	static final int AddressLength = 32;
	//static public Type typeVoid, typeNull, typeBool, typeInt, typeString;
	//static final String VOID_NAME = "void";

	Type currentType;

	public Map<String, Type> typeSet;

	private void init()
	{
		//int bool string
		typeSet.put("void", Options.typeVoid = new TypeVoid());
		typeSet.put("null", Options.typeNull = new TypeNull());
		typeSet.put("bool", Options.typeBool = new TypeBool());
		typeSet.put("int", Options.typeInt = new TypeInt());
		typeSet.put("string", Options.typeString = new TypeString());
		Options.typeFunction = new TypeFunction();
	}

	public TypeTable()
	{
		this.typeSet = new HashMap<String, Type>();
		currentType = null;
		init();
	}
	public Type getType(String name)
	{
		return getType(name, 0);
	}
	public Type getType(String name, int dim)
	{
		Type type;
		if (typeSet.containsKey(name) == false)
		{
			type = new TypeClass(name);
			typeSet.put(name, type);
		}else
			type = typeSet.get(name);
			//throw new RuntimeException("Create existed type.");
		for (int i=1;i<=dim;++i)
			type = type.next();
		return type;
	}
	public void setDefPosition(String name, SourcePosition position)
	{
		if (typeSet.containsKey(name))
			throw new RuntimeException("Type does not existed.");
		TypeClass type = (TypeClass)typeSet.get(name);
		if (type.defPosition != null)
			throw new SemanticError(position, "Class have been defined.");
		type.defPosition = position;
	}
	public boolean isEqual(Type var0, Type var1)
	{
		if(var0 instanceof TypeNull)
		{
			Type tmp = var0;
			var0 = var1;
			var1 = tmp;
		}
		if(var0 != var1)
		{
			if(var1 instanceof TypeNull &&
					(var0 instanceof TypeClass || var0 instanceof TypeArray))
			{
				return true;
			}else
				return false;
		}else
			return true;
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
