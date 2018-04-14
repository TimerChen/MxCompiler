// Generated from /home/timemachine/Desktop/Code/MxCompiler/compiler/src/com/company/Mx.g4 by ANTLR 4.7
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
		T__0=1, T__1=2, T__2=3, T__3=4, Break=5, Continue=6, Else=7, For=8, If=9, 
		Int=10, Return=11, Struct=12, Unsigned=13, Void=14, While=15, Class=16, 
		LeftParen=17, RightParen=18, LeftBracket=19, RightBracket=20, LeftBrace=21, 
		RightBrace=22, Less=23, LessEqual=24, Greater=25, GreaterEqual=26, LeftShift=27, 
		RightShift=28, Plus=29, PlusPlus=30, Minus=31, MinusMinus=32, Star=33, 
		Div=34, Mod=35, And=36, Or=37, AndAnd=38, OrOr=39, Caret=40, Not=41, Tilde=42, 
		Question=43, Colon=44, Semi=45, Comma=46, Assign=47, StarAssign=48, DivAssign=49, 
		ModAssign=50, PlusAssign=51, MinusAssign=52, LeftShiftAssign=53, RightShiftAssign=54, 
		AndAssign=55, XorAssign=56, OrAssign=57, Equal=58, NotEqual=59, Arrow=60, 
		Dot=61, Ellipsis=62, Identifier=63, Const=64, DigitSequence=65, StringLiteral=66, 
		Whitespace=67, Newline=68, BlockComment=69, LineComment=70;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "Break", "Continue", "Else", "For", "If", 
		"Int", "Return", "Struct", "Unsigned", "Void", "While", "Class", "LeftParen", 
		"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
		"Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", "RightShift", 
		"Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", "Mod", "And", 
		"Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
		"Semi", "Comma", "Assign", "StarAssign", "DivAssign", "ModAssign", "PlusAssign", 
		"MinusAssign", "LeftShiftAssign", "RightShiftAssign", "AndAssign", "XorAssign", 
		"OrAssign", "Equal", "NotEqual", "Arrow", "Dot", "Ellipsis", "Identifier", 
		"Nondigit", "Digit", "Const", "IntConst", "NonzeroDigit", "Sign", "DigitSequence", 
		"CharacterConstant", "CCharSequence", "CChar", "EscapeSequence", "SimpleEscapeSequence", 
		"StringLiteral", "SCharSequence", "SChar", "Whitespace", "Newline", "BlockComment", 
		"LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'bool'", "'string'", "'switch'", "'goto'", "'break'", "'continue'", 
		"'else'", "'for'", "'if'", "'int'", "'return'", "'struct'", "'unsigned'", 
		"'void'", "'while'", "'class'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		"'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", 
		"'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", 
		"'?'", "':'", "';'", "','", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", 
		"'<<='", "'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'->'", "'.'", 
		"'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "Break", "Continue", "Else", "For", "If", 
		"Int", "Return", "Struct", "Unsigned", "Void", "While", "Class", "LeftParen", 
		"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
		"Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", "RightShift", 
		"Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", "Mod", "And", 
		"Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
		"Semi", "Comma", "Assign", "StarAssign", "DivAssign", "ModAssign", "PlusAssign", 
		"MinusAssign", "LeftShiftAssign", "RightShiftAssign", "AndAssign", "XorAssign", 
		"OrAssign", "Equal", "NotEqual", "Arrow", "Dot", "Ellipsis", "Identifier", 
		"Const", "DigitSequence", "StringLiteral", "Whitespace", "Newline", "BlockComment", 
		"LineComment"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2H\u01ea\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'"+
		"\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66"+
		"\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\38\38\39\39\39\3:\3:\3:\3;\3;\3"+
		";\3<\3<\3<\3=\3=\3=\3>\3>\3?\3?\3?\3?\3@\3@\3@\7@\u017f\n@\f@\16@\u0182"+
		"\13@\3A\3A\3B\3B\3C\3C\5C\u018a\nC\3D\3D\7D\u018e\nD\fD\16D\u0191\13D"+
		"\3E\3E\3F\3F\3G\6G\u0198\nG\rG\16G\u0199\3H\3H\3H\3H\3I\6I\u01a1\nI\r"+
		"I\16I\u01a2\3J\3J\5J\u01a7\nJ\3K\3K\3L\3L\3L\3M\3M\5M\u01b0\nM\3M\3M\3"+
		"N\6N\u01b5\nN\rN\16N\u01b6\3O\3O\3O\3O\3O\3O\3O\5O\u01c0\nO\3P\6P\u01c3"+
		"\nP\rP\16P\u01c4\3P\3P\3Q\3Q\5Q\u01cb\nQ\3Q\5Q\u01ce\nQ\3Q\3Q\3R\3R\3"+
		"R\3R\7R\u01d6\nR\fR\16R\u01d9\13R\3R\3R\3R\3R\3R\3S\3S\3S\3S\7S\u01e4"+
		"\nS\fS\16S\u01e7\13S\3S\3S\3\u01d7\2T\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081\2\u0083"+
		"\2\u0085B\u0087\2\u0089\2\u008b\2\u008dC\u008f\2\u0091\2\u0093\2\u0095"+
		"\2\u0097\2\u0099D\u009b\2\u009d\2\u009fE\u00a1F\u00a3G\u00a5H\3\2\13\5"+
		"\2C\\aac|\3\2\62;\3\2\63;\4\2--//\6\2\f\f\17\17))^^\f\2$$))AA^^cdhhpp"+
		"ttvvxx\6\2\f\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f\17\17\2\u01ee\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2"+
		"}\3\2\2\2\2\177\3\2\2\2\2\u0085\3\2\2\2\2\u008d\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\3\u00a7"+
		"\3\2\2\2\5\u00ac\3\2\2\2\7\u00b3\3\2\2\2\t\u00ba\3\2\2\2\13\u00bf\3\2"+
		"\2\2\r\u00c5\3\2\2\2\17\u00ce\3\2\2\2\21\u00d3\3\2\2\2\23\u00d7\3\2\2"+
		"\2\25\u00da\3\2\2\2\27\u00de\3\2\2\2\31\u00e5\3\2\2\2\33\u00ec\3\2\2\2"+
		"\35\u00f5\3\2\2\2\37\u00fa\3\2\2\2!\u0100\3\2\2\2#\u0106\3\2\2\2%\u0108"+
		"\3\2\2\2\'\u010a\3\2\2\2)\u010c\3\2\2\2+\u010e\3\2\2\2-\u0110\3\2\2\2"+
		"/\u0112\3\2\2\2\61\u0114\3\2\2\2\63\u0117\3\2\2\2\65\u0119\3\2\2\2\67"+
		"\u011c\3\2\2\29\u011f\3\2\2\2;\u0122\3\2\2\2=\u0124\3\2\2\2?\u0127\3\2"+
		"\2\2A\u0129\3\2\2\2C\u012c\3\2\2\2E\u012e\3\2\2\2G\u0130\3\2\2\2I\u0132"+
		"\3\2\2\2K\u0134\3\2\2\2M\u0136\3\2\2\2O\u0139\3\2\2\2Q\u013c\3\2\2\2S"+
		"\u013e\3\2\2\2U\u0140\3\2\2\2W\u0142\3\2\2\2Y\u0144\3\2\2\2[\u0146\3\2"+
		"\2\2]\u0148\3\2\2\2_\u014a\3\2\2\2a\u014c\3\2\2\2c\u014f\3\2\2\2e\u0152"+
		"\3\2\2\2g\u0155\3\2\2\2i\u0158\3\2\2\2k\u015b\3\2\2\2m\u015f\3\2\2\2o"+
		"\u0163\3\2\2\2q\u0166\3\2\2\2s\u0169\3\2\2\2u\u016c\3\2\2\2w\u016f\3\2"+
		"\2\2y\u0172\3\2\2\2{\u0175\3\2\2\2}\u0177\3\2\2\2\177\u017b\3\2\2\2\u0081"+
		"\u0183\3\2\2\2\u0083\u0185\3\2\2\2\u0085\u0189\3\2\2\2\u0087\u018b\3\2"+
		"\2\2\u0089\u0192\3\2\2\2\u008b\u0194\3\2\2\2\u008d\u0197\3\2\2\2\u008f"+
		"\u019b\3\2\2\2\u0091\u01a0\3\2\2\2\u0093\u01a6\3\2\2\2\u0095\u01a8\3\2"+
		"\2\2\u0097\u01aa\3\2\2\2\u0099\u01ad\3\2\2\2\u009b\u01b4\3\2\2\2\u009d"+
		"\u01bf\3\2\2\2\u009f\u01c2\3\2\2\2\u00a1\u01cd\3\2\2\2\u00a3\u01d1\3\2"+
		"\2\2\u00a5\u01df\3\2\2\2\u00a7\u00a8\7d\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa"+
		"\7q\2\2\u00aa\u00ab\7n\2\2\u00ab\4\3\2\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae"+
		"\7v\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7p\2\2\u00b1"+
		"\u00b2\7i\2\2\u00b2\6\3\2\2\2\u00b3\u00b4\7u\2\2\u00b4\u00b5\7y\2\2\u00b5"+
		"\u00b6\7k\2\2\u00b6\u00b7\7v\2\2\u00b7\u00b8\7e\2\2\u00b8\u00b9\7j\2\2"+
		"\u00b9\b\3\2\2\2\u00ba\u00bb\7i\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7v"+
		"\2\2\u00bd\u00be\7q\2\2\u00be\n\3\2\2\2\u00bf\u00c0\7d\2\2\u00c0\u00c1"+
		"\7t\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4\7m\2\2\u00c4"+
		"\f\3\2\2\2\u00c5\u00c6\7e\2\2\u00c6\u00c7\7q\2\2\u00c7\u00c8\7p\2\2\u00c8"+
		"\u00c9\7v\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc\7w\2\2"+
		"\u00cc\u00cd\7g\2\2\u00cd\16\3\2\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7"+
		"n\2\2\u00d0\u00d1\7u\2\2\u00d1\u00d2\7g\2\2\u00d2\20\3\2\2\2\u00d3\u00d4"+
		"\7h\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6\7t\2\2\u00d6\22\3\2\2\2\u00d7\u00d8"+
		"\7k\2\2\u00d8\u00d9\7h\2\2\u00d9\24\3\2\2\2\u00da\u00db\7k\2\2\u00db\u00dc"+
		"\7p\2\2\u00dc\u00dd\7v\2\2\u00dd\26\3\2\2\2\u00de\u00df\7t\2\2\u00df\u00e0"+
		"\7g\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7w\2\2\u00e2\u00e3\7t\2\2\u00e3"+
		"\u00e4\7p\2\2\u00e4\30\3\2\2\2\u00e5\u00e6\7u\2\2\u00e6\u00e7\7v\2\2\u00e7"+
		"\u00e8\7t\2\2\u00e8\u00e9\7w\2\2\u00e9\u00ea\7e\2\2\u00ea\u00eb\7v\2\2"+
		"\u00eb\32\3\2\2\2\u00ec\u00ed\7w\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7"+
		"u\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7i\2\2\u00f1\u00f2\7p\2\2\u00f2\u00f3"+
		"\7g\2\2\u00f3\u00f4\7f\2\2\u00f4\34\3\2\2\2\u00f5\u00f6\7x\2\2\u00f6\u00f7"+
		"\7q\2\2\u00f7\u00f8\7k\2\2\u00f8\u00f9\7f\2\2\u00f9\36\3\2\2\2\u00fa\u00fb"+
		"\7y\2\2\u00fb\u00fc\7j\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7n\2\2\u00fe"+
		"\u00ff\7g\2\2\u00ff \3\2\2\2\u0100\u0101\7e\2\2\u0101\u0102\7n\2\2\u0102"+
		"\u0103\7c\2\2\u0103\u0104\7u\2\2\u0104\u0105\7u\2\2\u0105\"\3\2\2\2\u0106"+
		"\u0107\7*\2\2\u0107$\3\2\2\2\u0108\u0109\7+\2\2\u0109&\3\2\2\2\u010a\u010b"+
		"\7]\2\2\u010b(\3\2\2\2\u010c\u010d\7_\2\2\u010d*\3\2\2\2\u010e\u010f\7"+
		"}\2\2\u010f,\3\2\2\2\u0110\u0111\7\177\2\2\u0111.\3\2\2\2\u0112\u0113"+
		"\7>\2\2\u0113\60\3\2\2\2\u0114\u0115\7>\2\2\u0115\u0116\7?\2\2\u0116\62"+
		"\3\2\2\2\u0117\u0118\7@\2\2\u0118\64\3\2\2\2\u0119\u011a\7@\2\2\u011a"+
		"\u011b\7?\2\2\u011b\66\3\2\2\2\u011c\u011d\7>\2\2\u011d\u011e\7>\2\2\u011e"+
		"8\3\2\2\2\u011f\u0120\7@\2\2\u0120\u0121\7@\2\2\u0121:\3\2\2\2\u0122\u0123"+
		"\7-\2\2\u0123<\3\2\2\2\u0124\u0125\7-\2\2\u0125\u0126\7-\2\2\u0126>\3"+
		"\2\2\2\u0127\u0128\7/\2\2\u0128@\3\2\2\2\u0129\u012a\7/\2\2\u012a\u012b"+
		"\7/\2\2\u012bB\3\2\2\2\u012c\u012d\7,\2\2\u012dD\3\2\2\2\u012e\u012f\7"+
		"\61\2\2\u012fF\3\2\2\2\u0130\u0131\7\'\2\2\u0131H\3\2\2\2\u0132\u0133"+
		"\7(\2\2\u0133J\3\2\2\2\u0134\u0135\7~\2\2\u0135L\3\2\2\2\u0136\u0137\7"+
		"(\2\2\u0137\u0138\7(\2\2\u0138N\3\2\2\2\u0139\u013a\7~\2\2\u013a\u013b"+
		"\7~\2\2\u013bP\3\2\2\2\u013c\u013d\7`\2\2\u013dR\3\2\2\2\u013e\u013f\7"+
		"#\2\2\u013fT\3\2\2\2\u0140\u0141\7\u0080\2\2\u0141V\3\2\2\2\u0142\u0143"+
		"\7A\2\2\u0143X\3\2\2\2\u0144\u0145\7<\2\2\u0145Z\3\2\2\2\u0146\u0147\7"+
		"=\2\2\u0147\\\3\2\2\2\u0148\u0149\7.\2\2\u0149^\3\2\2\2\u014a\u014b\7"+
		"?\2\2\u014b`\3\2\2\2\u014c\u014d\7,\2\2\u014d\u014e\7?\2\2\u014eb\3\2"+
		"\2\2\u014f\u0150\7\61\2\2\u0150\u0151\7?\2\2\u0151d\3\2\2\2\u0152\u0153"+
		"\7\'\2\2\u0153\u0154\7?\2\2\u0154f\3\2\2\2\u0155\u0156\7-\2\2\u0156\u0157"+
		"\7?\2\2\u0157h\3\2\2\2\u0158\u0159\7/\2\2\u0159\u015a\7?\2\2\u015aj\3"+
		"\2\2\2\u015b\u015c\7>\2\2\u015c\u015d\7>\2\2\u015d\u015e\7?\2\2\u015e"+
		"l\3\2\2\2\u015f\u0160\7@\2\2\u0160\u0161\7@\2\2\u0161\u0162\7?\2\2\u0162"+
		"n\3\2\2\2\u0163\u0164\7(\2\2\u0164\u0165\7?\2\2\u0165p\3\2\2\2\u0166\u0167"+
		"\7`\2\2\u0167\u0168\7?\2\2\u0168r\3\2\2\2\u0169\u016a\7~\2\2\u016a\u016b"+
		"\7?\2\2\u016bt\3\2\2\2\u016c\u016d\7?\2\2\u016d\u016e\7?\2\2\u016ev\3"+
		"\2\2\2\u016f\u0170\7#\2\2\u0170\u0171\7?\2\2\u0171x\3\2\2\2\u0172\u0173"+
		"\7/\2\2\u0173\u0174\7@\2\2\u0174z\3\2\2\2\u0175\u0176\7\60\2\2\u0176|"+
		"\3\2\2\2\u0177\u0178\7\60\2\2\u0178\u0179\7\60\2\2\u0179\u017a\7\60\2"+
		"\2\u017a~\3\2\2\2\u017b\u0180\5\u0081A\2\u017c\u017f\5\u0083B\2\u017d"+
		"\u017f\5\u0081A\2\u017e\u017c\3\2\2\2\u017e\u017d\3\2\2\2\u017f\u0182"+
		"\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0080\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0183\u0184\t\2\2\2\u0184\u0082\3\2\2\2\u0185\u0186\t\3"+
		"\2\2\u0186\u0084\3\2\2\2\u0187\u018a\5\u0087D\2\u0188\u018a\5\u008fH\2"+
		"\u0189\u0187\3\2\2\2\u0189\u0188\3\2\2\2\u018a\u0086\3\2\2\2\u018b\u018f"+
		"\5\u0089E\2\u018c\u018e\5\u0083B\2\u018d\u018c\3\2\2\2\u018e\u0191\3\2"+
		"\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0088\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\u0192\u0193\t\4\2\2\u0193\u008a\3\2\2\2\u0194\u0195\t\5"+
		"\2\2\u0195\u008c\3\2\2\2\u0196\u0198\5\u0083B\2\u0197\u0196\3\2\2\2\u0198"+
		"\u0199\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u008e\3\2"+
		"\2\2\u019b\u019c\7)\2\2\u019c\u019d\5\u0091I\2\u019d\u019e\7)\2\2\u019e"+
		"\u0090\3\2\2\2\u019f\u01a1\5\u0093J\2\u01a0\u019f\3\2\2\2\u01a1\u01a2"+
		"\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u0092\3\2\2\2\u01a4"+
		"\u01a7\n\6\2\2\u01a5\u01a7\5\u0095K\2\u01a6\u01a4\3\2\2\2\u01a6\u01a5"+
		"\3\2\2\2\u01a7\u0094\3\2\2\2\u01a8\u01a9\5\u0097L\2\u01a9\u0096\3\2\2"+
		"\2\u01aa\u01ab\7^\2\2\u01ab\u01ac\t\7\2\2\u01ac\u0098\3\2\2\2\u01ad\u01af"+
		"\7$\2\2\u01ae\u01b0\5\u009bN\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2"+
		"\u01b0\u01b1\3\2\2\2\u01b1\u01b2\7$\2\2\u01b2\u009a\3\2\2\2\u01b3\u01b5"+
		"\5\u009dO\2\u01b4\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b4\3\2\2"+
		"\2\u01b6\u01b7\3\2\2\2\u01b7\u009c\3\2\2\2\u01b8\u01c0\n\b\2\2\u01b9\u01c0"+
		"\5\u0095K\2\u01ba\u01bb\7^\2\2\u01bb\u01c0\7\f\2\2\u01bc\u01bd\7^\2\2"+
		"\u01bd\u01be\7\17\2\2\u01be\u01c0\7\f\2\2\u01bf\u01b8\3\2\2\2\u01bf\u01b9"+
		"\3\2\2\2\u01bf\u01ba\3\2\2\2\u01bf\u01bc\3\2\2\2\u01c0\u009e\3\2\2\2\u01c1"+
		"\u01c3\t\t\2\2\u01c2\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c2\3\2"+
		"\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\bP\2\2\u01c7"+
		"\u00a0\3\2\2\2\u01c8\u01ca\7\17\2\2\u01c9\u01cb\7\f\2\2\u01ca\u01c9\3"+
		"\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ce\7\f\2\2\u01cd"+
		"\u01c8\3\2\2\2\u01cd\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\bQ"+
		"\2\2\u01d0\u00a2\3\2\2\2\u01d1\u01d2\7\61\2\2\u01d2\u01d3\7,\2\2\u01d3"+
		"\u01d7\3\2\2\2\u01d4\u01d6\13\2\2\2\u01d5\u01d4\3\2\2\2\u01d6\u01d9\3"+
		"\2\2\2\u01d7\u01d8\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9"+
		"\u01d7\3\2\2\2\u01da\u01db\7,\2\2\u01db\u01dc\7\61\2\2\u01dc\u01dd\3\2"+
		"\2\2\u01dd\u01de\bR\2\2\u01de\u00a4\3\2\2\2\u01df\u01e0\7\61\2\2\u01e0"+
		"\u01e1\7\61\2\2\u01e1\u01e5\3\2\2\2\u01e2\u01e4\n\n\2\2\u01e3\u01e2\3"+
		"\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e8\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01e9\bS\2\2\u01e9\u00a6\3\2"+
		"\2\2\22\2\u017e\u0180\u0189\u018f\u0199\u01a2\u01a6\u01af\u01b6\u01bf"+
		"\u01c4\u01ca\u01cd\u01d7\u01e5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}