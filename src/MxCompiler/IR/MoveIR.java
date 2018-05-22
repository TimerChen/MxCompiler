/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.MoveIR
*/


package MxCompiler.IR;

public class MoveIR extends InsIR
{
	VarIR lhs, rhs;

	public MoveIR(VarIR lhs, VarIR rhs)
	{
		this.lhs = lhs;
		this.rhs = rhs;
	}
	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
