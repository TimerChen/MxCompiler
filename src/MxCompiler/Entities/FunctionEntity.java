package MxCompiler.Entities;

import MxCompiler.AST.*;
import MxCompiler.Type.*;
import java.util.List;

public class FunctionEntity extends Entity
{
	private List<ParameterEntity> params;
	private BlockNode body;

	public FunctionEntity(String name, Type type, SourcePosition position, List<ParameterEntity> params, BlockNode body)
	{
		super(name, type, position);
		this.params = params;
		this.body = body;
	}
}
