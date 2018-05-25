package MxCompiler.Entities;
import MxCompiler.AST.SourcePosition;
import MxCompiler.IR.VarRegIR;
import MxCompiler.Type.Type;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.Entities.ParameterEntity
*/

public class ParameterEntity extends Entity
{
	private VarRegIR regIR;
	private int rank;

	private boolean isMember;
	public ParameterEntity(String name, Type type, SourcePosition position)
	{
		super(name, type, position);
		regIR = null;
		rank = -1;
		isMember = false;
	}


	public boolean isMember()
	{
		return isMember;
	}

	public void setIsMember(boolean member)
	{
		isMember = true;
	}
	public VarRegIR regIR()
	{
		return regIR;
	}

	public void setRegIR(VarRegIR regIR)
	{
		this.regIR = regIR;
	}

	public int rank()
	{
		return rank;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
	}
}
