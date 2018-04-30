/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.ArefNode
*/


package MxCompiler.AST;

import MxCompiler.Type.Type;

public class ArefNode extends LHSNode
{
	ExprNode var, index;

	public ArefNode(ExprNode var, ExprNode index)
	{
		super(var.type().next());
		this.var = var;
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
		return var.position();
	}
}
