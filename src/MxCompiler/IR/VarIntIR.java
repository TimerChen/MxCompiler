/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.VarIntIR
*/


package MxCompiler.IR;

import java.util.List;

public class VarIntIR extends VarIR
{
	public VarIntIR(List<InsIR> insIrList, int val)
	{
		super(insIrList);
		this.val = val;
	}

	public VarIntIR(int val)
	{
		this.val = val;
	}

	private int val;

	public int val()
	{
		return val;
	}
}
