/*
	Coded by timemachine on 18-5-25
	MxCompiler.CodeGen.ConflictGraph
*/


package MxCompiler.CodeGen;

import MxCompiler.IR.VarRegIR;
import MxCompiler.tools.Debuger;

import java.util.*;

public class ConflictGraph
{
	public ArrayList<Set<Integer>>graph;
	public ConflictGraph(int regNumber)
	{
		graph = new ArrayList<>(regNumber);
		for(int i=0;i<regNumber;++i)
			graph.add(i, null);

	}
	public void addEdge(int a, int b)
	{
		if(a==b) return;
		//Debuger.printInfo("Edge","("+a+", "+b+")");
		//let a < b
		Set<Integer> node;
		if(graph.get(a) == null)
			graph.set(a, new HashSet<Integer>());
		if(graph.get(b) == null)
			graph.set(b, new HashSet<Integer>());
		graph.get(a).add(b);
		graph.get(b).add(a);
	}
	public boolean isConflict(int a, int b)
	{
		if(graph.get(a) == null)
			return false;
		return graph.get(a).contains(b);
	}
}
