/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.BoolLiteralNode
*/


package MxCompiler.AST;

import MxCompiler.Options;
import MxCompiler.Type.Type;
import MxCompiler.Type.TypeBool;

public class BoolLiteralNode extends LiteralNode
{
	boolean val;

	public BoolLiteralNode(SourcePosition position, boolean val)
	{
		super(position);
		this.val = val;
	}

	public boolean val()
	{
		return val;
	}

	@Override
	public Type type()
	{
		return Options.typeBool;
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}

}
