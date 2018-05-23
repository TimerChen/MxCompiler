/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.PushIR
*/


package MxCompiler.IR;

public class PushIR extends InsIR
{
	private VarIR src;

	public PushIR(VarIR src)
	{
		this.src = src;
	}

	public VarIR src()
	{
		return src;
	}

	public void setSrc(VarIR src)
	{
		this.src = src;
	}
	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
