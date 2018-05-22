/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.VarLabelIR
*/


package MxCompiler.IR;

public class VarLabelIR extends VarIR
{
	String label;

	public VarLabelIR(String label)
	{
		this.label = label;
	}

	public String label()
	{
		return label;
	}
}
