/*
	Coded by timemachine on 18-5-21
	MxCompiler.InsIR.LoadIR
*/


package MxCompiler.IR;

public class LoadIR extends InsIR
{
	//move dest [base + index*8]
	VarIR dest, base, index;

	public LoadIR(VarIR dest, VarIR base, VarIR index)
	{
		this.dest = dest;
		this.base = base;
		this.index = index;
	}

	public VarIR dest()
	{
		return dest;
	}

	public VarIR base()
	{
		return base;
	}

	public VarIR index()
	{
		return index;
	}
	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
