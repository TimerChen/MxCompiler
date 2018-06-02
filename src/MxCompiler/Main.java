package MxCompiler;
import MxCompiler.*;
import MxCompiler.AST.BlockNode;
import MxCompiler.tools.*;
//import javax.swing.text.html.Option;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.util.*;

public class Main
{

	static void preSetting()
	{
		//Debuger.setDebugOptions();
		Debuger.setDefaultOptions();
		Debuger.setVERBOSE(2);
	}

	static void init()
	{
		preSetting();
	}

	public static void main(String[] args) {
		init();
		MxCompiler.Compiler MxC = new MxCompiler.Compiler();

		try
		{
			if(args.length > 0)
			{
				if(args.length > 1)
					MxC.compile(args[0],args[1]);
				else
					MxC.compile(args[0],"");

			}
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
