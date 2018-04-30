/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.IntLiteralNode
*/


package MxCompiler.AST;

import MxCompiler.Type.Type;
import MxCompiler.Type.TypeInt;

public class IntLiteralNode extends LiteralNode
{
	private int val;

	public IntLiteralNode(SourcePosition position, int val)
	{
		super(position);
		this.val = val;
	}

	public int val()
	{
		return val;
	}

	@Override
	public Type type()
	{
		return new TypeInt();
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}

}
