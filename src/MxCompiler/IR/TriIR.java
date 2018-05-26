/*
	Coded by timemachine on 18-5-24
	MxCompiler.IR.TriIR
*/


package MxCompiler.IR;

public class TriIR extends InsIR
{
	static final VarRegIR dest = new VarRegIR(0);
	public enum Op
	{
		LT, GT, LE, GE, EQ, NE
	}
	private Op operator;
	private VarIR src0, src1;

	public TriIR(Op operator, VarIR src0, VarIR src1)
	{
		this.operator = operator;
		this.src0 = src0;
		this.src1 = src1;
	}

	public Op operator()
	{
		return operator;
	}

	public VarIR dest()
	{
		return dest;
	}

	public VarIR src0()
	{
		return src0;
	}

	public VarIR src1()
	{
		return src1;
	}



	public void setSrc0(VarIR src0)
	{
		this.src0 = src0;
	}

	public void setSrc1(VarIR src1)
	{
		this.src1 = src1;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
