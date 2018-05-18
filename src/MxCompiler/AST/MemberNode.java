/*
	Coded by timemachine on 18-4-29
	MxCompiler.AST.MemberNode
*/


package MxCompiler.AST;

import MxCompiler.Entities.Entity;
import MxCompiler.Entities.FunctionEntity;
import MxCompiler.Entities.VariableEntity;
import MxCompiler.Options;
import MxCompiler.Type.Type;
import MxCompiler.Util.SemanticError;

import java.util.OptionalInt;

public class MemberNode extends VariableNode
{
	private ExprNode parent;

	public MemberNode(ExprNode parent, String name, SourcePosition position)
	{
		super(name, position);
		this.parent = parent;
	}


	public ExprNode parent()
	{
		return parent;
	}


	private  Type getType()
	{
		if(refEntity instanceof VariableEntity)
		{
			return refEntity.type();
		}else
		if(refEntity instanceof FunctionEntity)
		{
			return Options.typeFunction;
		}else
		{
			throw new SemanticError(position, "Type error"+refEntity);
		}
	}
	@Override
	public Type type()
	{
		if(type == null)
		{
			type = getType();
		}
		return super.type();
	}
	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}

}
