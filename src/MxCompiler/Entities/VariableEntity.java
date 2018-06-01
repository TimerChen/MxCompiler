package MxCompiler.Entities;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.Entities.VariableEntity
*/

import MxCompiler.AST.ExprNode;
import MxCompiler.AST.SourcePosition;
import MxCompiler.Type.Type;

public class VariableEntity extends ParameterEntity
{
	private ExprNode init;

	public VariableEntity(String name, Type type, SourcePosition position, ExprNode init)
	{
		super(name, type, position);
		this.init = init;
	}
	public VariableEntity(ParameterEntity pe)
	{
		super(pe.name, pe.type, pe.position);
		this.init = null;
	}



	public void setType(Type type)
	{
		this.type = type;
	}
	public ExprNode init()
	{
		return init;
	}

	public void setInit(ExprNode init)
	{
		this.init = init;
	}
}
