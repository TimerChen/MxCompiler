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
	private VarIR src;
	private boolean has2Dest;


	public UnaryIR(Op operator, VarIR src)
	{
		this.operator = operator;
		this.src = src;
		if(operator == Op.NEG || operator == Op.NOT)
			has2Dest = false;
		else
			has2Dest = true;
	}
	public boolean has2Dest()
	{
		return has2Dest;
	}
	public Op operator()
	{
		return operator;
	}

	public VarIR src()
	{
		return src;
	}

	public void setSrc(VarIR src)
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
