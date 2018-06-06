/*
	Coded by timemachine on 18-5-20
	MxCompiler.InsIR.CallIR
*/


package MxCompiler.IR;

import MxCompiler.AST.FunDefNode;
import MxCompiler.Entities.FunctionEntity;

import java.util.List;

public class CallIR extends InsIR
{
	private String label;
	private int pNum;

	private FunDefNode funNode;
	private List<VarIR> plist;

	private String funName;
	private VarRegIR dest;
	public CallIR(String label, int pNum)
	{
		this.label = label;
		this.pNum = pNum;

		this.funNode = null;
		this.plist = null;
		this.funName = null;
		this.dest = null;
	}

	public CallIR(String label, int pNum, FunDefNode funNode, List<VarIR> plist, String funName, VarRegIR dest)
	{
		this.label = label;
		this.pNum = pNum;
		this.funNode = funNode;
		this.plist = plist;
		this.funName = funName;
		this.dest = dest;
	}

	public String funName()
	{
		return funName;
	}

	public VarRegIR dest()
	{
		return dest;
	}

	public FunDefNode funNode()
	{
		return funNode;
	}

	public List<VarIR> plist()
	{
		return plist;
	}

	public int pNum()
	{
		return pNum;
	}

	public String label()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	@Override
	public void accept(IRVisitor visitor)
	{
		visitor.visit(this);
	}
}
