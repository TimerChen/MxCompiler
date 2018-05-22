package MxCompiler;

import MxCompiler.Entities.Scope;
import MxCompiler.Type.Type;
import MxCompiler.Type.TypeTable;
import MxCompiler.tools.Debuger;

public class Options
{
	public static boolean DEBUG_MODE = false;

	public static int DEBUGER_VERBOSE = Debuger.INFO_LEVEL_DEFAULT;

	public static Type typeVoid, typeNull, typeBool, typeInt, typeString, typeFunction;
	//Global Variable
	public static TypeTable typeTable;
	public static Scope arrayScope;

	public static Scope mainScope;
}
