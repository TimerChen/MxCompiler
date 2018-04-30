/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.ArefNode
*/


package MxCompiler.AST;

import MxCompiler.Type.Type;

public class ArefNode extends LHSNode
{
	ExprNode ref, index;

	public ArefNode(ExprNode ref, ExprNode index)
	{
		super(ref.type().next());
		this.ref = ref;
		this.index = index;
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}

	@Override
	public SourcePosition position()
	{
		return ref.position();
	}
}
