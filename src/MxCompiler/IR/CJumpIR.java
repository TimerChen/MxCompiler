/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.CJumpIR
*/


package MxCompiler.IR;

public class CJumpIR extends InsIR
{
	public enum LogicOp{LE, LT, GT, GE, EQ, NE};
	LogicOp operator;
	VarIR lhs, rhs;
	VarLabelIR aim;
	public CJumpIR(LogicOp operator, VarIR lhs, VarIR rhs, VarLabelIR aim)
	{
		this.operator = operator;
		this.lhs = lhs;
		this.rhs = rhs;
		this.aim = aim;
	}

	public LogicOp operator()
	{
		return operator;
	}

	public VarIR lhs()
	{
		return lhs;
	}

	public VarIR rhs()
	{
		return rhs;
	}

	public VarLabelIR aim()
	{
		return aim;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
