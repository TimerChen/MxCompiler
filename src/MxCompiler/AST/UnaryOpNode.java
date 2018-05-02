/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.UnaryOpNode
*/


package MxCompiler.AST;

import MxCompiler.Options;
import MxCompiler.Type.Type;
import MxCompiler.Util.SemanticError;

import javax.lang.model.element.UnknownAnnotationValueException;

abstract public class UnaryOpNode extends ExprNode
{
	public enum UnaryOp {
		PRE_INC, PRE_DEC, SUF_INC, SUF_DEC,
		MINUS, ADD, LOGIC_NOT, BIT_NOT
	}
	private SourcePosition position;

	private UnaryOp operator;
	private ExprNode expr;

	public UnaryOpNode(SourcePosition position, UnaryOp operator, ExprNode expr)
	{
		this.position = position;
		this.operator = operator;
		this.expr = expr;
	}

	public UnaryOp operator()
	{
		return operator;
	}

	public ExprNode expr()
	{
		return expr;
	}

	@Override
	public Type type()
	{
		Type ret = expr.type();
		if(ret == Options.typeBool)
		{
			if(operator!=UnaryOp.LOGIC_NOT)
				throw new SemanticError(position, "Operation not defined.");
		}else
		if (ret == Options.typeInt)
		{
			if(operator==UnaryOp.LOGIC_NOT)
				throw new SemanticError(position, "Operation not defined.");
		}else
		{
			throw new SemanticError(position, "Operation not defined.");
		}
		return ret;
	}


	@Override
	public SourcePosition position()
	{
		return position;
	}
}
