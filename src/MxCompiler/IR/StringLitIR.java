/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.StringLitIR
*/


package MxCompiler.IR;

import MxCompiler.Entities.Entity;
import MxCompiler.tools.Debuger;

public class StringLitIR
{
	static private int idxNumber = 0;
	static private String PREFIX = "STR_";

	private int idx;
	private String val;
	public StringLitIR(String val)
	{
		Debuger.printInfo("val", val);;
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

	public String val()
	{
		return val;
	}
	public String toCodeStr(String label)
	{
		//???
		String length = "\tdd " + (val.length()-2) + "\n",
				content = "\tdb "+ val + ", 0";

		return length + label +":\n" +  content;
	}
}
