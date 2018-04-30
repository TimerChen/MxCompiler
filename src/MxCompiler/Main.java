package MxCompiler;
import MxCompiler.*;
import MxCompiler.AST.BlockNode;
import MxCompiler.tools.*;
//import javax.swing.text.html.Option;
import java.io.IOException;

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

		try
		{
			MxC.compile();
			Debuger.printInfo("Info", "Success compile.");
		}catch (RuntimeException error){
			Debuger.printInfo("Error", error.toString());
			System.exit(1);
		}catch (IOException error){
			Debuger.printInfo("Error", error.toString());
			System.exit(2);
		}
	}
}
