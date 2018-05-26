/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.VarRegIR
*/


package MxCompiler.IR;

import java.util.List;

public class VarRegIR extends VarIR
{
	public VarRegIR(int regIndex)
	{
		this.regIndex = regIndex;
	}

	public VarRegIR(List<InsIR> insIrList, int regIndex)
	{
		super(insIrList);
		this.regIndex = regIndex;
	}

	private int regIndex;

	public int regIndex()
	{
		return regIndex;
	}

	public void setRegIndex(int regIndex)
	{
		this.regIndex = regIndex;
	}

	@Override
	public String toCodeStr()
	{
		String name;
		switch (regIndex)
		{
			case 0: name = "rax"; break;
			case 1: name = "rcx"; break;
			case 2: name = "rdx"; break;
			case 3: name = "rbx"; break;
			case 4: name = "rsp"; break;
			case 5: name = "rbp"; break;
			case 6: name = "rsi"; break;
			case 7: name = "rdi"; break;

			default:
				if(regIndex < 16)
					name = "r"+regIndex;
				else
					throw new RuntimeException("Register need alloc.");
		}
		return name;
	}
}
