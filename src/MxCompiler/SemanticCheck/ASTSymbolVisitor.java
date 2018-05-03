/*
	Coded by timemachine on 18-5-1
	MxCompiler.SemanticCheck.ASTSymbolVisitor
*/


package MxCompiler.SemanticCheck;

import MxCompiler.AST.*;
import MxCompiler.Entities.*;
import MxCompiler.Options;
import MxCompiler.Type.TypeArray;
import MxCompiler.Type.TypeClass;
import MxCompiler.Type.TypeNull;
import MxCompiler.Type.TypeVoid;
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


	public void preVisit(FunDefNode node)
	{
		currentScope.add(node.entity());
	}
	public void preVisit(ClassDefNode node)
	{
		Entity entity;
		currentScope.add(node.entity());
		newScope();
		node.entity().setScope(currentScope);
		//this
		currentScope.add(new VariableEntity("this", node.entity().type(), node.entity().position(), null));

		//Debuger.printInfo("tmp", "number of var in Class: "+node.entity().size());
		for(VarDecNode i : node.entity().varList())
		{
			for(VariableEntity j : i.entity())
			{
				currentScope.add(j);
			}
		}

		for(FunDefNode i : node.entity().funList())
		{
			currentScope.add(i.entity());
			newScope();
			for(ParameterEntity j : i.entity().params())
			{
				currentScope.add(j);
			}
			i.entity().body().setScope(currentScope);
			//visit(i.entity().body().stmts());
			exitScope();
		}
		exitScope();
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
		currentScope = node.entity().scope();
		//this

		//Debuger.printInfo("tmp", "number of var in Class: "+node.entity().size());
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

				//Debuger.printInfo("tmp", "var in Class: "+j.type()+j.name());
			}
		}

		for(FunDefNode i : node.entity().funList())
		{
			entity = currentScope.find(i.entity().type().toRootString());
			if(entity == null)
				throw new SemanticError(i.position(), "return type not find.");
			if(!(entity instanceof ClassEntity))
				throw new SemanticError(node.position(), "Type excepted.");
		}

		//Debuger.printInfo("tmp","VVVVVVVVVVVVVVVVVVVVVVVVVVV");
		//visit
		for(FunDefNode i : node.entity().funList())
		{
			//visit function without add
			currentScope = i.entity().body().scope();
			for(ParameterEntity j : i.entity().params())
			{
				entity = currentScope.find(j.type().toRootString());
				if(entity == null)
					throw new SemanticError(j.position(), "type not find.");
				if(!(entity instanceof ClassEntity))
					throw new SemanticError(node.position(), "Type excepted.");
			}
			//Debuger.printInfo("tmp","VVVVVVVVVVVVVVVVVVVVVVVVVVV");
			visit(i.entity().body().stmts());
			exitScope();
		}
		//constructor
		entity = node.entity();
		{
			newScope();
			entity = ((ClassEntity) entity).constructor();
			visit(((FunctionEntity) entity).body().stmts());
			exitScope();
		}
		exitScope();
		return null;
	}

	@Override
	public Void visit(MemberNode node)
	{
		super.visit(node);

		if(node.parent().type() instanceof TypeVoid)
			throw new SemanticError(node.position(), "Type error.");
		if(node.parent().type() instanceof TypeNull)
			throw new SemanticError(node.position(), "Type error.");
		if(node.parent().type() instanceof TypeArray)
		{
			//???
			if(!node.name().equals("size"))
				throw new SemanticError(node.position(), "No member "+node.name()+" existed.");
			node.setRefEntity(Options.arrayScope.find("size"));
			//if(node.refEntity() == null)
				//Debuger.printInfo("tmp", "Fuck you" + node.refEntity());
			return null;
		}

		Entity entity;
		ExprNode pnode = node.parent();
		if ((pnode instanceof VariableNode) || (pnode instanceof FuncallNode) || (pnode instanceof ArefNode))
		{
			if(pnode instanceof VariableNode)
			{

				VariableEntity vEntity = (VariableEntity)((VariableNode)pnode).refEntity();
				//Debuger.printInfo("tmp", vEntity.type().toString());
				entity = currentScope.find(vEntity.type().toString());
			}else if(pnode instanceof FuncallNode)
			{

				entity = currentScope.find(((FuncallNode)pnode).type().toString());
			}else //if(pnode instanceof ArefNode)
			{
				entity = currentScope.find(((ArefNode)pnode).type().toString());
			}

			if(entity == null)
				throw new SemanticError(node.position(), "Type not find.");
			if(!(entity instanceof ClassEntity))
				throw new SemanticError(node.position(), entity.name() + " found , but type excepted.");
			//Debuger.printInfo("tmp", "Class "+ entity.name());
			entity = ((ClassEntity) entity).scope().findCurrent(node.name());
			if(entity == null)
				throw new SemanticError(node.position(), "No member "+node.name()+" existed.");
			node.setRefEntity(entity);
		}else if(pnode instanceof StringLiteralNode)
		{
			entity = currentScope.find("string");
			entity = ((ClassEntity)entity).scope().findCurrent(node.name());
			if(entity == null)
				throw new SemanticError(node.position(), "No member "+node.name()+" existed.");
			node.setRefEntity(entity);
		}else
		{
			//throw new RuntimeException("strange member.");
			throw new SemanticError(node.position(), pnode + "Type not find.");
		}

		return null;
	}

	@Override
	public Void visit(FuncallNode node)
	{
		super.visit(node);
		//node.type();
		return null;
	}

	@Override
	public Void visit(VariableNode node)
	{
		Debuger.printInfo("tmp", "FFFFFFFFFFFFFFFFFFFFFFff");
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
		if(!(node.type() instanceof TypeClass || node.type() instanceof TypeArray))
			throw new SemanticError(node.position(), entity.type() + "Type excepted.");
		return super.visit(node);
	}
	@Override
	public Void visit(StringLiteralNode node)
	{
		//...
		return super.visit(node);
	}
}
