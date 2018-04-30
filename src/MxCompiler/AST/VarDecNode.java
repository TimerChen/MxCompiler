package MxCompiler.AST;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.VarDefNode
*/

import MxCompiler.Entities.VariableEntity;
import MxCompiler.Type.Type;

import java.util.List;

public class VarDecNode extends StmtNode
{
	private Type type;
	private List<VariableEntity> entity;

	public VarDecNode(SourcePosition pos, Type type, List<VariableEntity> entity)
	{
		super(pos);
		this.type = type;
		this.entity = entity;
	}

	public Type type()
	{
		return type;
	}

	public List<VariableEntity> entity()
	{
		return entity;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
