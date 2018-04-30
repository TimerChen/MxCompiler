// Generated from /home/timemachine/Desktop/Code/MxCompiler/src/MxCompiler/parser/Mx.g4 by ANTLR 4.7
package MxCompiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code constIntExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstIntExpr(MxParser.ConstIntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constIntExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstIntExpr(MxParser.ConstIntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpr(MxParser.VariableExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpr(MxParser.VariableExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(MxParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(MxParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(MxParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(MxParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcallExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncallExpr(MxParser.FuncallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcallExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncallExpr(MxParser.FuncallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSuffixExpr(MxParser.SuffixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSuffixExpr(MxParser.SuffixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arefExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArefExpr(MxParser.ArefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arefExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArefExpr(MxParser.ArefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(MxParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(MxParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constStringExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstStringExpr(MxParser.ConstStringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constStringExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstStringExpr(MxParser.ConstStringExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(MxParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(MxParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#argumentExprList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExprList(MxParser.ArgumentExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#argumentExprList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExprList(MxParser.ArgumentExprListContext ctx);
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
	 * Enter a parse tree produced by the {@code void}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterVoid(MxParser.VoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code void}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitVoid(MxParser.VoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterBool(MxParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitBool(MxParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterString(MxParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitString(MxParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterArray(MxParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitArray(MxParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code class}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterClass(MxParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code class}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitClass(MxParser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterInt(MxParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitInt(MxParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MxParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MxParser.ClassDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(MxParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(MxParser.ClassNameContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#exprStatement}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(MxParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#exprStatement}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(MxParser.ExprStatementContext ctx);
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
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhile(MxParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhile(MxParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for}
	 * labeled alternative in {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterFor(MxParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for}
	 * labeled alternative in {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitFor(MxParser.ForContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(MxParser.ClassDefinitionContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#constructedfunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterConstructedfunctionDefinition(MxParser.ConstructedfunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constructedfunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitConstructedfunctionDefinition(MxParser.ConstructedfunctionDefinitionContext ctx);
}