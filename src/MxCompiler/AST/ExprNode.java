package MxCompiler.AST;

import MxCompiler.Type.*;

abstract public class ExprNode extends ASTNode
{
	public ExprNode()
	{
		type = null;
	}

	public ExprNode(Type type)
	{
		this.type = type;
	}

	public boolean isConst()
	{
		return false;
	}
	public boolean isLValue()
	{
		return false;
	}
	protected Type type;
	public Type type()
	{
		return type;
	}

	abstract public <S,E> E accept(ASTVisitor<S,E> visitor);
}
