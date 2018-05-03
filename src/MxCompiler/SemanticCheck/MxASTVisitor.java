/*
	Coded by timemachine on 18-4-29
	MxCompiler.SemanticCheck.MxASTVisitor
*/


package MxCompiler.SemanticCheck;

import MxCompiler.AST.*;
import MxCompiler.Entities.ClassEntity;
import MxCompiler.Entities.FunctionEntity;
import MxCompiler.Entities.ParameterEntity;
import MxCompiler.Entities.VariableEntity;
import MxCompiler.Options;
import MxCompiler.Type.Type;
import MxCompiler.Type.TypeTable;
import MxCompiler.Util.SemanticError;
import MxCompiler.parser.MxBaseVisitor;
import MxCompiler.parser.MxParser;
import MxCompiler.tools.Debuger;
import jdk.nashorn.internal.ir.FunctionNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class MxASTVisitor extends MxBaseVisitor
{

	private ParseTreeProperty<Object> map = new ParseTreeProperty<>();
	private ASTree ast = null;
	private TypeTable typeTable;

	public MxASTVisitor()
	{
		typeTable = Options.typeTable;
	}

	public ASTree ast()
	{
		return ast;
	}

	@Override
	public Object visitConstBoolExpr(MxParser.ConstBoolExprContext ctx)
	{
		Object ret = super.visitConstBoolExpr(ctx);
		Boolean val = ctx.getText()=="true"? true : false;
		map.put(ctx, new BoolLiteralNode(new SourcePosition(ctx), val));
		return ret;
	}

	@Override
	public Object visitArraySpecifier(MxParser.ArraySpecifierContext ctx)
	{
		return super.visitArraySpecifier(ctx);
	}

	@Override
	public Object visitConstIntExpr(MxParser.ConstIntExprContext ctx)
	{
		Object ret = super.visitConstIntExpr(ctx);
		map.put(ctx, new IntLiteralNode(new SourcePosition(ctx), Integer.parseInt(ctx.Const().getText())));
		return ret;
	}

	@Override
	public Object visitNewExpr(MxParser.NewExprContext ctx)
	{
		Object ret = super.visitNewExpr(ctx);
		map.put(ctx, map.get(ctx.creator()));
		return ret;
	}

	@Override
	public Object visitVariableExpr(MxParser.VariableExprContext ctx)
	{
		Object ret = super.visitVariableExpr(ctx);
		map.put(ctx, new VariableNode(ctx.Identifier().getText(), new SourcePosition(ctx)));
		return ret;
	}

	@Override
	public Object visitThisExpr(MxParser.ThisExprContext ctx)
	{
		Object ret = super.visitThisExpr(ctx);
		map.put(ctx, new VariableNode("this", new SourcePosition(ctx)));
		return ret;
	}

	@Override
	public Object visitPrefixExpr(MxParser.PrefixExprContext ctx)
	{
		Object ret = super.visitPrefixExpr(ctx);
		PrefixOpNode.UnaryOp op = null;
		switch (ctx.op.getText())
		{
			case "++":op=PrefixOpNode.UnaryOp.PRE_INC;break;
			case "--":op=PrefixOpNode.UnaryOp.PRE_DEC;break;
			case "+":op=PrefixOpNode.UnaryOp.ADD;break;
			case "-":op=PrefixOpNode.UnaryOp.MINUS;break;
			case "~":op=PrefixOpNode.UnaryOp.BIT_NOT;break;
			case "!":op=PrefixOpNode.UnaryOp.LOGIC_NOT;break;

		}
		map.put(ctx, new PrefixOpNode(new SourcePosition(ctx.op), op, (ExprNode)map.get(ctx.expr())));
		return ret;
	}

	@Override
	public Object visitFuncallExpr(MxParser.FuncallExprContext ctx)
	{
		Object ret = super.visitFuncallExpr(ctx);
		ExprNode func = (ExprNode)map.get(ctx.expr());
		List<ExprNode> params = (List<ExprNode>)map.get(ctx.argumentExprList());
		if(params == null)
			params = new LinkedList<ExprNode>();
		map.put(ctx, new FuncallNode(func, params));
		return ret;
	}

	@Override
	public Object visitSuffixExpr(MxParser.SuffixExprContext ctx)
	{
		Object ret = super.visitSuffixExpr(ctx);
		SuffixOpNode.UnaryOp op = null;
		switch (ctx.op.getText())
		{
			case "++":op=SuffixOpNode.UnaryOp.SUF_INC;break;
			case "--":op=SuffixOpNode.UnaryOp.SUF_DEC;break;
		}
		map.put(ctx, new SuffixOpNode(new SourcePosition(ctx.op), op, (ExprNode)map.get(ctx.expr())));
		return ret;
	}

	@Override
	public Object visitArefExpr(MxParser.ArefExprContext ctx)
	{
		Object ret = super.visitArefExpr(ctx);
		ExprNode ref, index;
		ref = (ExprNode)map.get(ctx.expr(0));
		index = (ExprNode)map.get(ctx.expr(1));
		map.put(ctx, new ArefNode(ref, index));
		return ret;
	}

	@Override
	public Object visitMemberExpr(MxParser.MemberExprContext ctx)
	{
		Object ret = super.visitMemberExpr(ctx);
		ExprNode expr = (ExprNode) map.get(ctx.expr());
		map.put(ctx, new MemberNode(expr, ctx.Identifier().getText(),
								new SourcePosition(ctx)));
		return ret;
	}

	@Override
	public Object visitBinaryExpr(MxParser.BinaryExprContext ctx)
	{

		Object ret = super.visitBinaryExpr(ctx);
		BinaryOpNode.BinaryOp op=null;
		switch (ctx.op.getText())
		{
			case "+": op=BinaryOpNode.BinaryOp.ADD; break;
			case "-": op=BinaryOpNode.BinaryOp.SUB; break;
			case "*": op=BinaryOpNode.BinaryOp.MUL; break;
			case "/": op=BinaryOpNode.BinaryOp.DIV; break;
			case "%": op=BinaryOpNode.BinaryOp.MOD; break;
			case "<<": op=BinaryOpNode.BinaryOp.LSHIFT; break;
			case ">>": op=BinaryOpNode.BinaryOp.RSHIFT; break;
			case "<": op=BinaryOpNode.BinaryOp.LT; break;
			case ">": op=BinaryOpNode.BinaryOp.GT; break;
			case "<=": op=BinaryOpNode.BinaryOp.LE; break;
			case ">=": op=BinaryOpNode.BinaryOp.GE; break;
			case "==": op=BinaryOpNode.BinaryOp.EQ; break;
			case "!=": op=BinaryOpNode.BinaryOp.NE; break;
			case "&": op=BinaryOpNode.BinaryOp.BIT_AND; break;
			case "^": op=BinaryOpNode.BinaryOp.BIT_XOR; break;
			case "|": op=BinaryOpNode.BinaryOp.BIT_OR; break;
			case "&&": op=BinaryOpNode.BinaryOp.LOGIC_AND; break;
			case "||": op=BinaryOpNode.BinaryOp.LOGIC_OR; break;
			case "=": op=null; break;
		}
		ExprNode left, right;
		left = (ExprNode)map.get(ctx.expr(0));
		right = (ExprNode)map.get(ctx.expr(1));
		if(op!=null)
		{
			map.put(ctx, new BinaryOpNode(new SourcePosition(ctx.op), left, right, op));
		}else
			//Assign
		{
			map.put(ctx, new AssignNode(left, right));
		}
		return ret;
	}

	@Override
	public Object visitSubExpr(MxParser.SubExprContext ctx)
	{
		Object ret = super.visitSubExpr(ctx);
		map.put(ctx, map.get(ctx.expr()));
		return ret;
	}

	@Override
	public Object visitConstStringExpr(MxParser.ConstStringExprContext ctx)
	{
		Object ret = super.visitConstStringExpr(ctx);
		map.put(ctx, new StringLiteralNode(new SourcePosition(ctx), ctx.getText()));
		return ret;
	}

	@Override
	public Object visitErrorCreator(MxParser.ErrorCreatorContext ctx)
	{
		throw new SemanticError(new SourcePosition(ctx), "Array excepted.");
		//return super.visitErrorCreator(ctx);
	}

	@Override
	public Object visitArrayCreator(MxParser.ArrayCreatorContext ctx)
	{
		Object ret = super.visitArrayCreator(ctx);
		int dim = ctx.expr().size() + ctx.arraySpecifier().size();
		Type type = typeTable.getType(ctx.typeSpecifier().getText(), dim);
		List<ExprNode> args = new LinkedList<ExprNode>();
		for(int i=0;i<ctx.expr().size();++i)
		{
			ExprNode expr = (ExprNode) map.get(ctx.expr(i));
			args.add(expr);
		}
		map.put(ctx, new CreatorNode(new SourcePosition(ctx), type, args, dim));
		return ret;
	}

	@Override
	public Object visitSingleCreator(MxParser.SingleCreatorContext ctx)
	{
		Object ret = super.visitSingleCreator(ctx);
		Type type = typeTable.getType(ctx.typeSpecifier().getText());
		List<ExprNode> args = new LinkedList<ExprNode>();
		map.put(ctx, new CreatorNode(new SourcePosition(ctx), type, args, 0));
		return ret;
	}

	@Override
	public Object visitArgumentExprList(MxParser.ArgumentExprListContext ctx)
	{
		Object ret = super.visitArgumentExprList(ctx);
		List<ExprNode> list;
		if(ctx.argumentExprList()==null)
			list = new LinkedList<>();
		else
			list = (List<ExprNode>)map.get(ctx.argumentExprList());
		list.add((ExprNode) map.get(ctx.expr()));
		map.put(ctx, list);
		return ret;
	}

	@Override
	public Object visitDeclaration(MxParser.DeclarationContext ctx)
	{
		Object ret = super.visitDeclaration(ctx);
		Type type = (Type)map.get(ctx.typeSpecifier());
		List<VariableEntity> list = (List<VariableEntity>)map.get(ctx.initDeclaratorList());
		for(int i=0;i<list.size();++i)
			list.get(i).setType(type);

		map.put(ctx,
				new VarDecNode(new SourcePosition(ctx),
						type,
						list));
		return ret;
	}

	@Override
	public Object visitInitDeclaratorList(MxParser.InitDeclaratorListContext ctx)
	{
		Object ret = super.visitInitDeclaratorList(ctx);
		List<VariableEntity> list;
		if(ctx.initDeclaratorList()==null)
			list = new LinkedList<VariableEntity>();
		else
			list = (List<VariableEntity>)map.get(ctx.initDeclaratorList());
		list.add((VariableEntity) map.get(ctx.initDeclarator()));
		map.put(ctx, list);
		return ret;
	}

	@Override
	public Object visitInitDeclarator(MxParser.InitDeclaratorContext ctx)
	{
		Object ret = super.visitInitDeclarator(ctx);
		//set type later...
		if(ctx.expr()==null)
		{
			map.put(ctx,
					new VariableEntity(ctx.declarator().getText(),
							null,
							new SourcePosition(ctx),
							null));
		}else{
			map.put(ctx,
					new VariableEntity(ctx.declarator().getText(),
							null,
							new SourcePosition(ctx),
							(ExprNode) map.get(ctx.expr())));
		}
		return ret;
	}

	@Override
	public Object visitVoid(MxParser.VoidContext ctx)
	{
		Object ret = super.visitVoid(ctx);
		map.put(ctx, typeTable.getType("void"));
		return ret;
	}

	@Override
	public Object visitBool(MxParser.BoolContext ctx)
	{
		Object ret = super.visitBool(ctx);
		map.put(ctx, typeTable.getType("bool"));
		return ret;
	}

	@Override
	public Object visitString(MxParser.StringContext ctx)
	{
		Object ret = super.visitString(ctx);
		map.put(ctx, typeTable.getType("string"));
		return ret;
	}

	@Override
	public Object visitArray(MxParser.ArrayContext ctx)
	{
		Object ret = super.visitArray(ctx);
		map.put(ctx, ((Type)map.get(ctx.typeSpecifier())).next());
		return ret;
	}

	@Override
	public Object visitClass(MxParser.ClassContext ctx)
	{
		Object ret = super.visitClass(ctx);
		map.put(ctx, typeTable.getType(ctx.getText()));
		return ret;
	}

	@Override
	public Object visitInt(MxParser.IntContext ctx)
	{
		Object ret = super.visitInt(ctx);
		map.put(ctx, typeTable.getType("int"));
		return ret;
	}

	@Override
	public Object visitDeclarator(MxParser.DeclaratorContext ctx)
	{
		Object ret = super.visitDeclarator(ctx);
		//Nothing
		return ret;
	}

	@Override
	public Object visitClassName(MxParser.ClassNameContext ctx)
	{
		Object ret = super.visitClassName(ctx);
		//Nothing
		return ret;
	}

	@Override
	public Object visitParameterList(MxParser.ParameterListContext ctx)
	{
		Object ret = super.visitParameterList(ctx);
		List<ParameterEntity> list;
		if(ctx.parameterList() == null)
			list = new LinkedList<ParameterEntity>();
		else
			list = (List<ParameterEntity>)map.get(ctx.parameterList());
		list.add((ParameterEntity) map.get(ctx.parameterDeclaration()));
		map.put(ctx, list);
		return ret;
	}

	@Override
	public Object visitParameterDeclaration(MxParser.ParameterDeclarationContext ctx)
	{
		Object ret = super.visitParameterDeclaration(ctx);
		ParameterEntity entity =
				new ParameterEntity(ctx.declarator().getText(),
						typeTable.getType(ctx.typeSpecifier().getText()),
						new SourcePosition(ctx));
		map.put(ctx, entity);
		return ret;
	}

	@Override
	public Object visitStatement(MxParser.StatementContext ctx)
	{
		Object ret = super.visitStatement(ctx);
		if(ctx.children.size() > 1)
			throw new RuntimeException("More than 1 child in statement.");
		map.put(ctx, map.get(ctx.getChild(0)));
		return ret;
	}


	@Override
	public Object visitCompoundStatement(MxParser.CompoundStatementContext ctx)
	{
		Object ret = super.visitCompoundStatement(ctx);
		List<StmtNode> list = new ArrayList<StmtNode>();
		for(int i=0;i<ctx.blockItem().size();++i)
		{
			list.add((StmtNode) map.get(ctx.blockItem(i)));
		}
		//Create scope later
		map.put(ctx, new BlockNode(new SourcePosition(ctx), list, null));
		return ret;
	}

	@Override
	public Object visitBlockItem(MxParser.BlockItemContext ctx)
	{
		Object ret = super.visitBlockItem(ctx);
		if(ctx.children.size() > 1)
			throw new RuntimeException("More than 1 child in blockItem.");
		map.put(ctx, map.get(ctx.getChild(0)));
		return ret;
	}

	@Override
	public Object visitExprStatement(MxParser.ExprStatementContext ctx)
	{
		Object ret = super.visitExprStatement(ctx);
		ExprStmtNode node = null;
		ExprNode expr = null;
		//Not empty statement
		if(ctx.expr() != null)
			expr = (ExprNode) map.get(ctx.expr());
		node = new ExprStmtNode(new SourcePosition(ctx), expr);
		map.put(ctx, node);
		return ret;
	}

	@Override
	public Object visitSelectionStatement(MxParser.SelectionStatementContext ctx)
	{
		Object ret = super.visitSelectionStatement(ctx);
		IfNode node;
		StmtNode elseBody = null;
		if(ctx.statement().size() > 1)
			elseBody =(BlockNode) map.get(ctx.statement(1));
		node = new IfNode(new SourcePosition(ctx),
				(ExprNode) map.get(ctx.expr()),
				(StmtNode) map.get(ctx.statement(0)),
				elseBody);
		map.put(ctx, node);
		return ret;
	}

	@Override
	public Object visitWhile(MxParser.WhileContext ctx)
	{
		Object ret = super.visitWhile(ctx);
		WhileNode node;
		node = new WhileNode(new SourcePosition(ctx),
				(ExprNode) map.get(ctx.expr()),
				(StmtNode) map.get(ctx.statement()) );
		map.put(ctx, node);
		return ret;
	}

	@Override
	public Object visitFor(MxParser.ForContext ctx)
	{
		Object ret = super.visitFor(ctx);
		ForNode node;
		List<ExprNode> cList = (List<ExprNode>) map.get(ctx.forCondition());;

		node = new ForNode(new SourcePosition(ctx),
				cList.get(0), cList.get(1), cList.get(2),
				(StmtNode)map.get(ctx.statement()));
		map.put(ctx, node);
		return ret;
	}

	@Override
	public Object visitForCondition(MxParser.ForConditionContext ctx)
	{
		Object ret = super.visitForCondition(ctx);
		List<ExprNode> list = new LinkedList<ExprNode>();
		if(ctx.forInit!=null)
			list.add((ExprNode) map.get(ctx.forInit));
		else
			list.add(null);
		if(ctx.forCondi!=null)
			list.add((ExprNode) map.get(ctx.forCondi));
		else
			list.add(null);
		if(ctx.forStep!=null)
			list.add((ExprNode) map.get(ctx.forStep));
		else
			list.add(null);
		map.put(ctx, list);
		return ret;
	}


	@Override
	public Object visitContinueStmt(MxParser.ContinueStmtContext ctx)
	{
		Object ret = super.visitContinueStmt(ctx);
		map.put(ctx, new ContinueNode(new SourcePosition(ctx)));
		return ret;
	}

	@Override
	public Object visitBreakStmt(MxParser.BreakStmtContext ctx)
	{
		Object ret = super.visitBreakStmt(ctx);
		map.put(ctx, new ContinueNode(new SourcePosition(ctx)));
		return ret;
	}

	@Override
	public Object visitReturnStmt(MxParser.ReturnStmtContext ctx)
	{
		Object ret = super.visitReturnStmt(ctx);
		ExprNode expr = null;
		if(ctx.expr()!= null)
			expr = (ExprNode) map.get(ctx.expr());
		map.put(ctx, new ReturnNode(new SourcePosition(ctx), expr));
		return ret;
	}

	@Override
	public Object visitCompilationUnit(MxParser.CompilationUnitContext ctx)
	{
		Object ret = super.visitCompilationUnit(ctx);
		//Build ASTree
		List<ASTNode> definitionNodes = new ArrayList<>();
		for(int i=0;i<ctx.externalDeclaration().size();++i)
			definitionNodes.add((ASTNode) map.get(ctx.externalDeclaration(i)));
		ast = new ASTree(definitionNodes);
		return ret;
	}

	@Override
	public Object visitExternalDeclaration(MxParser.ExternalDeclarationContext ctx)
	{
		Object ret = super.visitExternalDeclaration(ctx);
		//No more than 1
		map.put(ctx, map.get(ctx.getChild(0)));
		return ret;
	}

	@Override
	public Object visitClassDefinition(MxParser.ClassDefinitionContext ctx)
	{
		Object ret = super.visitClassDefinition(ctx);
		String name = ctx.className().getText();
		List<FunDefNode> funList = new ArrayList<FunDefNode>();
		List<VarDecNode> varList = new ArrayList<VarDecNode>();
		FunctionEntity constructor = null;
		for(MxParser.DeclarationContext i : ctx.declaration())
		{
			varList.add((VarDecNode) map.get(i));

		}
		for(MxParser.FunctionDefinitionContext i : ctx.functionDefinition())
		{
			funList.add((FunDefNode) map.get(i));
		}
		if(ctx.constructorDefinition().size() > 1)
			throw new SemanticError(
				new SourcePosition(ctx.constructorDefinition(1)),
				"Multi constructor.");
		for(MxParser.ConstructorDefinitionContext i : ctx.constructorDefinition())
		{
			constructor = ((FunDefNode) map.get(i)).entity();
			if(constructor.params().size() > 0)
				throw new SemanticError(
						new SourcePosition(i),
						"Constructor can not have params.");
		}

		ClassEntity entity;
		//scope and size remain to complete later
		entity = new ClassEntity(name,
				typeTable.getType(name),
				new SourcePosition(ctx),
				funList, varList, constructor,
				null, 0);
		map.put(ctx, new ClassDefNode(new SourcePosition(ctx), entity));
		return ret;
	}

	@Override
	public Object visitFunctionDefinition(MxParser.FunctionDefinitionContext ctx)
	{
		Object ret = super.visitFunctionDefinition(ctx);
		FunctionEntity entity;
		Type type = (Type)map.get(ctx.typeSpecifier());
		String name = ctx.declarator().getText();
		BlockNode body = (BlockNode)map.get(ctx.compoundStatement());
		List<ParameterEntity> params =
				(LinkedList<ParameterEntity>) map.get(ctx.parameterList());
		entity = new FunctionEntity(name, type, new SourcePosition(ctx),
				params, body);
		map.put(ctx, new FunDefNode(new SourcePosition(ctx), entity));
		return ret;
	}

	@Override
	public Object visitConstructorDefinition(MxParser.ConstructorDefinitionContext ctx)
	{
		Object ret = super.visitConstructorDefinition(ctx);
		FunctionEntity entity;
		Type type = typeTable.getType("void");
		String name = "";
		BlockNode body = (BlockNode)map.get(ctx.compoundStatement());
		List<ParameterEntity> params =
				(LinkedList<ParameterEntity>) map.get(ctx.parameterList());
		entity = new FunctionEntity(name, type, new SourcePosition(ctx),
				params, body);
		map.put(ctx, new FunDefNode(new SourcePosition(ctx), entity));
		return ret;
	}

}
