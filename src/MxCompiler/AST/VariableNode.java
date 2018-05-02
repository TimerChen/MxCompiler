package MxCompiler.AST;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.VariableNode
*/

import MxCompiler.Entities.Entity;
import MxCompiler.Entities.FunctionEntity;
import MxCompiler.Entities.VariableEntity;
import MxCompiler.Options;
import MxCompiler.Type.Type;

public class VariableNode extends LHSNode
{
	private SourcePosition position;
	private String name;
	private Entity refEntity;

	public VariableNode(String name, SourcePosition position)
	{
		this.position = position;
		this.name = name;
		refEntity = null;
	}

	public String name()
	{
		return name;
	}


	public void setRefEntity(Entity refEntity)
	{
		this.refEntity = refEntity;
	}

	public Entity refEntity()
	{
		return refEntity;
	}

	@Override
	public Type type()
	{
		if(refEntity instanceof FunctionEntity)
			return Options.typeFunction;
		else
			return refEntity.type();
	}


	@Override
	public SourcePosition position()
	{
		return position;
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}


}

