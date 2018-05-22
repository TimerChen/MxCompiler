/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.VarRegIR
*/


package MxCompiler.IR;

import java.util.List;

public class VarRegIR extends VarIR
{
	public VarRegIR(int regIndex)
	{
		this.regIndex = regIndex;
	}

	public VarRegIR(List<InsIR> insIrList, int regIndex)
	{
		super(insIrList);
		this.regIndex = regIndex;
	}

	private int regIndex;

	public int regIndex()
	{
		return regIndex;
	}

	public void setRegIndex(int regIndex)
	{
		this.regIndex = regIndex;
	}
}
