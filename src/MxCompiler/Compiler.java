package MxCompiler;
import MxCompiler.AST.AssignNode;
import MxCompiler.SemanticCheck.ASTree;
import MxCompiler.SemanticCheck.MxASTVisitor;
import MxCompiler.SemanticCheck.ParseErrorListener;
import MxCompiler.Type.TypeTable;
import MxCompiler.tools.Debuger;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import MxCompiler.parser.*;


public class Compiler
{
	public Compiler()
	{
		Options.typeTable = new TypeTable();


	}
	public void compile() throws IOException, RuntimeException
	{
		compile("");
	}
	private ASTree parse(InputStream is) throws IOException, RuntimeException
	{
		ParseTree tree;
		MxLexer lexer = new MxLexer(CharStreams.fromStream(is));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Debuger.printLine("Parser");
		MxParser parser = new MxParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new ParseErrorListener());

		tree = parser.compilationUnit();

		/*
		Debuger.printInfo("Output", "");
		Debuger.print(tree.toStringTree(parser));
		Debuger.println();
		*/

		Debuger.printLine("AST Building");
		MxASTVisitor ASTBuilder = new MxASTVisitor();
		ASTBuilder.visit(tree);
		Debuger.println();

		return ASTBuilder.ast();
	}
	private void CheckOnAst(ASTree ast)
	{
		Debuger.printLine("Resolve Symbol");
		ast.resolveSymbol();
		Debuger.println();

		Debuger.printLine("Type Checking");
		ast.typeCheck();
		Debuger.println();
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
		ASTree ast = parse(is);
		CheckOnAst(ast);

		/*
		Debuger.printLine("Lisener");
		ParseTreeWalker walker = new ParseTreeWalker();
		MxBaseListener evalByListener = new MxBaseListener();
		walker.walk(evalByListener, tree);
		*/

	}

}