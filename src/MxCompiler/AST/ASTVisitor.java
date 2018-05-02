package MxCompiler.AST;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.AST.ASTVisitor
*/

public interface ASTVisitor<S, E> {
	// Statements
	S visit(BlockNode node);
	S visit(ExprStmtNode node);
	S visit(IfNode node);
	S visit(WhileNode node);
	S visit(ForNode node);
	S visit(BreakNode node);
	S visit(ContinueNode node);
	S visit(ReturnNode node);
	// Definitions
	S visit(VarDecNode node);
	S visit(FunDefNode node);
	S visit(ClassDefNode node);

	// Expressions
	E visit(AssignNode node);
	E visit(BinaryOpNode node);
	//E visit(UnaryOpNode node);
	E visit(CreatorNode node);
	E visit(PrefixOpNode node);
	E visit(SuffixOpNode node);
	E visit(ArefNode node);
	E visit(MemberNode node);
	E visit(FuncallNode node);
	E visit(VariableNode node);
	E visit(IntLiteralNode node);
	E visit(StringLiteralNode node);
	E visit(BoolLiteralNode node);
}