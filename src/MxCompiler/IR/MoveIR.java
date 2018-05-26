/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.MoveIR
*/


package MxCompiler.IR;

public class MoveIR extends InsIR
{
	private VarIR lhs, rhs;
	private boolean isZX = false;

	public MoveIR(VarIR lhs, VarIR rhs)
	{
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public MoveIR(VarIR lhs, VarIR rhs, boolean isZX)
	{
		this.lhs = lhs;
		this.rhs = rhs;
		this.isZX = isZX;
	}
	public VarIR lhs()
	{
		return lhs;
	}

	public VarIR rhs()
	{
		return rhs;
	}

	public boolean isZX()
	{
		return isZX;
	}

	public void setLhs(VarIR lhs)
	{
		this.lhs = lhs;
	}

	public void setRhs(VarIR rhs)
	{
		this.rhs = rhs;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
