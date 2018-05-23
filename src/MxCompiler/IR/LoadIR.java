/*
	Coded by timemachine on 18-5-21
	MxCompiler.InsIR.LoadIR
*/


package MxCompiler.IR;

public class LoadIR extends InsIR
{
	//move dest [base + index*8]
	VarIR dest, src;

	public LoadIR(VarIR dest, VarIR base, VarIR index)
	{
		this.dest = dest;
		this.src = new VarMemIR(base, index);
	}

	public LoadIR(VarIR dest, VarIR src)
	{
		this.dest = dest;
		this.src = src;
	}

	public VarIR dest()
	{
		return dest;
	}

	public VarIR src()
	{
		return src;
	}
	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
