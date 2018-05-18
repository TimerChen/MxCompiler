/*
	Coded by timemachine on 18-5-19
	MxCompiler.CodeGen.IRBuilder
*/


package MxCompiler.CodeGen;

import MxCompiler.AST.*;
import MxCompiler.IR.IR;
import MxCompiler.SemanticCheck.MxASTVisitor;
import MxCompiler.parser.MxParser;

import java.util.ArrayList;
import java.util.List;

public class IRBuilder implements ASTVisitor< List<IR>, List<IR> >
{

	List<IR> irList;
	public IRBuilder()
	{
		irList = new ArrayList<IR>();
	}

	public List<IR> irList()
	{
		return irList;
	}

	@Override
	public List<IR> visit(BlockNode node)
	{

		return null;
	}

	@Override
	public List<IR> visit(ExprStmtNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(IfNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(WhileNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(ForNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(BreakNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(ContinueNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(ReturnNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(VarDecNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(FunDefNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(ClassDefNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(AssignNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(BinaryOpNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(CreatorNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(PrefixOpNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(SuffixOpNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(ArefNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(MemberNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(FuncallNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(VariableNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(IntLiteralNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(StringLiteralNode node)
	{
		return null;
	}

	@Override
	public List<IR> visit(BoolLiteralNode node)
	{
		return null;
	}
}
