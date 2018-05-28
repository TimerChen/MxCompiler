/*
	Coded by timemachine on 18-5-20
	MxCompiler.InsIR.CallIR
*/


package MxCompiler.IR;

import MxCompiler.Entities.FunctionEntity;

public class CallIR extends InsIR
{
	private String label;
	private int pNum;

	public CallIR(String label, int pNum)
	{
		this.label = label;
		this.pNum = pNum;
	}

	public int pNum()
	{
		return pNum;
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
