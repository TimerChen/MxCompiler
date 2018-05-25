/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.VarMemIR
*/


package MxCompiler.IR;

public class VarMemIR extends VarIR
{
	static final String MEM_PREFIX = "qword ";
	private VarIR base, index;

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
	public String toCodeStr()
	{
		if(index == null)
			return MEM_PREFIX + "[" + base.toCodeStr() + "]";
		else
			return MEM_PREFIX + "[" + base.toCodeStr() + index.toCodeStr() + "*8"+ "]";
	}
}
