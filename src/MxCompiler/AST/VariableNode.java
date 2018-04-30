package MxCompiler.AST;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.VariableNode
*/

import MxCompiler.Entities.VariableEntity;
import MxCompiler.Type.Type;

public class VariableNode extends LHSNode
{
	VariableEntity entity;
	SourcePosition position;

	public VariableNode(Type type, VariableEntity entity, SourcePosition position)
	{
		super(type);
		this.entity = entity;
		this.position = position;
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

