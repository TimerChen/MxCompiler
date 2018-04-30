package MxCompiler.Entities;
import MxCompiler.AST.SourcePosition;
import MxCompiler.Type.Type;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.Entities.ParameterEntity
*/

public class ParameterEntity extends Entity
{
	public ParameterEntity(String name, Type type, SourcePosition position)
	{
		super(name, type, position);
	}
}
