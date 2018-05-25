package MxCompiler;
import MxCompiler.*;
import MxCompiler.AST.BlockNode;
import MxCompiler.tools.*;
import sun.security.ssl.Debug;
//import javax.swing.text.html.Option;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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

		List<Integer> list = new LinkedList<>();
		Debuger.printLine("LinkedList Test");
		int n = 1000000;
		for(int i=0;i<n;++i)
		{
			list.add(i);
		}
		ListIterator<Integer> it = list.listIterator();
		while(it.hasNext())
		{
			ListIterator<Integer> old_it = it;
			it.next();
			if(it==old_it)
			{
				Debuger.printLine("juckyou");
				break;
			}
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
