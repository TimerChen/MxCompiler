/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.StringLiteralNode
*/


package MxCompiler.AST;

import MxCompiler.Options;
import MxCompiler.Type.Type;
import MxCompiler.Type.TypeString;

public class StringLiteralNode extends LiteralNode
{
	private String val;

	public StringLiteralNode(SourcePosition position, String val)
	{
		super(Options.typeString, position);
		this.val = val;
	}

	public String val()
	{
		return val;
	}


	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
