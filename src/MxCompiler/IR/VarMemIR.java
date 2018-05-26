/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.VarMemIR
*/


package MxCompiler.IR;

import java.util.List;

public class VarMemIR extends VarIR
{
	private VarIR base, index;

	public VarMemIR(List<InsIR> insIrList, VarIR base, VarIR index)
	{
		super(insIrList);
		this.base = base;
		this.index = index;
	}

	public VarMemIR(VarIR base, VarIR index)
	{
		this.base = base;
		this.index = index;
	}

	public VarIR base()
	{
		return base;
	}

	public VarIR index()
	{
		return index;
	}

	@Override
	public String toCodeStr8()
	{
		final String MEM_PREFIX = "qword ";
		if(index == null)
			return MEM_PREFIX + "[" + base.toCodeStr8() + "]";
		else
			if(index instanceof VarIntIR)
				return MEM_PREFIX + "[" + base.toCodeStr8() + " + " + ((VarIntIR) index).val()*8 + "]";
			else
				return MEM_PREFIX + "[" + base.toCodeStr8() + " + " + index.toCodeStr8() + "*8"+ "]";
	}
	@Override
	public String toCodeStr1()
	{
		final String MEM_PREFIX = "byte ";
		if(index == null)
			return MEM_PREFIX + "[" + base.toCodeStr8() + "]";
		else
		if(index instanceof VarIntIR)
			return MEM_PREFIX + "[" + base.toCodeStr8() + " + " + ((VarIntIR) index).val()*8 + "]";
		else
			return MEM_PREFIX + "[" + base.toCodeStr8() + " + " + index.toCodeStr8() + "*8"+ "]";
	}
}
