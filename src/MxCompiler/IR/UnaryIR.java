/*
	Coded by timemachine on 18-5-23
	MxCompiler.IR.UnaryIR
*/


package MxCompiler.IR;

public class UnaryIR extends InsIR
{
	static VarRegIR dest0 = new VarRegIR(0),
			dest1 = new VarRegIR(2);
	public enum Op
	{
		MUL, DIV, MOD, NEG, NOT
	}
	private Op operator;
	private VarRegIR src;

	public UnaryIR(Op operator, VarRegIR src)
	{
		this.operator = operator;
		this.src = src;
	}

	public Op operator()
	{
		return operator;
	}

	public VarRegIR src()
	{
		return src;
	}

	public void setSrc(VarRegIR src)
	{
		this.src = src;
	}

	public VarRegIR dest0()
	{
		if(operator == Op.NEG || operator == Op.NOT)
			throw new RuntimeException("no dest0");
		return dest0;
	}

	public VarRegIR dest1()
	{
		if(operator == Op.NEG || operator == Op.NOT)
			throw new RuntimeException("no dest0");
		return dest1;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
