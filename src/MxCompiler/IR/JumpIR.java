/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.JumpIR
*/


package MxCompiler.IR;

public class JumpIR extends InsIR
{
	private VarLabelIR aim;

	public JumpIR(VarLabelIR aim)
	{
		this.aim = aim;
	}

	public VarLabelIR aim()
	{
		return aim;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
