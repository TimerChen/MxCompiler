package MxCompiler.AST;

import MxCompiler.Options;
import MxCompiler.Type.Type;
import MxCompiler.Util.SemanticError;

import java.util.*;

public class FuncallNode extends ExprNode
{
	ExprNode function;
	List<ExprNode> params;

	public FuncallNode(ExprNode function, List<ExprNode> params)
	{
		this.function = function;
		this.params = params;
	}

	@Override
	public SourcePosition position()
	{
		return function.position();
	}

	@Override
	public Type type()
	{
		Type re = function.type();
		if(re != Options.typeFunction)
			throw new SemanticError(function.position(), re + " found, but function excepted.");
		return re;
	}
	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
