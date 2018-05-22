/*
	Coded by timemachine on 18-5-22
	MxCompiler.InsIR.StoreIR
*/


package MxCompiler.IR;

public class StoreIR extends InsIR
{
	//move [base + index*8] dest
	private VarIR base, index, src;

	public StoreIR(VarIR base, VarIR index, VarIR src)
	{
		this.base = base;
		this.index = index;
		this.src = src;
	}

	public VarIR src()
	{
		return src;
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
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
