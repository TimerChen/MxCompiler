package MxCompiler.AST;
import MxCompiler.Type.*;

public class AssignNode extends ExprNode
{
	ExprNode lhs, rhs;

	AssignNode(ExprNode lhs, ExprNode rhs)
	{
		super();
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Type type()
	{
		return lhs.type();
	}
	public SourcePosition position()
	{
		return lhs.position();
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}