/*
	Coded by timemachine on 18-5-25
	MxCompiler.CodeGen.CFGBuilder
*/


package MxCompiler.CodeGen;

import MxCompiler.AST.BlockNode;
import MxCompiler.IR.*;
import MxCompiler.tools.Debuger;
import jdk.nashorn.internal.ir.Block;
import sun.security.ssl.Debug;

import java.util.*;

public class CFGBuilder extends Object
{
	private List<List<InsIR>> irLists;
	private Map<String,BasicBlock> map;
	public CFGBuilder(List<List<InsIR>> irLists)
	{
		this.irLists = irLists;
		this.map = new HashMap<>();
	}

	public List<BasicBlock> getCFG()
	{

		BasicBlock nowBlock = null;
		List<BasicBlock> funList = new ArrayList<BasicBlock>(irLists.size());
		int ii = 0;
		for(List<InsIR> irList: irLists)
		{
			int start = 0,
				counter = 0,
				n = irList.size();

			for(int i=0;i<n;++i)
			{
				BasicBlock nextBlock;
				InsIR ir = irList.get(i), pir = null;
				if(i > 0)pir = irList.get(i-1);

				if(ir instanceof LabelIR)
				{
					//still at last block
					nextBlock = new BasicBlock(counter++);
					if(i!=0)
					{
						nowBlock.setNext0(nextBlock);
						nowBlock.setIrList(irList.subList(start, i));
						start = i;
					}else
					{
						funList.add(nextBlock);
					}
					nowBlock = nextBlock;
					map.put(((LabelIR) ir).label(), nowBlock);
				}else if(pir instanceof JumpIR || pir instanceof CJumpIR)
				{
					nextBlock = new BasicBlock(counter++);
					nowBlock.setNext0(nextBlock);
					nowBlock.setIrList(irList.subList(start, i));

					nowBlock = nextBlock;
					start = i;
				}
			}
			nowBlock.setIrList(irList.subList(start, n));

			nowBlock = funList.get(ii);
			while(nowBlock!=null)
			{
				InsIR ir = nowBlock.irList().get(nowBlock.irList().size()-1);
				if(ir instanceof JumpIR)
				{
					nowBlock.setNext1(map.get(((JumpIR) ir).aim().label()));
				}else if(ir instanceof CJumpIR)
				{
					nowBlock.setNext1(map.get(((CJumpIR) ir).aim().label()));
				}
				nowBlock = nowBlock.next0();
			}
			ii++;
		}


		return funList;
	}
}
