package MxCompiler.Entities;
import MxCompiler.Util.SemanticError;

import java.util.*;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.Entities.Scope
*/

public class Scope extends Object
{
	private Scope parent = null;
	private Map<String, VariableEntity>vars = new HashMap<String, VariableEntity>();
	private Map<String, FunctionEntity>funs = new HashMap<String, FunctionEntity>();

	void add(VariableEntity entity)
	{
		if(vars.containsKey(entity.name))
			throw new SemanticError(entity.position, "Repeated variable name:" + entity.name);
		vars.put(entity.name, entity);
	}
	void add(FunctionEntity entity)
	{
		if(funs.containsKey(entity.name))
			throw new SemanticError(entity.position, "Repeated variable name:" + entity.name);
		funs.put(entity.name, entity);
	}
	VariableEntity findVarCurrent(String name)
	{
		return vars.get(name);
	}
	FunctionEntity findFunCurrent(String name)
	{
		return funs.get(name);
	}
	VariableEntity findVar(String name)
	{
		VariableEntity ret = vars.get(name);
		if(ret == null)
		{
			if(this.parent == null)
				ret = null;
			else
				ret = parent.findVar(name);
		}
		return ret;
	}
	FunctionEntity findFun(String name)
	{
		FunctionEntity ret = funs.get(name);
		if(ret == null)
		{
			if(this.parent == null)
				ret = null;
			else
				ret = parent.findFun(name);
		}
		return ret;
	}

}
