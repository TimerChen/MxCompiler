/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.LHSNode
*/
package MxCompiler.AST;

import MxCompiler.Type.Type;
abstract public class LHSNode extends ExprNode
{

	//private Type type;

	public LHSNode()
	{

	}


	@Override
	public boolean isLValue()
	{
		return true;
	}
}
