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

	private boolean isConst;

	public UnaryOpNode(SourcePosition position, UnaryOp operator, ExprNode expr)
	{
		this.position = position;
		this.operator = operator;
		this.expr = expr;
		isConst = expr.isConst();
	}

	@Override
	public boolean isConst()
	{
		return isConst;
	}

	public UnaryOp operator()
	{
		return operator;
	}

	public ExprNode expr()
	{
		return expr;
	}

	public void setExpr(ExprNode expr)
	{
		this.expr = expr;
	}

	private Type getType()
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
	public Type type()
	{
		if(type == null)
			type = getType();
		return super.type();
	}


	@Override
	public SourcePosition position()
	{
		return position;
	}
}
