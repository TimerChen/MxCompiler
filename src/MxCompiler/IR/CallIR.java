/*
	Coded by timemachine on 18-5-20
	MxCompiler.InsIR.CallIR
*/


package MxCompiler.IR;

public class CallIR extends InsIR
{
	private String label;

	public CallIR(String label)
	{
		this.label = label;
	}

	public String label()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
