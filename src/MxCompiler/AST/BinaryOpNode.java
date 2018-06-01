package MxCompiler.AST;

import MxCompiler.IR.VarIntIR;
import MxCompiler.Options;
import MxCompiler.Type.*;
import MxCompiler.Util.SemanticError;
import MxCompiler.tools.Debuger;

import java.util.HashMap;
import java.util.Map;

public class BinaryOpNode extends ExprNode
{
	public enum BinaryOp
	{
		ADD, SUB, MUL, DIV, MOD,
		LSHIFT, RSHIFT, LT, GT, LE, GE, EQ, NE,
		BIT_AND, BIT_XOR, BIT_OR,
		LOGIC_AND, LOGIC_OR
	}
	static private Map<BinaryOp, Type>
			boolOps = new HashMap<>(),
			intOps = new HashMap<>(),
			stringOps = new HashMap<>();
	static private Type
			typeBool,
			typeInt,
			typeString;
	static boolean unInit = true;
	static public void initOpCheck()
	{
		if(!unInit)
			return;
		typeBool = Options.typeBool;
		typeInt = Options.typeInt;
		typeString = Options.typeString;

		boolOps.put(BinaryOp.LOGIC_AND, typeBool);
		boolOps.put(BinaryOp.LOGIC_OR, typeBool);
		boolOps.put(BinaryOp.EQ, typeBool);
		boolOps.put(BinaryOp.NE, typeBool);

		intOps.put(BinaryOp.ADD, typeInt);
		intOps.put(BinaryOp.SUB, typeInt);
		intOps.put(BinaryOp.MUL, typeInt);
		intOps.put(BinaryOp.DIV, typeInt);
		intOps.put(BinaryOp.MOD, typeInt);
		intOps.put(BinaryOp.LT, typeBool);
		intOps.put(BinaryOp.GT, typeBool);
		intOps.put(BinaryOp.LE, typeBool);
		intOps.put(BinaryOp.GE, typeBool);
		intOps.put(BinaryOp.EQ, typeBool);
		intOps.put(BinaryOp.NE, typeBool);
		intOps.put(BinaryOp.LSHIFT, typeInt);
		intOps.put(BinaryOp.RSHIFT, typeInt);
		intOps.put(BinaryOp.BIT_AND, typeInt);
		intOps.put(BinaryOp.BIT_XOR, typeInt);
		intOps.put(BinaryOp.BIT_OR, typeInt);

		stringOps.put(BinaryOp.ADD, typeString);
		stringOps.put(BinaryOp.LT, typeBool);
		stringOps.put(BinaryOp.GT, typeBool);
		stringOps.put(BinaryOp.LE, typeBool);
		stringOps.put(BinaryOp.GE, typeBool);
		stringOps.put(BinaryOp.EQ, typeBool);
		stringOps.put(BinaryOp.NE, typeBool);
		unInit = false;
		
	}


	private SourcePosition position;
	private ExprNode left, right;
	private BinaryOp operator;

	private boolean isConst;

	public ExprNode left()
	{
		return left;
	}

	public ExprNode right()
	{
		return right;
	}

	public BinaryOp operator()
	{
		return operator;
	}

	public void setLeft(ExprNode left)
	{
		this.left = left;
	}

	public void setRight(ExprNode right)
	{
		this.right = right;
	}

	@Override
	public boolean isConst()
	{
		return isConst;
	}

	public BinaryOpNode(SourcePosition position, ExprNode left, ExprNode right, BinaryOp operator)
	{
		initOpCheck();
		this.position = position;
		this.left = left;
		this.right = right;
		this.operator = operator;
		this.isConst = (left.isConst() && right.isConst());
	}


	private Type getType()
	{
		Type typeBool = Options.typeTable.getType("bool"),
				typeInt = Options.typeTable.getType("int"),
				typeString = Options.typeTable.getType("string");
		Type lType, rType;
		lType = left.type();
		rType = right.type();


		/*
		if(operator == BinaryOp.LOGIC_AND || operator == BinaryOp.LOGIC_OR)
			return Options.typeTable.getType("bool");
		*/

		if(Options.typeTable.isEqual(lType, rType) == false)
			throw new SemanticError(position(), "different types can not operate");

		if(lType == typeBool)
		{
			if(boolOps.containsKey(operator))
				return boolOps.get(operator);
			else
				throw new SemanticError(position, "Operation not defined.");
		}else
		if(lType == typeInt)
		{
			if(intOps.containsKey(operator))
				return intOps.get(operator);
			else
				throw new SemanticError(position, "Operation " + operator + " not defined.");
		}else
		if(lType == typeString)
		{

			if(stringOps.containsKey(operator))
				return stringOps.get(operator);
			else
				throw new SemanticError(position, "Operation not defined.");
		}else
		{
			//maybe == to check addr???
			if(operator == BinaryOp.EQ || operator == BinaryOp.NE)
				return Options.typeBool;
			else
				throw new SemanticError(position, "no-base type can not do operations.");
		}
	}

	@Override
	public Type type()
	{
		if(type == null)
			type = getType();
		return super.type();
	}

	@Override
	public SourcePosition position()
	{
		return position;
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
