/*
	Coded by timemachine on 18-4-30
	MxCompiler.SemanticCheck.ParseErrorListener
*/


package MxCompiler.SemanticCheck;

import MxCompiler.AST.SourcePosition;
import MxCompiler.Util.SemanticError;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ParseErrorListener extends BaseErrorListener
{
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
	{
		super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
		throw new SemanticError(new SourcePosition(line, charPositionInLine), "syntax error.");
	}
}
