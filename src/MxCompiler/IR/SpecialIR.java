/*
	Coded by timemachine on 18-5-29
	MxCompiler.IR.SpecialIR
*/


package MxCompiler.IR;

public class SpecialIR extends InsIR
{
	public enum Type
	{
		CALLER_SAVE, CALLER_RECOVER,
		CALLEE_SAVE, CALLEE_RECOVER,
	}
	private Type type;
	public int p0;

	public SpecialIR(Type type, int p0)
	{
		this.p0 = p0;
		this.type = type;
	}

	public SpecialIR(Type type)
	{
		this.type = type;
	}

	public Type type()
	{
		return type;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
