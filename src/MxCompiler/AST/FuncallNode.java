package MxCompiler.AST;

import MxCompiler.Type.Type;
import java.util.*;

public class FuncallNode extends ExprNode
{
	ExprNode function;
	List<ExprNode> params;
	@Override
	public SourcePosition position()
	{
		return null;
	}

	@Override
	public Type type()
	{
		return null;
	}
	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
