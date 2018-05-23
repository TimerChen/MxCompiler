/*
	Coded by timemachine on 18-5-24
	MxCompiler.IR.TriIR
*/


package MxCompiler.IR;

public class TriIR extends InsIR
{
	public enum Op
	{
		LT, GT, LE, GE, EQ, NE
	}
	private Op operator;
	private VarRegIR dest, src0, src1;

	public TriIR(Op operator, VarRegIR dest, VarRegIR src0, VarRegIR src1)
	{
		this.operator = operator;
		this.dest = dest;
		this.src0 = src0;
		this.src1 = src1;
	}

	public Op operator()
	{
		return operator;
	}

	public VarRegIR dest()
	{
		return dest;
	}

	public VarRegIR src0()
	{
		return src0;
	}

	public VarRegIR src1()
	{
		return src1;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
