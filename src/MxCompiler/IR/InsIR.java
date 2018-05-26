/*
	Coded by timemachine on 18-5-18
	MxCompiler.InsIR.InsIR
*/


package MxCompiler.IR;

import MxCompiler.CodeGen.NASMTranslator;
import MxCompiler.Global;

abstract public class InsIR extends Object
{
	private int loopDeepth;

	public InsIR()
	{
		loopDeepth = Global.IRBuilder_loopDeepth;
	}

	public InsIR(int loopDeepth)
	{
		this.loopDeepth = loopDeepth;
	}

	public int loopDeepth()
	{
		return loopDeepth;
	}

	abstract public void accept(IRVisitor visitor);
}
