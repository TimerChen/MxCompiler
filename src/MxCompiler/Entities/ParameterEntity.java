package MxCompiler.Entities;
import MxCompiler.AST.SourcePosition;
import MxCompiler.IR.*;
import MxCompiler.Type.Type;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.Entities.ParameterEntity
*/

public class ParameterEntity extends Entity
{
	private VarIR ir;
	private int rank;

	private boolean isMember;
	public ParameterEntity(String name, Type type, SourcePosition position)
	{
		super(name, type, position);
		ir = null;
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
	public VarIR regIR()
	{
		return ir;
	}

	public void setRegIR(VarIR regIR)
	{
		this.ir = regIR;
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
