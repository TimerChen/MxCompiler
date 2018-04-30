/*
	Coded by timemachine on 18-4-28
	MxCompiler.Util.SemanticError
*/


package MxCompiler.Util;

import MxCompiler.AST.SourcePosition;

public class SemanticError extends RuntimeException
{
	public SemanticError(SourcePosition pos, String str)
	{
		super(pos.toString() + " " + str);
	}

	@Override
	public String toString()
	{
		return "Semantic Error: "+ getLocalizedMessage();
	}
}
