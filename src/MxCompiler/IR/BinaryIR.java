/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.BinaryIR
*/


package MxCompiler.IR;

public class BinaryIR extends InsIR
{
	public enum Op
	{
		ADD, SUB, MUL, DIV, MOD, LSHIFT, RSHIFT,
		LT, GT, LE, GE, EQ, NE, AND, XOR, OR, NEG, NOT
	}
	Op operator;
	VarIR lhs, rhs;

	public BinaryIR(Op operator, VarIR lhs, VarIR rhs)
	{
		this.operator = operator;
		this.lhs = lhs;
		this.rhs = rhs;
	}
	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
