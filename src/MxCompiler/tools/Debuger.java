package MxCompiler.tools;
import MxCompiler.Options;

import java.io.*;

public class Debuger
{
	static final public int INFO_LEVEL_SCILENCE = 0;
	static final public int INFO_LEVEL_DEFAULT = 1;

	static public void setDEBUG_MODE(boolean state)
	{
		printInfo("Options","DEBUG_MODE = "+state);
		Options.DEBUG_MODE = state;
	}
	public static void setVERBOSE(int state)
	{
		printInfo("Options","VERBOSE = "+state);
		Options.DEBUGER_VERBOSE = state;
	}

	static public void setDefaultOptions()
	{
		setDEBUG_MODE(false);
		setVERBOSE(0);
	}
	static public void setDebugOptions()
	{
		setDEBUG_MODE(true);
		setVERBOSE(100);
	}

	static public void printInfo(String head, String str)
	{
		printInfo(head, str, INFO_LEVEL_DEFAULT);
	}
	static public void printInfoLine(String head, String str)
	{
		printLine("[" + head + "] " + str);
	}
	static public void printLine(String str)
	{
		printlnRaw("\t================= "+str+" =================", INFO_LEVEL_DEFAULT);
	}
	static public void printInfo(String head, String str, int level)
	{
		printlnRaw("[" + head + "]\t" + str, level);
	}
	public static void print(String str)
	{
		printRaw(str, INFO_LEVEL_DEFAULT);
	}
	public static void println()
	{
		println("");
	}
	public static void println(String str)
	{
		printlnRaw(str, INFO_LEVEL_DEFAULT);
	}
	static void printlnRaw(String str, int level)
	{
		if (str == null) str = "";
		printRaw(str + "\n", level);
	}

	static void printRaw(String str, int level)
	{

		if(Options.DEBUGER_VERBOSE >= level)
			System.err.print(str);
	}

}
