/*
	Coded by timemachine on 18-5-1
	MxCompiler.Entities.StringLiteralEntity
*/


package MxCompiler.Entities;

import MxCompiler.AST.SourcePosition;
import MxCompiler.Type.Type;

public class StringLiteralEntity extends Entity
{
	String val;

	public StringLiteralEntity(String name, Type type, SourcePosition position, String val)
	{
		super(name, type, position);
		this.val = val.substring(1,val.length()-1);
	}
}
