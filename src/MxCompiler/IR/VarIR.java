/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.VarIR
*/


package MxCompiler.IR;

import java.util.LinkedList;
import java.util.List;

abstract public class VarIR extends Object
{
	public VarIR()
	{

	}

	public VarIR(List<InsIR> insIrList)
	{
		this.insIrList = insIrList;
	}

	protected List<InsIR> insIrList = new LinkedList<>();

	public List<InsIR> irList()
	{
		return insIrList;
	}

	abstract public VarIR clone(List<InsIR> irList);
	abstract public String toCodeStr8();
	abstract public String toCodeStr1();

	@Override
	public String toString()
	{
		return toCodeStr8();
	}

	public String toString_old()
	{
		return super.toString();
	}
}
