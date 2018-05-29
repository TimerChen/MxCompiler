package MxCompiler.Type;

import MxCompiler.AST.SourcePosition;
import MxCompiler.Entities.ClassEntity;

public class TypeClass extends Type
{
	private String name;
	public SourcePosition defPosition;

	private ClassEntity refEntity;


	public TypeClass(String name)
	{
		this.name = name;
		this.defPosition = null;
		this.refEntity = null;
	}

	public String name()
	{
		return name;
	}

	public ClassEntity refEntity()
	{
		return refEntity;
	}

	public void setRefEntity(ClassEntity refEntity)
	{
		this.refEntity = refEntity;
	}

	@Override
	public String toString()
	{
		return name;
	}
}