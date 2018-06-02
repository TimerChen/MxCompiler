/*
	Coded by timemachine on 18-5-26
	MxCompiler.Optim.FakeAllocator
*/


package MxCompiler.Optim;

import java.util.*;

import MxCompiler.CodeGen.ConflictGraph;
import MxCompiler.Global;
import MxCompiler.IR.*;
import MxCompiler.tools.Debuger;

public class FakeAllocator extends Object
{
	private List<ConflictGraph> cGraphs;

	public FakeAllocator(List<ConflictGraph> cGraphs)
	{
		this.cGraphs = cGraphs;
	}

	public List<List<Integer>> colors()
	{
		int nFun = cGraphs.size();
		List<List<Integer>> colors = new ArrayList<>(nFun);
		//Debuger.printInfo("nFun", ""+nFun);
		for(int i=0; i<nFun; ++i)
		{
			List<Integer> color = new ArrayList<Integer>(Global.regNumber.size());
			Debuger.printInfo("Rsize", ""+Global.regNumber.get(i));
			for(int j=0; j<Global.regNumber.get(i); ++j)
			if(j<16){
				color.add(j);
			}else
			{
				color.add(-1);
			}
			colors.add(color);
		}
		return colors;
	}
}
