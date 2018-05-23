/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.MoveIR
*/


package MxCompiler.IR;

public class MoveIR extends InsIR
{
	private VarIR lhs, rhs;

	public MoveIR(VarIR lhs, VarIR rhs)
	{
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public VarIR lhs()
	{
		return lhs;
	}

	public VarIR rhs()
	{
		return rhs;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
