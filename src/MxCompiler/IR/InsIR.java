/*
	Coded by timemachine on 18-5-18
	MxCompiler.InsIR.InsIR
*/


package MxCompiler.IR;

import MxCompiler.CodeGen.NASMTranslator;

abstract public class InsIR extends Object
{
	abstract public void accept(IRVisitor visitor);
}
