/*
	Coded by timemachine on 18-6-3
	MxCompiler.Optim.WeightGreedyAllocator
*/


package MxCompiler.Optim;

import MxCompiler.AST.StringLiteralNode;
import MxCompiler.CodeGen.ConflictGraph;
import MxCompiler.CodeGen.VarAnalyzer;
import MxCompiler.Global;
import MxCompiler.tools.Debuger;
import org.antlr.runtime.misc.IntArray;

import java.util.*;

public class WeightGreedyAllocator
{
	private List<ConflictGraph> cGraphs;
	private List<Integer> nowColor;
	private ConflictGraph nowGraph;
	private List<List<Integer>> weights;

	private int[] nowDu;

	public WeightGreedyAllocator(List<ConflictGraph> cGraphs, List<List<Integer>> weights)
	{
		this.cGraphs = cGraphs;
		this.weights = weights;
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

	class PointPack
	{
		int i;
		double w;

		public PointPack(int i, double w)
		{
			this.i = i;
			this.w = w;
		}
	}
	public static Comparator<PointPack> wComparator = new Comparator<PointPack>(){

		@Override
		public int compare(PointPack c1, PointPack c2) {
			double val = -(c1.w - c2.w);
			if(val < 0) return -1;
			else return 1;
			//return -(c1.w - c2.w);
		}
	};

	private static int []avai =
			{(1<<3) | (1<<12) | (1<<13) | (1<<14) | (1<<15),
			 (1<<9) | (1<<1)
			 //(1<<7) | (1<<6) | (1<<8) | (1<<9) | (1<<1), //| (1<<2),
			 //(1<<10) | (1<<11)
			};
	private final static
		double log2 = Math.log(2);
	int allocOne(int i)
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
				return tmp;
			}
		}
		return -1;
	}
	private List<Integer> colorGraph(ConflictGraph graph, List<Integer>weight, int gIdx)
	{
		int idx = 0, num = Global.regNumber.get(gIdx);
		List<Integer> color = new ArrayList<>(num);
		nowDu = new int[num];
		nowColor = color;
		nowGraph = graph;

		int colorNumber = 5;
		for(int i=0;i<num;++i)
		if(i < 16)
			color.add(i);
		else
			color.add(-1);

		Stack<Integer> stack = new Stack<>();
		PriorityQueue<PointPack> pQue = new PriorityQueue<>(wComparator);
		for(int i=0;i<num;++i)
		if(nowGraph.graph.get(i) == null){
			nowDu[i] = 0;
		}else{
			nowDu[i] = nowGraph.graph.get(i).size();
		}
		for(int i=16;i<num;++i)
		{

			if(nowDu[i] < 7)
			{
				stack.push(i);
			}else{
				pQue.add(new PointPack(i, 1.*weight.get(i)/nowDu[i]));
			}
		}

		while(!pQue.isEmpty())
		{
			PointPack pack = pQue.poll();
			int i = pack.i;
			//Debuger.printInfo("point","["+pack.i+"]:"+pack.w);
			color.set(i, allocOne(i));
		}

		while(!stack.isEmpty())
		{
			int i = stack.pop();
			color.set(i, allocOne(i));
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
			colors.add(colorGraph(i, weights.get(idx), idx));
			idx++;
		}
		return colors;
	}
}
