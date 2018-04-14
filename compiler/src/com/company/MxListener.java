// Generated from /home/timemachine/Desktop/Code/MxCompiler/compiler/src/com/company/Mx.g4 by ANTLR 4.7
package com.company;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(MxParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(MxParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExpressionList(MxParser.ArgumentExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExpressionList(MxParser.ArgumentExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(MxParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(MxParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(MxParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(MxParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(MxParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(MxParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(MxParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(MxParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(MxParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(MxParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(MxParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(MxParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(MxParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(MxParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(MxParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(MxParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(MxParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(MxParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(MxParser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(MxParser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(MxParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(MxParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(MxParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(MxParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(MxParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(MxParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(MxParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(MxParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(MxParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(MxParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(MxParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(MxParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MxParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MxParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#declarationSpecifiers}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSpecifiers(MxParser.DeclarationSpecifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declarationSpecifiers}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSpecifiers(MxParser.DeclarationSpecifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSpecifier(MxParser.DeclarationSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSpecifier(MxParser.DeclarationSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclaratorList(MxParser.InitDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclaratorList(MxParser.InitDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator(MxParser.InitDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator(MxParser.InitDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(MxParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(MxParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#structOrUnionSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterStructOrUnionSpecifier(MxParser.StructOrUnionSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#structOrUnionSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitStructOrUnionSpecifier(MxParser.StructOrUnionSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#structOrUnion}.
	 * @param ctx the parse tree
	 */
	void enterStructOrUnion(MxParser.StructOrUnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#structOrUnion}.
	 * @param ctx the parse tree
	 */
	void exitStructOrUnion(MxParser.StructOrUnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#structDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclarationList(MxParser.StructDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#structDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclarationList(MxParser.StructDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(MxParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(MxParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#specifierQualifierList}.
	 * @param ctx the parse tree
	 */
	void enterSpecifierQualifierList(MxParser.SpecifierQualifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#specifierQualifierList}.
	 * @param ctx the parse tree
	 */
	void exitSpecifierQualifierList(MxParser.SpecifierQualifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#structDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaratorList(MxParser.StructDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#structDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaratorList(MxParser.StructDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#structDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclarator(MxParser.StructDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#structDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclarator(MxParser.StructDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(MxParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(MxParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterDirectDeclarator(MxParser.DirectDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitDirectDeclarator(MxParser.DirectDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#nestedParenthesesBlock}.
	 * @param ctx the parse tree
	 */
	void enterNestedParenthesesBlock(MxParser.NestedParenthesesBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#nestedParenthesesBlock}.
	 * @param ctx the parse tree
	 */
	void exitNestedParenthesesBlock(MxParser.NestedParenthesesBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterTypeList}.
	 * @param ctx the parse tree
	 */
	void enterParameterTypeList(MxParser.ParameterTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterTypeList}.
	 * @param ctx the parse tree
	 */
	void exitParameterTypeList(MxParser.ParameterTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(MxParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(MxParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(MxParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(MxParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(MxParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(MxParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void enterInitializerList(MxParser.InitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void exitInitializerList(MxParser.InitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#designation}.
	 * @param ctx the parse tree
	 */
	void enterDesignation(MxParser.DesignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#designation}.
	 * @param ctx the parse tree
	 */
	void exitDesignation(MxParser.DesignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#designatorList}.
	 * @param ctx the parse tree
	 */
	void enterDesignatorList(MxParser.DesignatorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#designatorList}.
	 * @param ctx the parse tree
	 */
	void exitDesignatorList(MxParser.DesignatorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#designator}.
	 * @param ctx the parse tree
	 */
	void enterDesignator(MxParser.DesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#designator}.
	 * @param ctx the parse tree
	 */
	void exitDesignator(MxParser.DesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(MxParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(MxParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void enterBlockItemList(MxParser.BlockItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void exitBlockItemList(MxParser.BlockItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(MxParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(MxParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectionStatement(MxParser.SelectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectionStatement(MxParser.SelectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(MxParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(MxParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition(MxParser.ForConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition(MxParser.ForConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForDeclaration(MxParser.ForDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForDeclaration(MxParser.ForDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forExpression}.
	 * @param ctx the parse tree
	 */
	void enterForExpression(MxParser.ForExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forExpression}.
	 * @param ctx the parse tree
	 */
	void exitForExpression(MxParser.ForExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(MxParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(MxParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void enterTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void exitTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#externalDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExternalDeclaration(MxParser.ExternalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#externalDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExternalDeclaration(MxParser.ExternalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationList(MxParser.DeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationList(MxParser.DeclarationListContext ctx);
}