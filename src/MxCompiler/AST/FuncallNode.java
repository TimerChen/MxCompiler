package MxCompiler.AST;

import MxCompiler.Options;
import MxCompiler.Type.Type;
import MxCompiler.Util.SemanticError;

import java.util.*;

public class FuncallNode extends ExprNode
{
	private ExprNode function;
	private List<ExprNode> params;

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


	private Type getType()
	{
		Type re = function.type();
		if(re != Options.typeFunction)
			throw new SemanticError(function.position(), re + " found, but function expected.");
		if(function instanceof VariableNode)
		{
			return ((VariableNode)function).refEntity().type();
		}else
		{
			throw new RuntimeException(function.getClass() + " found, but variable() expected.");
		}
	}
	@Override
	public Type type()
	{
		if(type == null)
			type = getType();
		return super.type();
	}

	public ExprNode function()
	{
		return function;
	}

	public List<ExprNode> params()
	{
		return params;
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
