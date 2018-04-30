/*
	Coded by timemachine on 18-4-30
	MxCompiler.SemanticCheck.ParseErrorListener
*/


package MxCompiler.SemanticCheck;

import MxCompiler.AST.SourcePosition;
import MxCompiler.Util.SemanticError;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;

public class ParseErrorListener extends BaseErrorListener
{
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
	{
		super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
		throw new SemanticError(new SourcePosition(line, charPositionInLine), "synatax error.");
	}
}
