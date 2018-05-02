/*
	Coded by timemachine on 18-5-1
	MxCompiler.SemanticCheck.ASTSymbolVisitor
*/


package MxCompiler.SemanticCheck;

import MxCompiler.AST.*;
import MxCompiler.Entities.*;
import MxCompiler.Type.TypeClass;
import MxCompiler.Util.SemanticError;
import MxCompiler.tools.Debuger;

import java.util.List;
import java.util.Stack;


public class ASTSymbolVisitor extends ASTBaseVisitor
{
	private Scope currentScope;


	public ASTSymbolVisitor(Scope currentScope)
	{
		this.currentScope = currentScope;
	}
	private void newScope()
	{
		currentScope = new Scope(currentScope);
	}
	private void exitScope()
	{
		currentScope = currentScope.parent();
	}


	@Override
	public Void visit(BlockNode node)
	{
		newScope();
		node.setScope(currentScope);
		super.visit(node);
		exitScope();
		return null;
	}

	@Override
	public Void visit(VarDecNode node)
	{
		Entity entity = currentScope.find(node.type().toRootString());
		if(entity == null)
			throw new SemanticError(node.position(), "Type not find.");
		for(VariableEntity i : node.entity())
		{
			if(i.init()!=null)
				visit(i.init());
			currentScope.add(i);
		}
		//super.visit(node);
		return null;
	}

	@Override
	public Void visit(FunDefNode node)
	{
		Entity entity = currentScope.find(node.entity().type().toRootString());
		if(entity == null)
			throw new SemanticError(node.position(), "return type not find.");
		if(!(entity instanceof ClassEntity))
			throw new SemanticError(node.position(), "Type excepted.");
		currentScope.add(node.entity());
		newScope();
		for(ParameterEntity i : node.entity().params())
		{
			entity = currentScope.find(i.type().toRootString());
			if(entity == null)
				throw new SemanticError(i.position(), "type not find.");
			if(!(entity instanceof ClassEntity))
				throw new SemanticError(node.position(), "Type excepted.");
			currentScope.add(i);
		}
		//Debuger.printInfo("Tmp","visit(node.entity().body().stmts());");
		visit(node.entity().body().stmts());
		exitScope();
		return null;
	}

	@Override
	public Void visit(ClassDefNode node)
	{
		Entity entity;
		currentScope.add(node.entity());
		newScope();
		node.entity().setScope(currentScope);
		//this
		currentScope.add(new VariableEntity("this", node.entity().type(), node.entity().position(), null));

		for(VarDecNode i : node.entity().varList())
		{
			entity = currentScope.find(i.type().toRootString());
			if(entity == null)
				throw new SemanticError(i.position(), "type not find.");
			if(!(entity instanceof ClassEntity))
				throw new SemanticError(node.position(), "Type excepted.");
			if(i.entity().size() > 1)
				throw new SemanticError(i.position(),
						"variable member in class only have 1-to-1 format.");
			for(VariableEntity j : i.entity())
			{
				if(j.init() != null)
					throw new SemanticError(j.position(),
							"variable member in class can not have initializer");
				currentScope.add(j);
			}
		}

		for(FunDefNode i : node.entity().funList())
		{
			entity = currentScope.find(i.entity().type().toRootString());
			if(entity == null)
				throw new SemanticError(i.position(), "return type not find.");
			if(!(entity instanceof ClassEntity))
				throw new SemanticError(node.position(), "Type excepted.");
			currentScope.add(i.entity());
		}
		//visit
		for(FunDefNode i : node.entity().funList())
		{
			//visit function without add
			newScope();
			for(ParameterEntity j : i.entity().params())
			{
				entity = currentScope.find(j.type().toRootString());
				if(entity == null)
					throw new SemanticError(j.position(), "type not find.");
				if(!(entity instanceof ClassEntity))
					throw new SemanticError(node.position(), "Type excepted.");
				currentScope.add(j);
			}
			i.entity().body().setScope(currentScope);
			visit(i.entity().body().stmts());
			exitScope();
		}
		exitScope();
		return null;
	}

	@Override
	public Void visit(MemberNode node)
	{
		super.visit(node);
		if(!(node.parent().type() instanceof TypeClass))
			throw new SemanticError(node.position(), "Type error.");
		TypeClass type = (TypeClass)node.parent().type();
		Entity entity;
		ClassEntity cEntity;
		entity=currentScope.find(type.name());
		if(entity == null)
			throw new SemanticError(node.position(), "Type not find.");
		if(!(entity instanceof ClassEntity))
			throw new SemanticError(node.position(), "Type excepted.");
		entity = ((ClassEntity) entity).scope().findCurrent(node.name());
		if(entity == null)
			throw new SemanticError(node.position(), "No member "+node.name()+" existed.");

		return null;
	}

	@Override
	public Void visit(FuncallNode node)
	{
		super.visit(node);
		return null;
	}

	@Override
	public Void visit(VariableNode node)
	{
		Entity entity = currentScope.find(node.name());
		if(entity == null)
			throw new SemanticError(node.position(), "variable not find.");
		if(!((entity instanceof VariableEntity)||(entity instanceof FunctionEntity)))
			throw new SemanticError(node.position(), "Variable or Function excepted.");
		node.setRefEntity(entity);
		return super.visit(node);
	}

	@Override
	public Void visit(CreatorNode node)
	{
		Entity entity = currentScope.find(node.type().toRootString());
		if(entity == null)
			throw new SemanticError(node.position(), "type not find.");
		if(!(entity instanceof ClassEntity))
			throw new SemanticError(node.position(), "Type excepted.");
		return super.visit(node);
	}
	@Override
	public Void visit(StringLiteralNode node)
	{
		//...
		return super.visit(node);
	}
}
