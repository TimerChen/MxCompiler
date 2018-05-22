/*
	Coded by timemachine on 18-5-19
	MxCompiler.InsIR.CJumpIR
*/


package MxCompiler.IR;

public class CJumpIR extends InsIR
{
	public enum LogicOp{AND, OR, LE, L, G, GE, EQ, NE};
	LogicOp operator;
	VarIR lhs, rhs;
	VarLabelIR label;
	public CJumpIR(LogicOp operator, VarIR lhs, VarIR rhs, VarLabelIR label)
	{
		this.operator = operator;
		this.lhs = lhs;
		this.rhs = rhs;
		this.label = label;
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

	public VarLabelIR label()
	{
		return label;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
