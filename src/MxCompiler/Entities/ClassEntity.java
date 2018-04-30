package MxCompiler.Entities;

import MxCompiler.AST.FunDefNode;
import MxCompiler.AST.SourcePosition;
import MxCompiler.AST.VarDecNode;
import MxCompiler.Type.Type;
import java.util.*;

public class ClassEntity extends Entity
{
	private List<FunDefNode> funList;
	private List<VarDecNode> varList;
	private FunctionEntity constructor;
	private Scope scope;
	private int size;

	public ClassEntity(String name, Type type, SourcePosition position, List<FunDefNode> funList, List<VarDecNode> varList, FunctionEntity constructor, Scope scope, int size)
	{
		super(name, type, position);
		this.funList = funList;
		this.varList = varList;
		this.constructor = constructor;
		this.scope = scope;
		this.size = size;
	}

	@Override
	public String toString()
	{
		String str = "Class Entity: " + name;
		str = str + "\n\t" + constructor.toString();
		for (int i=0;i<=varList.size();++i)
		{
			str = str + "\n\t" + varList.get(i).toString();
		}
		for (int i=0;i<=funList.size();++i)
		{
			str = str + "\n\t" + funList.get(i).toString();
		}
		return str;
	}
}
