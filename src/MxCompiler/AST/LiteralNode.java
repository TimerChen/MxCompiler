/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.LiteralNode
*/


package MxCompiler.AST;

import MxCompiler.Type.Type;

abstract public class LiteralNode extends ExprNode
{
	SourcePosition position;

	public LiteralNode(Type type, SourcePosition position)
	{
		super(type);
		this.position = position;
	}

	@Override
	public boolean isConst()
	{
		return true;
	}

	@Override
	public SourcePosition position()
	{
		return position;
	}
}
