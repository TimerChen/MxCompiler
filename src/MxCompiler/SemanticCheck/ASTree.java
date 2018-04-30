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
//	private List<ClassEntity> classEntities;
//	private List<FunctionEntity> functionEntities;
//	private List<VariableEntity> variableEntities;


	public ASTree(List<DefinitionNode> definitionNodes)
	{
		this.mainScope = new Scope();
		this.definitionNodes = definitionNodes;
	}

	public void typeCheck()
	{

	}
	public void resolveSymbol()
	{
		loadInteriorLibary();

	}
	private void loadInteriorLibary()
	{

	}
}
