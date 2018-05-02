/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.WhileNode
*/


package MxCompiler.AST;

import java.util.LinkedList;
import java.util.List;

public class WhileNode extends LoopNode
{
	private ExprNode condi;
	/*
	public WhileNode(SourcePosition pos, ExprNode condi, BlockNode body)
	{
		super(pos, body);
		this.condi = condi;
	}*/
	public WhileNode(SourcePosition pos, ExprNode condi, StmtNode body)
	{
		super(pos, body);
		this.condi = condi;
	}

	public ExprNode condi()
	{
		return condi;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
