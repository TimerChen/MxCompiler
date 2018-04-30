/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.CreatorNode
*/


package MxCompiler.AST;

import MxCompiler.Entities.ClassEntity;
import MxCompiler.Type.Type;

import java.util.List;

public class CreatorNode extends ExprNode
{
	Type type;
	List<ExprNode> args;
	SourcePosition position;

	public CreatorNode(Type type, List<ExprNode> args, SourcePosition position)
	{
		this.type = type;
		this.args = args;
		this.position = position;
	}

	@Override
	public Type type()
	{
		return type;
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}

	@Override
	public SourcePosition position()
	{
		return position;
	}
}
