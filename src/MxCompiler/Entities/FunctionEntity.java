package MxCompiler.Entities;

import MxCompiler.AST.*;
import MxCompiler.Type.*;
import java.util.List;

public class FunctionEntity extends Entity
{
	private List<Type> args;
	private BlockNode body;

	public FunctionEntity(String name, Type type, SourcePosition position, List<Type> args, BlockNode body)
	{
		super(name, type, position);
		this.args = args;
		this.body = body;
	}
}
