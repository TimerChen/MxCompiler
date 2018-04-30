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
	private SourcePosition position;
	private Type type;
	private List<ExprNode> args;
	private int dim;

	public CreatorNode(SourcePosition position, Type type, List<ExprNode> args, int dim)
	{
		this.position = position;
		this.type = type;
		this.args = args;
		this.dim = dim;
	}

	public List<ExprNode> args()
	{
		return args;
	}

	public int dim()
	{
		return dim;
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
