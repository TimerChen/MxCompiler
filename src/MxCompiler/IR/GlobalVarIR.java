/*
	Coded by timemachine on 18-5-30
	MxCompiler.IR.GlobalVarIR
*/


package MxCompiler.IR;

public class GlobalVarIR
{
	public GlobalVarIR(String label)
	{
		this.label = label;
	}

	private String label;
	public String toCodeStr()
	{
		return label +":\tresb\t8";
	}
}
