/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.LiteralNode
*/


package MxCompiler.AST;

abstract public class LiteralNode extends ExprNode
{
	SourcePosition position;

	public LiteralNode(SourcePosition position)
	{
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
