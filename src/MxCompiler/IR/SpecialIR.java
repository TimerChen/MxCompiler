/*
	Coded by timemachine on 18-5-29
	MxCompiler.IR.SpecialIR
*/


package MxCompiler.IR;

public class SpecialIR extends InsIR
{
	public enum Type
	{
		CALLER_SAVE, CALLER_RECOVER
	}

	private Type type;

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
