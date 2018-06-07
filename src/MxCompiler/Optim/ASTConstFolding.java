/*
	Coded by timemachine on 18-6-1
	MxCompiler.Optim.ASTConstFolding
*/


package MxCompiler.Optim;

import MxCompiler.AST.*;
import MxCompiler.Entities.VariableEntity;
import MxCompiler.SemanticCheck.ASTree;
import MxCompiler.Type.*;

import java.util.List;

public class ASTConstFolding extends ASTBaseVisitor
{
	static int cf_count=0;
	private ASTree ast;
	public ASTConstFolding(ASTree ast)
	{
		this.ast = ast;
	}
	public void constFolding()
	{
		for(ASTNode i: ast.definitionNodes())
		if(i instanceof VarDecNode){
			visit((VarDecNode)i);
		}else if(i instanceof FunDefNode)
		{
			visit((FunDefNode) i);
		}else
		{
			visit((ClassDefNode)i);
		}
	}

	private ExprNode convert(BinaryOpNode node)
	{
		if(node.isConst())
		{
			cf_count++;
			Type type = node.type();
			ExprNode left, right;
			left = node.left();
			right = node.right();
			BinaryOpNode.BinaryOp operator = node.operator();
			if(type instanceof TypeBool)
			{
				boolean l, r;
				l = ((BoolLiteralNode)left).val();
				r = ((BoolLiteralNode)right).val();
				if(operator == BinaryOpNode.BinaryOp.LOGIC_AND)
					return new BoolLiteralNode(null, l&&r);
				else
					return new BoolLiteralNode(null, l||r);
			}else if(type instanceof TypeInt)
			{
				int l, r;
				l = ((IntLiteralNode)left).val();
				r = ((IntLiteralNode)right).val();
				switch (operator)
				{
					case LSHIFT: return new IntLiteralNode(null, l << r);
					case RSHIFT: return new IntLiteralNode(null, l >> r);
					case ADD: return new IntLiteralNode(null, l + r);
					case SUB: return new IntLiteralNode(null, l - r);
					case MUL: return new IntLiteralNode(null, l * r);
					case DIV: return new IntLiteralNode(null, l / r);
					case MOD: return new IntLiteralNode(null, l % r);
					case BIT_OR: return new IntLiteralNode(null, l | r);
					case BIT_AND: return new IntLiteralNode(null, l & r);
					case BIT_XOR: return new IntLiteralNode(null, l ^ r);
					case LT: return new BoolLiteralNode(null, l < r);
					case GT: return new BoolLiteralNode(null, l > r);
					case LE: return new BoolLiteralNode(null, l <= r);
					case GE: return new BoolLiteralNode(null, l >= r);
					case EQ: return new BoolLiteralNode(null, l == r);
					case NE: return new BoolLiteralNode(null, l != r);
				}
			}else if(type instanceof TypeString)
			{
				String l, r;
				l = ((StringLiteralNode) left).val();
				r = ((StringLiteralNode) right).val();
				if(operator == BinaryOpNode.BinaryOp.ADD)
					return new StringLiteralNode(null, l+r);
				int val = l.compareTo(r);
				switch (operator)
				{
					case LT: return new BoolLiteralNode(null, val<0);
					case LE: return new BoolLiteralNode(null, val<=0);
					case GT: return new BoolLiteralNode(null, val>0);
					case GE: return new BoolLiteralNode(null, val>=0);
					case EQ: return new BoolLiteralNode(null, val==0);
					case NE: return new BoolLiteralNode(null, val!=0);
				}
			}
			throw new RuntimeException("Unexpected error");
		}else
			return node;
	}
	private ExprNode convert(PrefixOpNode node)
	{
		if(node.isConst())
		{
			UnaryOpNode.UnaryOp operator = node.operator();
			if(node.type() instanceof TypeBool)
				return new BoolLiteralNode(null, ((BoolLiteralNode)node.expr()).val());
			int val = ((IntLiteralNode) node.expr()).val();
			switch (operator)
			{
				case ADD:
					return new IntLiteralNode(null, +val);
				case MINUS:
					return new IntLiteralNode(null, -val);
				case BIT_NOT:
					return new IntLiteralNode(null, ~val);
				default:
			}
			throw new RuntimeException("Unknown error.");
		}else
			return node;
	}
	private ExprNode convert(ExprNode node)
	{
		if(node instanceof BinaryOpNode)
			return convert((BinaryOpNode) node);
		else if(node instanceof PrefixOpNode)
			return convert((PrefixOpNode) node);
		else
			return node;
	}
	@Override
	public void visit(List<? extends ASTNode> node)
	{
		super.visit(node);
		int idx = 0;
		for(ASTNode i: node)
		{
			if(i instanceof ExprNode){
				throw new RuntimeException("Unknown error");
			}
			idx++;
		}
	}


	@Override
	public Void visit(ExprStmtNode node)
	{
		super.visit(node);
		node.setExpr(convert(node.expr()));
		return null;
	}

	@Override
	public Void visit(IfNode node)
	{
		super.visit(node);
		node.setCondi(convert(node.condi()));
		return null;
	}

	@Override
	public Void visit(WhileNode node)
	{
		super.visit(node);
		node.setCondi(convert(node.condi()));
		return null;
	}

	@Override
	public Void visit(ForNode node)
	{
		super.visit(node);
		node.setCondi(convert(node.condi()));
		node.setInit(convert(node.init()));
		node.setStep(convert(node.step()));
		return null;
	}

	@Override
	public Void visit(BreakNode node)
	{
		super.visit(node);
		return null;
	}

	@Override
	public Void visit(ContinueNode node)
	{
		return super.visit(node);
	}

	@Override
	public Void visit(ReturnNode node)
	{
		super.visit(node);
		node.setRet(convert(node.ret()));
		return null;
	}

	@Override
	public Void visit(VarDecNode node)
	{
		super.visit(node);
		for(VariableEntity i : node.entity())
			if(i.init()!=null)
				i.setInit(convert(i.init()));
		return null;
	}

	@Override
	public Void visit(FunDefNode node)
	{
		return super.visit(node);
	}

	@Override
	public Void visit(ClassDefNode node)
	{
		return super.visit(node);
	}

	@Override
	public Void visit(AssignNode node)
	{
		super.visit(node);
		node.setLhs(convert(node.lhs()));
		node.setRhs(convert(node.rhs()));
		return null;
	}

	@Override
	public Void visit(BinaryOpNode node)
	{
		super.visit(node);
		node.setLeft(convert(node.left()));
		node.setRight(convert(node.right()));
		return null;
	}

	@Override
	public Void visit(CreatorNode node)
	{
		super.visit(node);
		int idx = 0;
		for(ExprNode i : node.args())
		{
			node.args().set(idx, convert(i));
			idx++;
		}

		return null;
	}

	@Override
	public Void visit(PrefixOpNode node)
	{
		super.visit(node);
		node.setExpr(convert(node.expr()));
		return null;
	}

	@Override
	public Void visit(SuffixOpNode node)
	{
		super.visit(node);
		node.setExpr(convert(node.expr()));
		return null;
	}

	@Override
	public Void visit(ArefNode node)
	{
		super.visit(node);
		node.setIndex(node.index());
		return null;
	}

	@Override
	public Void visit(MemberNode node)
	{
		return super.visit(node);
	}

	@Override
	public Void visit(FuncallNode node)
	{
		super.visit(node);
		int idx = 0;
		for(ExprNode i : node.params())
		{
			node.params().set(idx, convert(i));
			idx++;
		}
		return null;
	}

	@Override
	public Void visit(VariableNode node)
	{
		return super.visit(node);
	}

	@Override
	public Void visit(IntLiteralNode node)
	{
		return super.visit(node);
	}

	@Override
	public Void visit(StringLiteralNode node)
	{
		return super.visit(node);
	}

	@Override
	public Void visit(BoolLiteralNode node)
	{
		return super.visit(node);
	}
}
