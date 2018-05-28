/*
	Coded by timemachine on 18-5-25
	MxCompiler.CodeGen.BasicBlock
*/


package MxCompiler.CodeGen;

import MxCompiler.IR.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicBlock extends Object
{
	private int id;
	private List<InsIR> irList;
	private BasicBlock next0, next1;
	public Set<Integer>varKill, ueVar, liveOut;

	public BasicBlock(int id)
	{
		irList = null;
		next0 = null;
		next1 = null;
		this.id = id;
		this.varKill = new HashSet<>();
		this.ueVar = new HashSet<>();
		this.liveOut = new HashSet<>();
	}

	public int id()
	{
		return id;
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