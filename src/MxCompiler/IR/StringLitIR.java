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
	private int length;
	public StringLitIR(String val)
	{
		Debuger.printInfo("val", val);
		this.val = initVal(val);
		this.idx = idxNumber++;
	}
	private String initVal(String val)
	{

		length = val.length()-2;
		int tmp0, tmp1;
		tmp0 = val.length();
		val = val.replaceAll("\\\\" + "\"" , "\", 34, \"");
		tmp1 = val.length();
		length -= (tmp1-tmp0)/6;
		tmp0=tmp1;
		val = val.replaceAll("\\\\" + "n" , "\", 10, \"");
		tmp1 = val.length();
		length -= (tmp1-tmp0)/6;
		tmp0 = tmp1;
		val = val.replaceAll("\\\\" + "\\\\" , "\", 92, \"");
		tmp1 = val.length();
		length -= (tmp1-tmp0)/6;
		String pa = "\\\"\\\", ";
		Debuger.printInfo("pattern", val);
		val = val.replaceAll("\"\", ","");
		val = val.replaceAll(", \"\"","");
		return val;
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
		String lengthS = "\tdd " + (length) + "\n",
				content = "\tdb "+ val + ", 0";
		return lengthS + label +":\n" +  content;
	}
}
