/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.StringLitIR
*/


package MxCompiler.IR;

import MxCompiler.Entities.Entity;

public class StringLitIR
{
	static private int idxNumber = 0;
	static private String PREFIX = "STR_";

	private int idx;
	private String val;
	public StringLitIR(String val)
	{
		val = val.replaceAll("\\\\" + "\"" , "\"");
		val = val.replaceAll("\\\\" + "n" , "\n");
		val = val.replaceAll("\\\\" + "\\\\" , "\\\\");
		this.val = val;
		this.idx = idxNumber++;
	}

	public String getLabel()
	{
		return PREFIX + idx;
	}
}
