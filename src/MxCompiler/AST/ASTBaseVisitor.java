/*
	Coded by timemachine on 18-5-1
	MxCompiler.AST.ASTBaseVisitor
*/


package MxCompiler.AST;

import MxCompiler.Entities.ClassEntity;
import MxCompiler.Entities.VariableEntity;
import MxCompiler.tools.Debuger;

import java.util.List;

public class ASTBaseVisitor implements ASTVisitor<Void, Void>
{
	public void visit(List<? extends ASTNode> node)
	{
		for(ASTNode i : node)
		{
			if(i instanceof ExprNode)
			{
				visit((ExprNode) i);
			}else if(i instanceof StmtNode){
				visit((StmtNode) i);
			}else if(i == null){
				Debuger.printInfo("Warning", "Node is null");
			}else{
				throw new RuntimeException("Strange Node type." + i.getClass());
			}
		}

	}

	public void visit(ExprNode node)
	{
		node.accept(this);
	}
	public void visit(StmtNode node)
	{
		Debuger.printInfo("Info", "visit "+node.toString()+" at "+node.position());
		node.accept(this);
	}
	@Override
	public Void visit(BlockNode node)
	{
		visit(node.stmts());
		return null;
	}

	@Override
	public Void visit(ExprStmtNode node)
	{
		if(node.expr()!=null)
			visit(node.expr());
		return null;
	}

	@Override
	public Void visit(IfNode node)
	{
		visit(node.condi());
		visit(node.trueBody());
		if(node.falseBody()!=null)
			visit(node.falseBody());
		return null;
	}

	@Override
	public Void visit(WhileNode node)
	{
		visit(node.condi());
		visit(node.body());
		return null;
	}

	@Override
	public Void visit(ForNode node)
	{
		if(node.init()!=null)
			visit(node.init());
		if(node.condi()!=null)
			visit(node.condi());
		if(node.step()!=null)
			visit(node.step());
		return null;
	}

	@Override
	public Void visit(BreakNode node)
	{
		//Nothing
		return null;
	}

	@Override
	public Void visit(ContinueNode node)
	{
		//Nothing
		return null;
	}

	@Override
	public Void visit(ReturnNode node)
	{
		if(node.ret()!=null)
			visit(node.ret());
		return null;
	}

	@Override
	public Void visit(VarDecNode node)
	{
		for(VariableEntity i : node.entity())
			if(i.init()!=null)
			visit(i.init());
		return null;
	}

	@Override
	public Void visit(FunDefNode node)
	{
		//Debuger.printInfo("Info", "visitFunDef "+node.toString());
		visit(node.entity().body());
		return null;
	}

	@Override
	public Void visit(ClassDefNode node)
	{
		ClassEntity entity = node.entity();
		if(entity.constructor()!=null)
			visit(entity.constructor().body());
		for(FunDefNode i : entity.funList())
		{
			visit(i);
		}
		for(VarDecNode i : entity.varList())
		{
			visit(i);
		}
		return null;
	}

	@Override
	public Void visit(AssignNode node)
	{
		visit(node.lhs());
		visit(node.rhs());
		return null;
	}

	@Override
	public Void visit(BinaryOpNode node)
	{
		visit(node.left());
		visit(node.right());
		return null;
	}
	/*
	@Override
	public Void visit(UnaryOpNode node)
	{
		visit(node.expr());
		return null;
	}
	*/
	@Override
	public Void visit(CreatorNode node)
	{
		for(ExprNode i : node.args())
			visit(i);
		return null;
	}

	@Override
	public Void visit(PrefixOpNode node)
	{
		visit(node.expr());
		return null;
	}

	@Override
	public Void visit(SuffixOpNode node)
	{
		visit(node.expr());
		return null;
	}

	@Override
	public Void visit(ArefNode node)
	{
		visit(node.ref);
		visit(node.index);
		return null;
	}

	@Override
	public Void visit(MemberNode node)
	{
		visit(node.parent());
		return null;
	}

	@Override
	public Void visit(FuncallNode node)
	{
		visit(node.function);
		for(ExprNode i : node.params)
			visit(i);
		return null;
	}

	@Override
	public Void visit(VariableNode node)
	{
		//Nothing
		return null;
	}

	@Override
	public Void visit(IntLiteralNode node)
	{
		//Nothing
		return null;
	}

	@Override
	public Void visit(StringLiteralNode node)
	{
		//Nothing
		return null;
	}

	@Override
	public Void visit(BoolLiteralNode node)
	{
		//Nothing
		return null;
	}
}
