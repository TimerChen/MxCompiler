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
	public VarIR clone(List<InsIR> irList)
	{
		return new VarRegIR(irList, regIndex);
	}

	@Override
	public String toCodeStr8()
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
				//name = "r"+regIndex;

				if(regIndex < 16)
					name = "r"+regIndex;
				else
					throw new RuntimeException("Register need alloc.");

		}
		return name;
	}
	@Override
	public String toCodeStr1()
	{
		String name;
		switch (regIndex)
		{
			case 0: name = "al"; break;
			case 1: name = "cl"; break;
			case 2: name = "dl"; break;
			case 3: name = "bl"; break;
			case 4: name = "spl"; break;
			case 5: name = "bpl"; break;
			case 6: name = "sil"; break;
			case 7: name = "dil"; break;

			default:
				name = "r"+regIndex+"b";

				if(regIndex < 16)
					name = "r"+regIndex+"b";
				else
					throw new RuntimeException("Register need alloc.");

		}
		return name;
	}
}
