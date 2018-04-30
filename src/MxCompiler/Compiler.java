package MxCompiler;
import MxCompiler.SemanticCheck.MxASTVisitor;
import MxCompiler.SemanticCheck.ParseErrorListener;
import MxCompiler.tools.Debuger;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import MxCompiler.parser.*;


public class Compiler
{
	public Compiler()
	{



	}
	public void compile() throws IOException, RuntimeException
	{
		compile("");
	}
	public void compile( String fileName ) throws IOException, RuntimeException
	{

		InputStream is;
		if(fileName == "")
		{
			Debuger.printInfo("Info", "Input: stdin");
			is = System.in;
		}else{
			Debuger.printInfo("Info", "Input: "+fileName);
			is = new FileInputStream(fileName);
		}
		ParseTree tree;
		MxLexer lexer = new MxLexer(CharStreams.fromStream(is));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Debuger.printLine("Parser");
		MxParser parser = new MxParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new ParseErrorListener());

		tree = parser.compilationUnit();

		Debuger.printInfo("Output", "");
		Debuger.print(tree.toStringTree(parser));
		Debuger.println();

		Debuger.printLine("Visitor");
		MxVisitor ASTBuilder = new MxASTVisitor();
		ASTBuilder.visit(tree);
		Debuger.println();

		/*
		Debuger.printLine("Lisener");
		ParseTreeWalker walker = new ParseTreeWalker();
		MxBaseListener evalByListener = new MxBaseListener();
		walker.walk(evalByListener, tree);
		*/

	}

}