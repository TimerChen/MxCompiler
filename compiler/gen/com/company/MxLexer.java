// Generated from /home/timemachine/Desktop/Code/MxCompiler/src/src/com/company/Mx.g4 by ANTLR 4.7
package com.company;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Constant=1, Expr=2, EmptySegment=3, FullSegment=4, Segment=5, Line=6, 
		Whitespace=7, Newline=8, BlockComment=9, LineComment=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Constant", "Expr", "EmptySegment", "FullSegment", "Segment", "Line", 
		"Whitespace", "Newline", "BlockComment", "LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Constant", "Expr", "EmptySegment", "FullSegment", "Segment", "Line", 
		"Whitespace", "Newline", "BlockComment", "LineComment"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\fY\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\6\5!\n\5\r\5\16\5\"\3\5\3\5\3"+
		"\6\3\6\5\6)\n\6\3\7\3\7\5\7-\n\7\3\7\3\7\3\b\6\b\62\n\b\r\b\16\b\63\3"+
		"\b\3\b\3\t\3\t\5\t:\n\t\3\t\5\t=\n\t\3\t\3\t\3\n\3\n\3\n\3\n\7\nE\n\n"+
		"\f\n\16\nH\13\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13S\n\13\f\13"+
		"\16\13V\13\13\3\13\3\13\3F\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\3\2\4\4\2\13\13\"\"\4\2\f\f\17\17\2`\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\31\3\2\2\2\7\33\3\2\2\2\t"+
		"\36\3\2\2\2\13(\3\2\2\2\r,\3\2\2\2\17\61\3\2\2\2\21<\3\2\2\2\23@\3\2\2"+
		"\2\25N\3\2\2\2\27\30\3\2\2\2\30\4\3\2\2\2\31\32\3\2\2\2\32\6\3\2\2\2\33"+
		"\34\7}\2\2\34\35\7\177\2\2\35\b\3\2\2\2\36 \7}\2\2\37!\5\r\7\2 \37\3\2"+
		"\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\7\177\2\2%\n\3\2\2\2"+
		"&)\5\7\4\2\')\5\t\5\2(&\3\2\2\2(\'\3\2\2\2)\f\3\2\2\2*-\3\2\2\2+-\7\62"+
		"\2\2,*\3\2\2\2,+\3\2\2\2-.\3\2\2\2./\7=\2\2/\16\3\2\2\2\60\62\t\2\2\2"+
		"\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2"+
		"\65\66\b\b\2\2\66\20\3\2\2\2\679\7\17\2\28:\7\f\2\298\3\2\2\29:\3\2\2"+
		"\2:=\3\2\2\2;=\7\f\2\2<\67\3\2\2\2<;\3\2\2\2=>\3\2\2\2>?\b\t\2\2?\22\3"+
		"\2\2\2@A\7\61\2\2AB\7,\2\2BF\3\2\2\2CE\13\2\2\2DC\3\2\2\2EH\3\2\2\2FG"+
		"\3\2\2\2FD\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7,\2\2JK\7\61\2\2KL\3\2\2\2L"+
		"M\b\n\2\2M\24\3\2\2\2NO\7\61\2\2OP\7\61\2\2PT\3\2\2\2QS\n\3\2\2RQ\3\2"+
		"\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\b\13\2\2X\26"+
		"\3\2\2\2\13\2\"(,\639<FT\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}