package MxCompiler;
import MxCompiler.*;
import MxCompiler.AST.BlockNode;
import MxCompiler.tools.*;
import sun.security.ssl.Debug;
//import javax.swing.text.html.Option;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.util.*;

public class Main
{

	static void preSetting()
	{
		Debuger.setDebugOptions();
		//Debuger.setDefaultOptions();
	}

	static void init()
	{
		preSetting();
	}

	public static void main(String[] args) {
		init();
		MxCompiler.Compiler MxC = new MxCompiler.Compiler();

		Debuger.printLine("LinkedList Test");
		Set<Integer> set = new HashSet<>();
		set.add(1);set.add(2);set.add(3);
		Iterator<Integer>i = set.iterator();
		while(i.hasNext())
		{
			Debuger.print(" "+i.next());
		}
		Debuger.printLine("End");

		try
		{
			if(args.length > 0)
				MxC.compile(args[0]);
			else
				MxC.compile();
			Debuger.printInfo("Info", "Success compile.");
		}catch (RuntimeException error){
			Debuger.printInfo("Error", error.toString());
			throw error;
			//System.exit(1);
		}catch (IOException error){
			Debuger.printInfo("Error", error.toString());
			System.exit(2);
		}
	}
}
