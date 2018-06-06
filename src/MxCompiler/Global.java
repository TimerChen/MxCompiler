/*
	Coded by timemachine on 18-5-26
	MxCompiler.Global
*/


package MxCompiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Global
{
	static public List<Integer> regNumber = new ArrayList<>();
	static public int maxRegNumber = 0;
	static public int IRBuilder_loopDeepth = 0;
	static public boolean checkRegColored = true;

	static public List<Integer> usedRegs = new ArrayList<>();
}
