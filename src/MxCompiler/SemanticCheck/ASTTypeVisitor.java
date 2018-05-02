/*
	Coded by timemachine on 18-5-1
	MxCompiler.SemanticCheck.ASTTypeVisitor
*/


package MxCompiler.SemanticCheck;

import MxCompiler.AST.*;
import MxCompiler.Entities.Scope;
import MxCompiler.Entities.VariableEntity;
import MxCompiler.Options;
import MxCompiler.Type.Type;
import MxCompiler.Type.TypeArray;
import MxCompiler.Type.TypeClass;
import MxCompiler.Type.TypeNull;
import MxCompiler.Util.SemanticError;
import MxCompiler.tools.Debuger;

import java.util.List;
import java.util.Stack;

public class ASTTypeVisitor extends ASTBaseVisitor
{
	Scope scope;
	private Type typeBool, typeInt, type;
	private Type currentReturn = null;

	private Stack<LoopNode> loops = new Stack<>();

	public ASTTypeVisitor(Scope scope)
	{
		this.scope = scope;
	}
	Type getType(String name)
	{
		return Options.typeTable.getType(name);
	}


	private void enterLoop(LoopNode node)
	{
		loops.push(node);
	}
	private void exitLoop()
	{
		loops.pop();
	}

	@Override
	public Void visit(BreakNode node)
	{
		if(loops.peek() == null)
			throw new SemanticError(node.position(), "Do not in a loop");
		node.loop = loops.peek();
		return super.visit(node);
	}

	@Override
	public Void visit(ContinueNode node)
	{
		if(loops.peek() == null)
			throw new SemanticError(node.position(), "Do not in a loop");
		node.loop = loops.peek();
		return super.visit(node);
	}

	@Override
	public Void visit(IfNode node)
	{
		super.visit(node);
		if(node.condi().type() != Options.typeBool)
			throw new SemanticError(node.condi().position(), "bool excepted.");
		return null;
	}

	@Override
	public Void visit(WhileNode node)
	{
		enterLoop(node);
		super.visit(node);
		if(node.condi().type() != Options.typeBool)
			throw new SemanticError(node.condi().position(), "bool excepted.");
		exitLoop();
		return null;
	}

	@Override
	public Void visit(ForNode node)
	{
		enterLoop(node);
		super.visit(node);
		if(node.condi() != null && node.condi().type() != Options.typeBool)
			throw new SemanticError(node.condi().position(), "bool excepted.");
		exitLoop();
		return null;
	}

	@Override
	public Void visit(ReturnNode node)
	{
		Type type = node.ret().type();
		if(currentReturn instanceof TypeClass || currentReturn instanceof TypeArray)
		{
			if(type != Options.typeNull && type != currentReturn)
				throw new SemanticError(node.position(), type+" found, but "+currentReturn+" excepted.");
		}else
		if(node.ret().type() != currentReturn)
			throw new SemanticError(node.position(), currentReturn+" excepted.");
		return super.visit(node);
	}

	@Override
	public Void visit(VarDecNode node)
	{
		for(VariableEntity i : node.entity())
		{
			if(i.type() != node.type())
				throw new SemanticError(i.position(), "Type error");
			if(i.init() != null && i.init().type() != node.type())
				throw new SemanticError(i.init().position(), "Type error");
		}
		return super.visit(node);
	}

	@Override
	public Void visit(FunDefNode node)
	{
		currentReturn = node.entity().type();
		//Debuger.printInfo("[Tmp]","currentReturn = "+currentReturn);
		super.visit(node);
		//Debuger.printInfo("[Tmp]","currentReturn = null;");
		currentReturn = null;
		return null;
	}

	@Override
	public Void visit(ClassDefNode node)
	{
		//...
		super.visit(node);
		return null;
	}

	@Override
	public Void visit(AssignNode node)
	{
		if(!node.lhs().isLValue())
			throw new SemanticError(node.lhs().position(), "LValue excepted");
		if(node.rhs().type() == Options.typeNull)
		{
			if(node.lhs().type() == Options.typeBool ||
					node.lhs().type() == Options.typeInt ||
					node.lhs().type() == Options.typeString)
				throw new SemanticError(node.position(), "Type error");
		}else
		if(node.lhs().type() != node.rhs().type())
			throw new SemanticError(node.position(), "Type error");
		return null;
	}

	@Override
	public Void visit(BinaryOpNode node)
	{
		super.visit(node);
		//Checked in .type() function
		node.type();
		return null;
	}

	@Override
	public Void visit(CreatorNode node)
	{
		//Nothing
		return super.visit(node);
	}

	@Override
	public Void visit(PrefixOpNode node)
	{
		super.visit(node);
		node.type();
		return null;
	}

	@Override
	public Void visit(SuffixOpNode node)
	{
		super.visit(node);
		node.type();
		return null;
	}

	@Override
	public Void visit(ArefNode node)
	{
		super.visit(node);
		node.type();
		return null;
	}

	@Override
	public Void visit(MemberNode node)
	{
		super.visit(node);
		node.type();
		return null;
	}

	@Override
	public Void visit(FuncallNode node)
	{
		super.visit(node);
		node.type();
		return null;
	}

	@Override
	public Void visit(VariableNode node)
	{
		//Noting
		return super.visit(node);
	}

}
