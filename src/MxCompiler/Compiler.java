package MxCompiler;
import MxCompiler.CodeGen.IRBuilder;
import MxCompiler.CodeGen.NASMTranslator;
import MxCompiler.CodeGen.NaiveAllocator;
import MxCompiler.IR.*;
import MxCompiler.SemanticCheck.ASTree;
import MxCompiler.SemanticCheck.MxASTVisitor;
import MxCompiler.SemanticCheck.ParseErrorListener;
import MxCompiler.Type.TypeTable;
import MxCompiler.tools.Debuger;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
	private void checkOnAst(ASTree ast)
	{
		Debuger.printLine("Resolve Symbol");
		ast.resolveSymbol();
		Debuger.println();

		Debuger.printLine("Type Checking");
		ast.typeCheck();
		Debuger.println();
	}

	private List<InsIR> irList;
	private List<StringLitIR> irLitList;
	private ASTree ast;
	private List<String> codeStr, libraryStr;

	private void irGenerate(ASTree ast)
	{
		Debuger.printLine("IR Generate");
		IRBuilder irBuilder = new IRBuilder(ast);
		irList = irBuilder.irList();
		irLitList = irBuilder.constList();
	}
	private void codeTranslate(List<InsIR> irList, List<StringLitIR>irLitList)
	{
		Debuger.printLine("Code Translate");
		NASMTranslator translator = new NASMTranslator(irList, irLitList);

		codeStr = translator.codeStr();
	}
	private void outputCode(List<String> outputStr)
	{
		Debuger.printLine("All Finished");
		for(String i: outputStr)
		{
			System.out.println(i);
		}
	}
	private void Optimize()
	{
		Debuger.printLine("Code Optimize");
		NaiveAllocator allocator = new NaiveAllocator(irList);
		irList = allocator.alloc();
	}
	private void loadCLibrary()
	{
		Debuger.printLine("Load Library");
	}
	private List<String> mergeCodeStr(List<String> code, List<String> library)
	{
		List<String> list = new ArrayList<>();
		list.addAll(code);
		list.addAll(library);
		return list;
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

		//Semantic Check
		ast = parse(is);
		checkOnAst(ast);

		//Code Generate
		irGenerate(ast);
		Optimize();
		codeTranslate(irList, irLitList);

		loadCLibrary();

		outputCode(mergeCodeStr(codeStr, libraryStr));
	}

}