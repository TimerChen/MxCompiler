/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.MemberNode
*/


package MxCompiler.AST;

import MxCompiler.Type.Type;

public class MemberNode extends LHSNode
{
	private ExprNode parent;
	private SourcePosition position;

	public MemberNode(Type type, ExprNode parent, SourcePosition position)
	{
		super(type);
		this.parent = parent;
		this.position = position;
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
