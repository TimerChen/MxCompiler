/*
	Coded by timemachine on 18-5-26
	MxCompiler.Global
*/


package MxCompiler;

import java.util.ArrayList;
import java.util.List;

public class Global
{
	static public List<Integer> regNumber = new ArrayList<>();
	static public int maxRegNumber = 0;
	static public int IRBuilder_loopDeepth = 0;
	static public boolean IRBuilder_inIf = false;
}
