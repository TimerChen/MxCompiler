/*
	Coded by timemachine on 18-4-29
	MxCompiler.SemanticCheck.MxASTVisitor
*/


package MxCompiler.SemanticCheck;

import MxCompiler.parser.MxBaseVisitor;
import MxCompiler.parser.MxParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class MxASTVisitor extends MxBaseVisitor
{

	private ParseTreeProperty<Object> map = new ParseTreeProperty<>();
	private ASTree ast;

	@Override
	public Object visitConstIntExpr(MxParser.ConstIntExprContext ctx)
	{
		Object ret = super.visitConstIntExpr(ctx);
		return ret;
	}

	@Override
	public Object visitNewExpr(MxParser.NewExprContext ctx)
	{
		Object ret = super.visitNewExpr(ctx);
		return ret;
	}

	@Override
	public Object visitVariableExpr(MxParser.VariableExprContext ctx)
	{
		Object ret = super.visitVariableExpr(ctx);
		return ret;
	}

	@Override
	public Object visitThisExpr(MxParser.ThisExprContext ctx)
	{
		Object ret = super.visitThisExpr(ctx);
		return ret;
	}

	@Override
	public Object visitPrefixExpr(MxParser.PrefixExprContext ctx)
	{
		Object ret = super.visitPrefixExpr(ctx);
		return ret;
	}

	@Override
	public Object visitFuncallExpr(MxParser.FuncallExprContext ctx)
	{
		Object ret = super.visitFuncallExpr(ctx);
		return ret;
	}

	@Override
	public Object visitSuffixExpr(MxParser.SuffixExprContext ctx)
	{
		Object ret = super.visitSuffixExpr(ctx);
		return ret;
	}

	@Override
	public Object visitArefExpr(MxParser.ArefExprContext ctx)
	{
		Object ret = super.visitArefExpr(ctx);
		return ret;
	}

	@Override
	public Object visitMemberExpr(MxParser.MemberExprContext ctx)
	{
		Object ret = super.visitMemberExpr(ctx);
		return ret;
	}

	@Override
	public Object visitBinaryExpr(MxParser.BinaryExprContext ctx)
	{
		Object ret = super.visitBinaryExpr(ctx);
		return ret;
	}

	@Override
	public Object visitSubExpr(MxParser.SubExprContext ctx)
	{
		Object ret = super.visitSubExpr(ctx);
		return ret;
	}

	@Override
	public Object visitConstStringExpr(MxParser.ConstStringExprContext ctx)
	{
		Object ret = super.visitConstStringExpr(ctx);
		return ret;
	}

	@Override
	public Object visitCreator(MxParser.CreatorContext ctx)
	{
		Object ret = super.visitCreator(ctx);
		return ret;
	}

	@Override
	public Object visitArgumentExprList(MxParser.ArgumentExprListContext ctx)
	{
		Object ret = super.visitArgumentExprList(ctx);
		return ret;
	}

	@Override
	public Object visitUnaryOperator(MxParser.UnaryOperatorContext ctx)
	{
		Object ret = super.visitUnaryOperator(ctx);
		return ret;
	}

	@Override
	public Object visitDeclaration(MxParser.DeclarationContext ctx)
	{
		Object ret = super.visitDeclaration(ctx);
		return ret;
	}

	@Override
	public Object visitInitDeclaratorList(MxParser.InitDeclaratorListContext ctx)
	{
		Object ret = super.visitInitDeclaratorList(ctx);
		return ret;
	}

	@Override
	public Object visitInitDeclarator(MxParser.InitDeclaratorContext ctx)
	{
		Object ret = super.visitInitDeclarator(ctx);
		return ret;
	}

	@Override
	public Object visitVoid(MxParser.VoidContext ctx)
	{
		Object ret = super.visitVoid(ctx);
		return ret;
	}

	@Override
	public Object visitBool(MxParser.BoolContext ctx)
	{
		Object ret = super.visitBool(ctx);
		return ret;
	}

	@Override
	public Object visitString(MxParser.StringContext ctx)
	{
		Object ret = super.visitString(ctx);
		return ret;
	}

	@Override
	public Object visitArray(MxParser.ArrayContext ctx)
	{
		Object ret = super.visitArray(ctx);
		return ret;
	}

	@Override
	public Object visitClass(MxParser.ClassContext ctx)
	{
		Object ret = super.visitClass(ctx);
		return ret;
	}

	@Override
	public Object visitInt(MxParser.IntContext ctx)
	{
		Object ret = super.visitInt(ctx);
		return ret;
	}

	@Override
	public Object visitClassDeclaration(MxParser.ClassDeclarationContext ctx)
	{
		Object ret = super.visitClassDeclaration(ctx);
		return ret;
	}

	@Override
	public Object visitDeclarator(MxParser.DeclaratorContext ctx)
	{
		Object ret = super.visitDeclarator(ctx);
		return ret;
	}

	@Override
	public Object visitClassName(MxParser.ClassNameContext ctx)
	{
		Object ret = super.visitClassName(ctx);
		return ret;
	}

	@Override
	public Object visitParameterList(MxParser.ParameterListContext ctx)
	{
		Object ret = super.visitParameterList(ctx);
		return ret;
	}

	@Override
	public Object visitParameterDeclaration(MxParser.ParameterDeclarationContext ctx)
	{
		Object ret = super.visitParameterDeclaration(ctx);
		return ret;
	}

	@Override
	public Object visitStatement(MxParser.StatementContext ctx)
	{
		Object ret = super.visitStatement(ctx);
		return ret;
	}

	@Override
	public Object visitCompoundStatement(MxParser.CompoundStatementContext ctx)
	{
		Object ret = super.visitCompoundStatement(ctx);
		return ret;
	}

	@Override
	public Object visitBlockItem(MxParser.BlockItemContext ctx)
	{
		Object ret = super.visitBlockItem(ctx);
		return ret;
	}

	@Override
	public Object visitExprStatement(MxParser.ExprStatementContext ctx)
	{
		Object ret = super.visitExprStatement(ctx);
		return ret;
	}

	@Override
	public Object visitSelectionStatement(MxParser.SelectionStatementContext ctx)
	{
		Object ret = super.visitSelectionStatement(ctx);
		return ret;
	}

	@Override
	public Object visitWhile(MxParser.WhileContext ctx)
	{
		Object ret = super.visitWhile(ctx);
		return ret;
	}

	@Override
	public Object visitFor(MxParser.ForContext ctx)
	{
		Object ret = super.visitFor(ctx);
		return ret;
	}

	@Override
	public Object visitForCondition(MxParser.ForConditionContext ctx)
	{
		Object ret = super.visitForCondition(ctx);
		return ret;
	}

	@Override
	public Object visitForDeclaration(MxParser.ForDeclarationContext ctx)
	{
		Object ret = super.visitForDeclaration(ctx);
		return ret;
	}

	@Override
	public Object visitJumpStatement(MxParser.JumpStatementContext ctx)
	{
		Object ret = super.visitJumpStatement(ctx);
		return ret;
	}

	@Override
	public Object visitCompilationUnit(MxParser.CompilationUnitContext ctx)
	{
		Object ret = super.visitCompilationUnit(ctx);
		return ret;
	}

	@Override
	public Object visitExternalDeclaration(MxParser.ExternalDeclarationContext ctx)
	{
		Object ret = super.visitExternalDeclaration(ctx);
		return ret;
	}

	@Override
	public Object visitClassDefinition(MxParser.ClassDefinitionContext ctx)
	{
		Object ret = super.visitClassDefinition(ctx);
		return ret;
	}

	@Override
	public Object visitFunctionDefinition(MxParser.FunctionDefinitionContext ctx)
	{
		Object ret = super.visitFunctionDefinition(ctx);
		return ret;
	}

	@Override
	public Object visitConstructedfunctionDefinition(MxParser.ConstructedfunctionDefinitionContext ctx)
	{
		Object ret = super.visitConstructedfunctionDefinition(ctx);
		return ret;
	}
}
