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
	private VarIR dest, src0, src1;

	public TriIR(Op operator, VarIR dest, VarIR src0, VarIR src1)
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


	public void setDest(VarIR dest)
	{
		this.dest = dest;
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
