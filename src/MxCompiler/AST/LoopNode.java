/*
	Coded by timemachine on 18-5-2
	MxCompiler.AST.LoopNode
*/


package MxCompiler.AST;

import java.util.LinkedList;
import java.util.List;

abstract public class LoopNode extends StmtNode
{
	public LoopNode(SourcePosition pos, StmtNode body)
	{
		super(pos);
		if(body instanceof BlockNode)
		{
			this.body = (BlockNode) body;
		}else
		{
			List<StmtNode> list = new LinkedList<>();
			list.add(body);
			this.body = new BlockNode(pos, list, null);
		}

	}

	protected BlockNode body;

	public BlockNode body()
	{
		return body;
	}
}
