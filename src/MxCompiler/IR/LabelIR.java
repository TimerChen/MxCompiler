/*
	Coded by timemachine on 18-5-20
	MxCompiler.InsIR.LabelIR
*/


package MxCompiler.IR;

public class LabelIR extends InsIR
{
	private String label;

	public LabelIR(String label)
	{
		this.label = label;
	}

	public String label()
	{
		return label;
	}
	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
