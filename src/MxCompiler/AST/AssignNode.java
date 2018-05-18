package MxCompiler.AST;
import MxCompiler.Type.*;

public class AssignNode extends ExprNode
{
	private ExprNode lhs, rhs;

	public AssignNode(ExprNode lhs, ExprNode rhs)
	{
		super();
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public ExprNode lhs()
	{
		return lhs;
	}

	public ExprNode rhs()
	{
		return rhs;
	}

	public Type type()
	{
		if(type == null)
			type = lhs.type();
		return super.type();
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
