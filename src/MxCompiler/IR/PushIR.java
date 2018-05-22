/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.PushIR
*/


package MxCompiler.IR;

public class PushIR extends InsIR
{
	private VarIR val;

	public PushIR(VarIR val)
	{
		this.val = val;
	}

	public VarIR val()
	{
		return val;
	}

	public void setVal(VarIR val)
	{
		this.val = val;
	}
	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
