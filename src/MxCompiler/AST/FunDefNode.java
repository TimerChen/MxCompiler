package MxCompiler.AST;

import MxCompiler.Entities.FunctionEntity;

public class FunDefNode extends DefinitionNode
{
	private FunctionEntity entity;

	public FunDefNode(SourcePosition pos, FunctionEntity entity)
	{
		super(pos, entity.name());
		this.entity = entity;
	}

	public FunctionEntity entity()
	{
		return entity;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
