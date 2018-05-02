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

public class MemberNode extends LHSNode
{
	private ExprNode parent;
	private String name;
	private SourcePosition position;
	private Entity refEntity=null;

	public MemberNode(ExprNode parent, String name, SourcePosition position)
	{
		this.parent = parent;
		this.name = name;
		this.position = position;
	}


	public ExprNode parent()
	{
		return parent;
	}

	public String name()
	{
		return name;
	}


	@Override
	public Type type()
	{
		if(refEntity instanceof VariableEntity)
		{
			return refEntity.type();
		}else
		if(refEntity instanceof FunctionEntity){
			return Options.typeFunction;
		}else
		{
			throw new SemanticError(position, "Type error");
		}
	}
	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}

	@Override
	public SourcePosition position()
	{
		return position;
	}
}
