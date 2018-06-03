/*
	Coded by timemachine on 18-6-1
	MxCompiler.Optim.GreedyAllocator
*/


package MxCompiler.Optim;

import MxCompiler.AST.StringLiteralNode;
import MxCompiler.CodeGen.ConflictGraph;
import MxCompiler.Global;
import MxCompiler.tools.Debuger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GreedyAllocator
{
	private List<ConflictGraph> cGraphs;
	private List<Integer> nowColor;
	private ConflictGraph nowGraph;

	public GreedyAllocator(List<ConflictGraph> cGraphs)
	{
		this.cGraphs = cGraphs;
	}

	private int getConflict(int a)
	{
		if(nowGraph.graph.get(a) == null)
			return 0;
		Iterator<Integer> it = nowGraph.graph.get(a).iterator();
		int ret = 0;
		while(it.hasNext())
		{
			int b = it.next(), c;
			c = nowColor.get(b);
			if(c >= 0)
				ret |= (1<<c);
		}
		return ret;
	}
	private List<Integer> colorGraph(ConflictGraph graph, int gIdx)
	{
		int idx = 0, num = Global.regNumber.get(gIdx);
		List<Integer> color = new ArrayList<>(num);
		nowColor = color;
		nowGraph = graph;
		int []avai =
				{(1<<3) | (1<<12) | (1<<13) | (1<<14) | (1<<15),
				 //(1<<7) | (1<<6) | (1<<8) | (1<<9) | (1<<1), //| (1<<2),
				 //(1<<10) | (1<<11)
				 };
		for(int i=0;i<num;++i)
		if(i < 16)
			color.add(i);
		else
			color.add(-1);
		double log2 = Math.log(2);
		for(int i=16; i<num; ++i)
		{
			int ok = ~getConflict(i);
			//boolean colored = false;
			for(int j=0;j<avai.length;++j)
			{
				int tmp = (ok & avai[j]);
				if(tmp != 0)
				{
					tmp = (-tmp)&tmp;
					tmp = (int)((Math.log(tmp)/log2)+1e-10);
					//Debuger.printInfo("Colorit", i+"->"+tmp);
					color.set(i, tmp);
					break;
				}
			}
		}

		String debugInfo = "";
		for(int i=0;i<num;++i)
		{
			debugInfo += color.get(i)+", ";

		}
		Debuger.printInfo("color", debugInfo, 2);

		return color;
	}

	public List<List<Integer>> colors()
	{
		int nFun = cGraphs.size();
		List<List<Integer>> colors = new ArrayList<>(nFun);
		int idx = 0;
		for(ConflictGraph i : cGraphs)
		{
			colors.add(colorGraph(i, idx++));
		}
		return colors;
	}
}
