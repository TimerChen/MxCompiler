package MxCompiler.AST;

import MxCompiler.Entities.ClassEntity;
import MxCompiler.Entities.FunctionEntity;
import MxCompiler.IR.VarLabelIR;

public class FunDefNode extends DefinitionNode
{
	private FunctionEntity entity;
	private VarLabelIR exitLabel;
	private ClassEntity classEntity;
	private boolean isMember;

	public FunDefNode(SourcePosition pos, FunctionEntity entity)
	{
		super(pos, entity.name());
		this.entity = entity;
		this.classEntity = null;
		this.isMember = false;
	}

	public void setClassEntity(ClassEntity classEntity)
	{
		this.classEntity = classEntity;
		this.isMember = true;
	}

	public ClassEntity classEntity()
	{
		return classEntity;
	}

	public boolean isMember()
	{
		return isMember;
	}


	public String labelName()
	{
		if(isMember)
			return "__"+classEntity.name()+"_"+name();
		else
			return "_"+name();
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
