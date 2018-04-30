package MxCompiler.AST;

import MxCompiler.Type.*;

abstract public class ExprNode extends ASTNode
{
	public ExprNode()
	{

	}
	public boolean isConst()
	{
		return false;
	}
	public boolean isLValue()
	{
		return false;
	}
	public abstract Type type();

	abstract public <S,E> E accept(ASTVisitor<S,E> visitor);
}
