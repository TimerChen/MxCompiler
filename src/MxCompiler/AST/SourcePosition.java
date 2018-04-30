package MxCompiler.AST;
import MxCompiler.parser.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

public class SourcePosition extends Object
{
	public final int line;
	public final int column;

	public SourcePosition(int line, int column)
	{
		this.line = line;
		this.column = column;
	}

	public SourcePosition(Token token)
	{
		this.line = token.getLine();
		this.column = token.getCharPositionInLine();
	}

	public SourcePosition(ParserRuleContext ctx)
	{
		this(ctx.start);
	}

	public SourcePosition(TerminalNode terminal)
	{
		this(terminal.getSymbol());
	}

	@Override
	public String toString()
	{
		return "Line " + line + ":" + column;
	}

	public boolean less(SourcePosition r)
	{
		if(line != r.line)
			return line < r.line;
		return column < r.column;
	}
}
