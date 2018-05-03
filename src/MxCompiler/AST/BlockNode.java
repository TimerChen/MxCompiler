package MxCompiler.AST;
import java.util.*;
import MxCompiler.Entities.Scope;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.BlockNode
*/

public class BlockNode extends StmtNode
{
	private List<StmtNode> stmts;
	private Scope scope;

	public BlockNode(SourcePosition pos, List<StmtNode> stmts, Scope scope)
	{
		super(pos);
		this.stmts = stmts;
		if(stmts == null)
			this.stmts = new LinkedList<>();
		this.scope = scope;
	}

	public BlockNode(StmtNode node)
	{
		super(node.position());
		this.stmts = new ArrayList<>();
		stmts.add(node);
		scope = null;
	}

	public List<StmtNode> stmts()
	{
		return stmts;
	}

	public Scope scope()
	{
		return scope;
	}

	public void setScope(Scope scope)
	{
		this.scope = scope;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor) {
		return visitor.visit(this);
	}

}
