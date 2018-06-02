/*
	Coded by timemachine on 18-5-26
	MxCompiler.CodeGen.BlockToList
*/


package MxCompiler.CodeGen;

import MxCompiler.IR.InsIR;

import java.util.ArrayList;
import java.util.List;

public class BlockToList
{
	private List<BasicBlock> blkList;

	public BlockToList(List<BasicBlock> blkList)
	{
		this.blkList = blkList;
	}
	public List<InsIR> toList()
	{
		List<InsIR> list = new ArrayList<>();
		for(BasicBlock start: blkList)
		{
			BasicBlock now = start;
			while(now != null)
			{
				list.addAll(now.irList());
				now = now.next();
			}
		}
		return list;
	}
}
