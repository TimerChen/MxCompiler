package MxCompiler.Entities;
import MxCompiler.Util.SemanticError;

import java.util.*;
/*
	Coded by timemachine on 18-4-28
	MxCompiler.Entities.Scope
*/

public class Scope extends Object
{
	private int varNumber = 0;

	private Scope parent = null;
	private Map<String, Entity>vars = new HashMap<>();

	public Scope()
	{
		this.parent = null;
	}
	public Scope(Scope parent)
	{
		this.parent = parent;
	}

	public Scope(Scope parent, Map<String, Entity> vars)
	{
		this.parent = parent;
		this.vars = vars;
	}

	public int varNumber()
	{
		return varNumber;
	}

	public Scope parent()
	{
		return parent;
	}

	public Map<String, Entity> vars()
	{
		return vars;
	}
//	public void add(ParameterEntity entity)
//	{
//		add(new VariableEntity(entity));
//	}
	public void add(ParameterEntity entity)
	{
		if(vars.containsKey(entity.name))
			throw new SemanticError(entity.position, "Repeated variable name:" + entity.name);
		entity.setRank(varNumber++);
		vars.put(entity.name, entity);
	}
	public void add(FunctionEntity entity)
	{
		if(vars.containsKey(entity.name))
			throw new SemanticError(entity.position, "Repeated variable name:" + entity.name);
		vars.put(entity.name, entity);
	}
	public void add(ClassEntity entity)
	{
		if(parent!=null)
			throw new RuntimeException("Class is not in top scope");
		if(vars.containsKey(entity.name))
			throw new SemanticError(entity.position, "Repeated variable name:" + entity.name);
		vars.put(entity.name, entity);
	}
	public Entity findCurrent(String name)
	{
		return vars.get(name);
	}
	public Entity find(String name)
	{
		Entity ret = vars.get(name);
		if(ret == null)
		{
			if(this.parent == null)
				ret = null;
			else
				ret = parent.find(name);
		}
		return ret;
	}

}
