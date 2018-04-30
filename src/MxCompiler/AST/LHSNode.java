/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.LHSNode
*/
package MxCompiler.AST;

import MxCompiler.Type.Type;
abstract public class LHSNode extends ExprNode
{

	protected Type type;

	public LHSNode(Type type)
	{
		this.type = type;
	}

	@Override
	public Type type()
	{
		return type;
	}


	@Override
	public boolean isLValue()
	{
		return true;
	}
}
