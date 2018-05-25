/*
	Coded by timemachine on 18-5-25
	MxCompiler.CodeGen.BasicBlock
*/


package MxCompiler.CodeGen;

import MxCompiler.IR.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

public class BasicBlock extends Object
{
	private int number;
	private List<InsIR> irList;
	private BasicBlock next0, next1;
	public Map<Integer, Bool>varKill, ueVar, liveOut;

	public BasicBlock(int number)
	{
		irList = null;
		next0 = null;
		next1 = null;
		this.number = number;
	}

	public int number()
	{
		return number;
	}

	public List<InsIR> irList()
	{
		return irList;
	}

	public void setIrList(List<InsIR> irList)
	{
		this.irList = irList;
	}

	public BasicBlock next0()
	{
		return next0;
	}

	public void setNext0(BasicBlock next0)
	{
		this.next0 = next0;
	}

	public BasicBlock next1()
	{
		return next1;
	}

	public void setNext1(BasicBlock next1)
	{
		this.next1 = next1;
	}
}
