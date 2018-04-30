/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.StringLiteralNode
*/


package MxCompiler.AST;

import MxCompiler.Type.Type;
import MxCompiler.Type.TypeString;

public class StringLiteralNode extends LiteralNode
{
	private String val;

	public StringLiteralNode(SourcePosition position, String val)
	{
		super(position);
		this.val = val;
	}

	public String val()
	{
		return val;
	}

	@Override
	public Type type()
	{
		return new TypeString();
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return null;
	}
}
