/*
	Coded by timemachine on 18-4-29
	MxCompiler.SemanticCheck.ASTree
*/


package MxCompiler.SemanticCheck;

import MxCompiler.AST.*;
import MxCompiler.Entities.*;

import java.util.LinkedList;
import java.util.List;

public class ASTree extends Object
{
	private Scope mainScope;

	private List<DefinitionNode> definitionNodes;
	private List<ClassEntity> classEntities;
	private List<FunctionEntity> functionEntities;
	private List<VariableEntity> variableEntities;

	public ASTree()
	{
		this.mainScope = new Scope();
		definitionNodes = new LinkedList<DefinitionNode>();
		classEntities = new LinkedList<ClassEntity>();
		functionEntities = new LinkedList<FunctionEntity>();
		variableEntities = new LinkedList<VariableEntity>();
		loadInteriorLibary();
	}
	private void loadInteriorLibary()
	{

	}
}
