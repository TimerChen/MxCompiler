/*
	Coded by timemachine on 18-4-29
	MxCompiler.SemanticCheck.ASTree
*/


package MxCompiler.SemanticCheck;

import MxCompiler.AST.*;
import MxCompiler.Entities.*;
import MxCompiler.Options;
import MxCompiler.Type.*;
import MxCompiler.Util.SemanticError;
import MxCompiler.tools.Debuger;
import sun.security.ssl.Debug;

import java.util.LinkedList;
import java.util.List;


public class ASTree extends Object
{
	private Scope mainScope;

	private List<ASTNode> definitionNodes;
//	private List<ClassEntity> classEntities;
//	private List<FunctionEntity> functionEntities;
//	private List<VariableEntity> variableEntities;


	public ASTree(List<ASTNode> definitionNodes)
	{
		this.mainScope = new Scope();
		this.definitionNodes = definitionNodes;
	}

	public void resolveSymbol()
	{
		loadInteriorLibary();
		ASTSymbolVisitor visitor = new ASTSymbolVisitor(mainScope);
		Debuger.printInfo("Info","Pre setting");
		for(ASTNode i : definitionNodes)
		{
			Debuger.printInfo("Info", "visit "+i.getClass());
			if(i instanceof FunDefNode)
				visitor.preVisit((FunDefNode) i);
			else if(i instanceof ClassDefNode)
				visitor.preVisit((ClassDefNode) i);
		}
		Entity entity = mainScope.find("main");
		if(!(entity instanceof FunctionEntity && entity != null))
			throw new SemanticError(new SourcePosition(0,0), "No main function.");
		if(!(((FunctionEntity)entity).type() instanceof TypeInt))
			throw new SemanticError(entity.position(), "Main function must return int.");
		Debuger.printInfo("Info","Start resolve");
		for(ASTNode i : definitionNodes)
		{
			Debuger.printInfo("Info", "visit "+i.getClass());
			visitor.visit((StmtNode) i);
		}
	}
	public void typeCheck()
	{
		ASTTypeVisitor visitor = new ASTTypeVisitor(mainScope);
		for(ASTNode i : definitionNodes)
		{
			visitor.visit((StmtNode) i);
		}
	}
	private void loadInteriorLibary()
	{
		/*
		void print(string str);
		void println(string str);
		string getString();
		int length()
		int getInt();
		string substring(int left, int right)
		string toString(int i);
		*/
		TypeTable typeTable = Options.typeTable;
		Type typeVoid = Options.typeVoid,
				typeNull = Options.typeNull,
				typeBool = Options.typeBool,
				typeInt = Options.typeInt,
				typeString = Options.typeString;

		SourcePosition invalidPos = new SourcePosition(0, 0);
		List<ParameterEntity> list;
		//add null
		mainScope.add(new VariableEntity("null", typeNull, invalidPos, null));

		//add functions
		list = (new LinkedList<>());
		list.add(new ParameterEntity("str", typeString, invalidPos));
		mainScope.add(new FunctionEntity("print", typeVoid,	invalidPos,	list, null));
		mainScope.add(new FunctionEntity("println", typeVoid, invalidPos,	list, null));
		list = (new LinkedList<>());
		mainScope.add(new FunctionEntity("getString", typeString, invalidPos, list, null));
		mainScope.add(new FunctionEntity("length", typeInt, invalidPos, list, null));
		mainScope.add(new FunctionEntity("getInt", typeInt, invalidPos, list, null));

		list = (new LinkedList<>());
		list.add(new ParameterEntity("i", typeInt, invalidPos));
		mainScope.add(new FunctionEntity("toString", typeString, invalidPos, list, null));

		/*
		String:
			int length()
			string substring(int left, int right)
			int parseInt();
			int ord(int pos);
		*/
		Scope strScope = new Scope(mainScope);
		list = (new LinkedList<>());
		strScope.add(new FunctionEntity("length", typeInt, invalidPos, list, null));
		strScope.add(new FunctionEntity("parseInt", typeInt, invalidPos, list, null));

		list = (new LinkedList<>());
		list.add(new ParameterEntity("left", typeInt, invalidPos));
		list.add(new ParameterEntity("right", typeInt, invalidPos));
		strScope.add(new FunctionEntity("substring", typeString, invalidPos, list, null));

		list = (new LinkedList<>());
		list.add(new ParameterEntity("pos", typeInt, invalidPos));
		strScope.add(new FunctionEntity("ord", typeInt, invalidPos, list, null));

		//Interior type
		List<FunDefNode> listF = new LinkedList<FunDefNode>();
		List<VarDecNode> listV = new LinkedList<VarDecNode>();
		//???
		mainScope.add(new ClassEntity("void", typeInt, invalidPos, listF, listV, null, null, 0));
		mainScope.add(new ClassEntity("bool", typeBool, invalidPos, listF, listV, null, null, 0));
		mainScope.add(new ClassEntity("int", typeInt, invalidPos, listF, listV, null, null, 0));
		mainScope.add(new ClassEntity("string", typeString, invalidPos, listF, listV, null, strScope, 0));
		/*
		Array:
			int size()
		 */

		Options.arrayScope = new Scope(mainScope);
		list = (new LinkedList<>());
		Options.arrayScope.add(new FunctionEntity("size", typeInt, invalidPos, list, null));

		//...
	}
}
