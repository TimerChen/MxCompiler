package MxCompiler;
import MxCompiler.*;
import MxCompiler.tools.*;
//import javax.swing.text.html.Option;
import java.io.IOException;


public class Main
{

	static void preSetting()
	{
		//MxCompiler.Options.DEBUG_MODE = true;
		Debuger.setDebugOptions();
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

		}catch (IOException error)
		{

		}
	}
}
