/*
	Coded by timemachine on 18-5-22
	MxCompiler.InsIR.StoreIR
*/


package MxCompiler.IR;

public class StoreIR extends InsIR
{
	//move [base + index*8] src
	private VarIR dest, src;

	public StoreIR(VarIR base, VarIR index, VarIR src)
	{
		this.dest = new VarMemIR(base, index);
		this.src = src;
	}

	public StoreIR(VarIR dest, VarIR src)
	{
		if(dest instanceof VarRegIR || dest instanceof VarLabelIR)
			throw new RuntimeException("Address excepted.");
		this.dest = dest;
		this.src = src;
	}

	public VarIR src()
	{
		return src;
	}

	public VarIR dest()
	{
		return dest;
	}

	public void setDest(VarIR dest)
	{
		this.dest = dest;
	}

	public void setSrc(VarIR src)
	{
		this.src = src;
	}

	/*
		public VarIR base()
		{
			return base;
		}

		public VarIR index()
		{
			return index;
		}
		*/
	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
