/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.PopIR
*/


package MxCompiler.IR;

public class PopIR extends InsIR
{
	VarIR dest;

	public PopIR(VarIR dest)
	{
		this.dest = dest;
	}

	public VarIR dest()
	{
		return dest;
	}

	public void setDest(VarIR dest)
	{
		this.dest = dest;
	}
	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
