package MxCompiler.AST;


import MxCompiler.Entities.ClassEntity;

public class ClassDefNode extends DefinitionNode
{
	private ClassEntity entity;
	public ClassDefNode(SourcePosition pos, ClassEntity ent)
	{
		super(ent.position(), ent.name());
		this.entity = ent;
	}
	public SourcePosition position()
	{
		return entity.position();
	}

	public ClassEntity entity()
	{
		return entity;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
