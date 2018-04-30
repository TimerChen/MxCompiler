package MxCompiler.AST;

import MxCompiler.Entities.FunctionEntity;

public class FunDefNode extends DefinitionNode
{
	FunctionEntity entity;

	public FunDefNode(SourcePosition pos, FunctionEntity entity)
	{
		super(pos, entity.name());
		this.entity = entity;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
