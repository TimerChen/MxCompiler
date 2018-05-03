package MxCompiler.AST;

import MxCompiler.Entities.VariableEntity;
import MxCompiler.Options;
import MxCompiler.Type.Type;
import MxCompiler.Util.SemanticError;
import jdk.nashorn.internal.ir.FunctionNode;

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
		if(function instanceof VariableNode)
		{
			return ((VariableNode)function).refEntity().type();
		}else
		{
			throw new RuntimeException(function.getClass() + " found, but variable() excepted.");
		}
	}
	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
