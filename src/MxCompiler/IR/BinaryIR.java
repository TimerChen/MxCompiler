/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.BinaryIR
*/


package MxCompiler.IR;

public class BinaryIR extends InsIR
{
	public enum Op
	{
		ADD, SUB, LSHIFT, RSHIFT,
		AND, XOR, OR
	}
	private Op operator;
	private VarIR lhs, rhs;

	public BinaryIR(Op operator, VarIR lhs, VarIR rhs)
	{
		this.operator = operator;
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Op operator()
	{
		return operator;
	}

	public VarIR lhs()
	{
		return lhs;
	}

	public VarIR rhs()
	{
		return rhs;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
