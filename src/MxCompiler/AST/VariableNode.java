package MxCompiler.AST;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.VariableNode
*/

import MxCompiler.Entities.VariableEntity;
import MxCompiler.Type.Type;

public class VariableNode extends LHSNode
{
	private String name;
	private SourcePosition position;

	public VariableNode(String name, SourcePosition position)
	{
		super(null);
		this.name = name;
		this.position = position;
	}

	public String name()
	{
		return name;
	}

	@Override
	public SourcePosition position()
	{
		return position;
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}


}

