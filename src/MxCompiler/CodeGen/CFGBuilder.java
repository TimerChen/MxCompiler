/*
	Coded by timemachine on 18-5-25
	MxCompiler.CodeGen.CFGBuilder
*/


package MxCompiler.CodeGen;

import MxCompiler.AST.BlockNode;
import MxCompiler.IR.*;
import jdk.nashorn.internal.ir.Block;

import java.util.*;

public class CFGBuilder extends Object
{
	private List<InsIR> irList;
	private Map<String,BasicBlock> map;
	public CFGBuilder(List<InsIR> irList)
	{
		this.irList = irList;
		this.map = new HashMap<>();
	}

	public List<BasicBlock> getCFG()
	{
		int n = irList.size();
		BasicBlock nowBlock = null;
		List<BasicBlock> funList = new ArrayList<>();
		int start = 0, counter = 0;
		for(int i=0;i<n;++i)
		{
			BasicBlock nextBlock;
			InsIR ir = irList.get(i);

			if(ir instanceof LabelIR)
			{
				//still at last block
				if(start <= i-1)
				{
					nextBlock = new BasicBlock(counter++);
					nowBlock.setNext0(nextBlock);
					nowBlock.setIrList(irList.subList(start, i-1));
					nowBlock = nextBlock;
					start = i;
				}else if(nowBlock == null)
				{
					nowBlock = new BasicBlock(counter++);
					funList.add(nowBlock);
				}
				map.put(((LabelIR) ir).label(), nowBlock);
			}else if(ir instanceof JumpIR || ir instanceof CJumpIR)
			{
				nextBlock = new BasicBlock(counter++);
				nowBlock.setNext0(nextBlock);
				nowBlock.setIrList(irList.subList(start, i));
				nowBlock = nextBlock;
				start = i+1;
			}else if(ir instanceof ReturnIR)
			{
				nowBlock = null;
				counter = 0;
				start = i+1;
			}
		}
		for(BasicBlock i: funList)
		{
			InsIR ir = i.irList().get(i.irList().size()-1);
			if(ir instanceof JumpIR)
			{
				i.setNext1(map.get(((JumpIR) ir).aim().label()));
			}else if(ir instanceof CJumpIR)
			{
				i.setNext1(map.get(((CJumpIR) ir).aim().label()));
			}
		}

		return funList;
	}
}
