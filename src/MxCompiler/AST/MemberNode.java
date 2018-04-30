/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.MemberNode
*/


package MxCompiler.AST;

import MxCompiler.Type.Type;

public class MemberNode extends LHSNode
{
	private ExprNode parent;
	private String name;
	private SourcePosition position;

	public MemberNode(ExprNode parent, String name, SourcePosition position)
	{
		super(null);
		this.parent = parent;
		this.name = name;
		this.position = position;
	}

	public ExprNode parent()
	{
		return parent;
	}

	public String name()
	{
		return name;
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
