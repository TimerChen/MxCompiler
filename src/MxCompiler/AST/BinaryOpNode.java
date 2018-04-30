package MxCompiler.AST;

import MxCompiler.Type.Type;

public class BinaryOpNode extends ExprNode
{
	public enum BinaryOp
	{
		ADD, SUB, MUL, DIV, MOD,
		LSHIFT, RSHIFT, LT, GT, LE, GE, EQ, NE,
		BIT_AND, BIT_XOR, BIT_OR,
		LOGIC_AND, LOGIC_OR
	}
	ExprNode left, right;
	BinaryOp operator;

	public BinaryOpNode(ExprNode left, ExprNode right, BinaryOp operator)
	{
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

	@Override
	public Type type()
	{
		return left.type();
	}

	@Override
	public SourcePosition position()
	{
		return left.position();
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
