package MxCompiler.Entities;

import MxCompiler.AST.FunDefNode;
import MxCompiler.AST.SourcePosition;
import MxCompiler.AST.VarDefNode;
import MxCompiler.Type.Type;
import java.util.*;

public class ClassEntity extends Entity
{
	protected SourcePosition position;

	private List<FunDefNode> funList;
	private List<VarDefNode> varList;
	private FunctionEntity constructor;
	private Scope scope;
	private int size;

	public ClassEntity(String name, Type type, SourcePosition position, SourcePosition position1, List<FunDefNode> funList, List<VarDefNode> varList, FunctionEntity constructor, Scope scope, int size)
	{
		super(name, type, position);
		this.position = position1;
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
