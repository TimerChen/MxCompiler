package MxCompiler;
import MxCompiler.CodeGen.*;
import MxCompiler.IR.*;
import MxCompiler.SemanticCheck.ASTree;
import MxCompiler.SemanticCheck.MxASTVisitor;
import MxCompiler.SemanticCheck.ParseErrorListener;
import MxCompiler.Type.TypeTable;
import MxCompiler.Util.SemanticError;
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
		compile("", "");
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

	private List<List<InsIR>> irLists;
	private List<BasicBlock> blkList;
	private List<StringLitIR> irLitList;
	private ASTree ast;
	private List<String> codeStr;
	private List<String> libraryStr;

	private void irGenerate(ASTree ast)
	{
		Debuger.printLine("IR Generate");
		IRBuilder irBuilder = new IRBuilder(ast);
		irLists = irBuilder.irList();
		irLitList = irBuilder.constList();

		Debuger.printLine("Code Analyze");
		CFGBuilder cfgBuilder = new CFGBuilder(irLists);
		blkList = cfgBuilder.getCFG();


	}
	private void codeTranslate(List<BasicBlock> blkList, List<StringLitIR>irLitList)
	{
		Debuger.printLine("Code Translate");
		BlockToList btl = new BlockToList(blkList);
		List<InsIR> irList = btl.toList();
		NASMTranslator translator = new NASMTranslator(irList, irLitList);

		codeStr = translator.codeStr();
	}
	private void outputCode(OutputStream os, List<String> outputStr)
	{
		Debuger.printLine("All Finished");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

		try
		{
			for (String i : outputStr)
			{
				//System.out.println(i);
				bw.write(i+"\n");
				//bw.newLine();
			}
			bw.close();
		}catch (IOException error)
		{

		}

	}
	private void Optimize(List<BasicBlock> blkList)
	{
		VarAnalyzer analyzer = new VarAnalyzer(blkList);
		List<ConflictGraph> cgs = analyzer.cGraphs();

		Debuger.printLine("Code Optimize");
		FakeAllocator allocator = new FakeAllocator(cgs);

		/*
		for(BasicBlock i: blkList)
		{
			while(i!=null)
			{
				for(InsIR j: i.irList())
				{
					Debuger.printInfo("irlist",j.toString());
				}
				i = i.next0();
			}
		}
		 */
		IRRewriter regRewriter = new IRRewriter(allocator.colors(), blkList);
		regRewriter.rewrite();

	}
	private void loadCLibrary()
	{
		Debuger.printLine("Load Library");
		String fileName = this.getClass().getResource("").getPath() + "Util/cLibrary.asm";
		//Debuger.printInfo("Library PATH", fileName);
		Debuger.printInfo("Info", "Library : "+fileName);
		InputStream is;

		try
		{
			is = new FileInputStream(fileName);
		}catch (IOException error)
		{
			Debuger.printInfo("Error", "Library not found", 100);
			Debuger.printInfo("PATH", this.getClass().getResource("").getPath(), 100);
			throw new RuntimeException("Library not found");
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		libraryStr = new ArrayList<String>();
		try
		{
			String str;
			while(true)
			{
				str = reader.readLine();
				if(str == null)
					break;
				libraryStr.add(str);
			}
			reader.close();
			is.close();
		}catch (IOException error)
		{

		}
		return;
	}
	private List<String> mergeCodeStr(List<String> code, List<String> library)
	{
		List<String> list = new ArrayList<>();
		list.addAll(code);
		list.add("; ============Library============");
		list.addAll(library);


		return list;
	}
	public void compile( String fileInName, String fileOutName ) throws IOException, RuntimeException
	{

		InputStream is;
		OutputStream os;
		if(fileInName == "")
		{
			Debuger.printInfo("Info", "Input: stdin");
			is = System.in;
		}else{
			Debuger.printInfo("Info", "Input: "+fileInName);
			is = new FileInputStream(fileInName);
		}

		if(fileOutName == "")
		{
			Debuger.printInfo("Info", "Input: stdout");
			os = System.out;
		}else{
			Debuger.printInfo("Info", "Input: "+fileOutName);
			os = new FileOutputStream(fileOutName);
		}


		//Semantic Check
		ast = parse(is);
		is.close();

		checkOnAst(ast);

		//Code Generate
		irGenerate(ast);
		Optimize(blkList);
		codeTranslate(blkList, irLitList);

		loadCLibrary();

		outputCode(os, mergeCodeStr(codeStr, libraryStr));
	}

}