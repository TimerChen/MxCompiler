/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.ForNode
*/


package MxCompiler.AST;

public class ForNode extends LoopNode
{
	private ExprNode init, condi, step;

	public ForNode(SourcePosition pos, ExprNode init, ExprNode condi, ExprNode step, StmtNode body)
	{
		super(pos, body);
		this.init = init;
		this.condi = condi;
		this.step = step;
	}

	public ExprNode init()
	{
		return init;
	}

	public ExprNode condi()
	{
		return condi;
	}

	public ExprNode step()
	{
		return step;
	}

	public void setInit(ExprNode init)
	{
		this.init = init;
	}

	public void setCondi(ExprNode condi)
	{
		this.condi = condi;
	}

	public void setStep(ExprNode step)
	{
		this.step = step;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
