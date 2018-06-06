package MxCompiler.Entities;

import MxCompiler.AST.*;
import MxCompiler.IR.VarLabelIR;
import MxCompiler.IR.VarRegIR;
import MxCompiler.Type.*;

import java.util.LinkedList;
import java.util.List;

public class FunctionEntity extends Entity
{
	private List<ParameterEntity> params;
	private BlockNode body;
	private ClassEntity belongsTo;
	private FunDefNode defNode=null;

	public FunctionEntity(String name, Type type, SourcePosition position, List<ParameterEntity> params, BlockNode body)
	{
		super(name, type, position);
		if(params != null)
			this.params = params;
		else
			this.params = new LinkedList<>();
		this.body = body;
		this.belongsTo = null;
	}

	public FunDefNode defNode()
	{
		return defNode;
	}

	public void setDefNode(FunDefNode defNode)
	{
		this.defNode = defNode;
	}

	public ClassEntity belongsTo()
	{
		return belongsTo;
	}

	public void setBelongsTo(ClassEntity belongsTo)
	{
		this.belongsTo = belongsTo;
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
