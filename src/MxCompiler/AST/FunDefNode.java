package MxCompiler.AST;

import MxCompiler.Entities.FunctionEntity;
import MxCompiler.IR.VarLabelIR;

public class FunDefNode extends DefinitionNode
{
	private FunctionEntity entity;
	private VarLabelIR exitLabel;

	public FunDefNode(SourcePosition pos, FunctionEntity entity)
	{
		super(pos, entity.name());
		this.entity = entity;
	}

	public VarLabelIR exitLabel()
	{
		return exitLabel;
	}

	public void setExitLabel(VarLabelIR exitLabel)
	{
		this.exitLabel = exitLabel;
	}

	public FunctionEntity entity()
	{
		return entity;
	}

	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor)
	{
		return visitor.visit(this);
	}
}
