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
	protected SourcePosition position;
	protected String name;
	protected Entity refEntity=null;

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
	public boolean isLValue()
	{
		//??? this.val = 1
		if(name.equals("this"))
			return false;
		else
			return true;
	}
	private Type getType()
	{

		if(refEntity instanceof FunctionEntity)
			return Options.typeFunction;
		else
			return refEntity.type();
	}
	@Override
	public Type type()
	{
		if(type == null)
			type = getType();
		return super.type();
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

