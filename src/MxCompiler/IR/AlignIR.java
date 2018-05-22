/*
	Coded by timemachine on 18-5-20
	MxCompiler.InsIR.AlignIR
*/


package MxCompiler.IR;

import MxCompiler.CodeGen.NASMTranslator;

public class AlignIR extends InsIR
{
	private int bytes;
	public AlignIR()
	{
		this.bytes = 16;
	}
	public AlignIR(int bytes)
	{
		this.bytes = bytes;
	}

	public int bytes()
	{
		return bytes;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
