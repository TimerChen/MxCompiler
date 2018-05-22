/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.ArefNode
*/


package MxCompiler.AST;

import MxCompiler.Type.Type;
import MxCompiler.Type.TypeArray;
import MxCompiler.Util.SemanticError;


public class ArefNode extends LHSNode
{
	ExprNode ref, index;

	public ArefNode(ExprNode ref, ExprNode index)
	{
		super();
		this.ref = ref;
		this.index = index;
	}

	public ExprNode ref()
	{
		return ref;
	}

	public ExprNode index()
	{
		return index;
	}

	@Override
	public Type type()
	{
		if(type == null)
		{
			if(!(ref.type() instanceof TypeArray))
				throw new SemanticError(position(),"Array excepted.");
			type = ((TypeArray)ref.type()).base();
		}
		return super.type();
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}

	@Override
	public SourcePosition position()
	{
		return ref.position();
	}
}
