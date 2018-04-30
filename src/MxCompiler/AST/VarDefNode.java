package MxCompiler.AST;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.VarDefNode
*/

import MxCompiler.Entities.VariableEntity;

public class VarDefNode extends DefinitionNode
{
	private VariableEntity entity;

	public VarDefNode(SourcePosition pos, String name, VariableEntity entity)
	{
		super(pos, name);
		this.entity = entity;
	}

	public VariableEntity entity()
	{
		return entity;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
