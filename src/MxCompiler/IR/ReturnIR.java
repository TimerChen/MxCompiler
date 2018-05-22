/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.ReturnIR
*/


package MxCompiler.IR;

public class ReturnIR extends InsIR
{
	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
