package MxCompiler.Entities;

import MxCompiler.AST.*;
import MxCompiler.Type.*;

import java.util.LinkedList;
import java.util.List;

public class FunctionEntity extends Entity
{
	private List<ParameterEntity> params;
	private BlockNode body;

	public FunctionEntity(String name, Type type, SourcePosition position, List<ParameterEntity> params, BlockNode body)
	{
		super(name, type, position);
		if(params != null)
			this.params = params;
		else
			this.params = new LinkedList<>();
		this.body = body;
	}

	public List<ParameterEntity> params()
	{
		return params;
	}

	public BlockNode body()
	{
		return body;
	}
}
