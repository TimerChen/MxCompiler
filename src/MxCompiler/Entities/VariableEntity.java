package MxCompiler.Entities;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.Entities.VariableEntity
*/

import MxCompiler.AST.ExprNode;
import MxCompiler.AST.SourcePosition;
import MxCompiler.Type.Type;

public class VariableEntity extends Entity
{
	ExprNode init;

	public VariableEntity(String name, Type type, SourcePosition position, ExprNode init)
	{
		super(name, type, position);
		this.init = init;
	}
	public void setType(Type type)
	{
		this.type = type;
	}
	public ExprNode init()
	{
		return init;
	}
}
