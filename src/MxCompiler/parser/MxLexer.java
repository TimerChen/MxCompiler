// Generated from /home/timemachine/Desktop/Code/MxCompiler/src/MxCompiler/parser/Mx.g4 by ANTLR 4.7
package MxCompiler.parser;
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
		Int=10, Return=11, Void=12, While=13, Class=14, True=15, False=16, LeftParen=17, 
		RightParen=18, LeftBracket=19, RightBracket=20, LeftBrace=21, RightBrace=22, 
		Less=23, LessEqual=24, Greater=25, GreaterEqual=26, LeftShift=27, RightShift=28, 
		Plus=29, PlusPlus=30, Minus=31, MinusMinus=32, Star=33, Div=34, Mod=35, 
		And=36, Or=37, AndAnd=38, OrOr=39, Caret=40, Not=41, Tilde=42, Question=43, 
		Colon=44, ColonColon=45, Semi=46, Comma=47, Assign=48, StarAssign=49, 
		DivAssign=50, ModAssign=51, PlusAssign=52, MinusAssign=53, LeftShiftAssign=54, 
		RightShiftAssign=55, AndAssign=56, XorAssign=57, OrAssign=58, Equal=59, 
		NotEqual=60, Dot=61, Identifier=62, Const=63, DigitSequence=64, StringLiteral=65, 
		Whitespace=66, Newline=67, BlockComment=68, LineComment=69;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "Break", "Continue", "Else", "For", "If", 
		"Int", "Return", "Void", "While", "Class", "True", "False", "LeftParen", 
		"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
		"Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", "RightShift", 
		"Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", "Mod", "And", 
		"Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
		"ColonColon", "Semi", "Comma", "Assign", "StarAssign", "DivAssign", "ModAssign", 
		"PlusAssign", "MinusAssign", "LeftShiftAssign", "RightShiftAssign", "AndAssign", 
		"XorAssign", "OrAssign", "Equal", "NotEqual", "Dot", "Identifier", "Nondigit", 
		"Digit", "Const", "BoolConst", "IntConst", "NonzeroDigit", "ZeroDigit", 
		"Sign", "DigitSequence", "CharacterConstant", "CCharSequence", "CChar", 
		"EscapeSequence", "SimpleEscapeSequence", "StringLiteral", "SCharSequence", 
		"SChar", "Whitespace", "Newline", "BlockComment", "LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'this'", "'new'", "'bool'", "'string'", "'break'", "'continue'", 
		"'else'", "'for'", "'if'", "'int'", "'return'", "'void'", "'while'", "'class'", 
		"'true'", "'false'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", 
		"'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", "'*'", 
		"'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", "'?'", 
		"':'", "'::'", "';'", "','", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", 
		"'<<='", "'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "Break", "Continue", "Else", "For", "If", 
		"Int", "Return", "Void", "While", "Class", "True", "False", "LeftParen", 
		"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
		"Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", "RightShift", 
		"Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", "Mod", "And", 
		"Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
		"ColonColon", "Semi", "Comma", "Assign", "StarAssign", "DivAssign", "ModAssign", 
		"PlusAssign", "MinusAssign", "LeftShiftAssign", "RightShiftAssign", "AndAssign", 
		"XorAssign", "OrAssign", "Equal", "NotEqual", "Dot", "Identifier", "Const", 
		"DigitSequence", "StringLiteral", "Whitespace", "Newline", "BlockComment", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2G\u01ea\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3"+
		",\3,\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67"+
		"\38\38\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3?\3?"+
		"\3?\7?\u0175\n?\f?\16?\u0178\13?\3@\3@\3A\3A\3B\3B\3B\5B\u0181\nB\3C\3"+
		"C\5C\u0185\nC\3D\3D\7D\u0189\nD\fD\16D\u018c\13D\3D\5D\u018f\nD\3E\3E"+
		"\3F\3F\3G\3G\3H\6H\u0198\nH\rH\16H\u0199\3I\3I\3I\3I\3J\6J\u01a1\nJ\r"+
		"J\16J\u01a2\3K\3K\5K\u01a7\nK\3L\3L\3M\3M\3M\3N\3N\5N\u01b0\nN\3N\3N\3"+
		"O\6O\u01b5\nO\rO\16O\u01b6\3P\3P\3P\3P\3P\3P\3P\5P\u01c0\nP\3Q\6Q\u01c3"+
		"\nQ\rQ\16Q\u01c4\3Q\3Q\3R\3R\5R\u01cb\nR\3R\5R\u01ce\nR\3R\3R\3S\3S\3"+
		"S\3S\7S\u01d6\nS\fS\16S\u01d9\13S\3S\3S\3S\3S\3S\3T\3T\3T\3T\7T\u01e4"+
		"\nT\fT\16T\u01e7\13T\3T\3T\3\u01d7\2U\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177\2\u0081\2\u0083"+
		"A\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008fB\u0091\2\u0093\2\u0095"+
		"\2\u0097\2\u0099\2\u009bC\u009d\2\u009f\2\u00a1D\u00a3E\u00a5F\u00a7G"+
		"\3\2\f\5\2C\\aac|\3\2\62;\3\2\63;\3\2\62\62\4\2--//\6\2\f\f\17\17))^^"+
		"\f\2$$))AA^^cdhhppttvvxx\6\2\f\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f\17\17"+
		"\2\u01ef\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y"+
		"\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\u0083\3\2\2\2\2\u008f\3\2\2\2\2\u009b"+
		"\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2"+
		"\2\3\u00a9\3\2\2\2\5\u00ae\3\2\2\2\7\u00b2\3\2\2\2\t\u00b7\3\2\2\2\13"+
		"\u00be\3\2\2\2\r\u00c4\3\2\2\2\17\u00cd\3\2\2\2\21\u00d2\3\2\2\2\23\u00d6"+
		"\3\2\2\2\25\u00d9\3\2\2\2\27\u00dd\3\2\2\2\31\u00e4\3\2\2\2\33\u00e9\3"+
		"\2\2\2\35\u00ef\3\2\2\2\37\u00f5\3\2\2\2!\u00fa\3\2\2\2#\u0100\3\2\2\2"+
		"%\u0102\3\2\2\2\'\u0104\3\2\2\2)\u0106\3\2\2\2+\u0108\3\2\2\2-\u010a\3"+
		"\2\2\2/\u010c\3\2\2\2\61\u010e\3\2\2\2\63\u0111\3\2\2\2\65\u0113\3\2\2"+
		"\2\67\u0116\3\2\2\29\u0119\3\2\2\2;\u011c\3\2\2\2=\u011e\3\2\2\2?\u0121"+
		"\3\2\2\2A\u0123\3\2\2\2C\u0126\3\2\2\2E\u0128\3\2\2\2G\u012a\3\2\2\2I"+
		"\u012c\3\2\2\2K\u012e\3\2\2\2M\u0130\3\2\2\2O\u0133\3\2\2\2Q\u0136\3\2"+
		"\2\2S\u0138\3\2\2\2U\u013a\3\2\2\2W\u013c\3\2\2\2Y\u013e\3\2\2\2[\u0140"+
		"\3\2\2\2]\u0143\3\2\2\2_\u0145\3\2\2\2a\u0147\3\2\2\2c\u0149\3\2\2\2e"+
		"\u014c\3\2\2\2g\u014f\3\2\2\2i\u0152\3\2\2\2k\u0155\3\2\2\2m\u0158\3\2"+
		"\2\2o\u015c\3\2\2\2q\u0160\3\2\2\2s\u0163\3\2\2\2u\u0166\3\2\2\2w\u0169"+
		"\3\2\2\2y\u016c\3\2\2\2{\u016f\3\2\2\2}\u0171\3\2\2\2\177\u0179\3\2\2"+
		"\2\u0081\u017b\3\2\2\2\u0083\u0180\3\2\2\2\u0085\u0184\3\2\2\2\u0087\u018e"+
		"\3\2\2\2\u0089\u0190\3\2\2\2\u008b\u0192\3\2\2\2\u008d\u0194\3\2\2\2\u008f"+
		"\u0197\3\2\2\2\u0091\u019b\3\2\2\2\u0093\u01a0\3\2\2\2\u0095\u01a6\3\2"+
		"\2\2\u0097\u01a8\3\2\2\2\u0099\u01aa\3\2\2\2\u009b\u01ad\3\2\2\2\u009d"+
		"\u01b4\3\2\2\2\u009f\u01bf\3\2\2\2\u00a1\u01c2\3\2\2\2\u00a3\u01cd\3\2"+
		"\2\2\u00a5\u01d1\3\2\2\2\u00a7\u01df\3\2\2\2\u00a9\u00aa\7v\2\2\u00aa"+
		"\u00ab\7j\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7u\2\2\u00ad\4\3\2\2\2\u00ae"+
		"\u00af\7p\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7y\2\2\u00b1\6\3\2\2\2\u00b2"+
		"\u00b3\7d\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7n\2\2"+
		"\u00b6\b\3\2\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7t"+
		"\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7i\2\2\u00bd\n"+
		"\3\2\2\2\u00be\u00bf\7d\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7g\2\2\u00c1"+
		"\u00c2\7c\2\2\u00c2\u00c3\7m\2\2\u00c3\f\3\2\2\2\u00c4\u00c5\7e\2\2\u00c5"+
		"\u00c6\7q\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7k\2\2"+
		"\u00c9\u00ca\7p\2\2\u00ca\u00cb\7w\2\2\u00cb\u00cc\7g\2\2\u00cc\16\3\2"+
		"\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1"+
		"\7g\2\2\u00d1\20\3\2\2\2\u00d2\u00d3\7h\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5"+
		"\7t\2\2\u00d5\22\3\2\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7h\2\2\u00d8\24"+
		"\3\2\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7p\2\2\u00db\u00dc\7v\2\2\u00dc"+
		"\26\3\2\2\2\u00dd\u00de\7t\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7v\2\2\u00e0"+
		"\u00e1\7w\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7p\2\2\u00e3\30\3\2\2\2\u00e4"+
		"\u00e5\7x\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7f\2\2"+
		"\u00e8\32\3\2\2\2\u00e9\u00ea\7y\2\2\u00ea\u00eb\7j\2\2\u00eb\u00ec\7"+
		"k\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee\7g\2\2\u00ee\34\3\2\2\2\u00ef\u00f0"+
		"\7e\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7u\2\2\u00f3"+
		"\u00f4\7u\2\2\u00f4\36\3\2\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7t\2\2\u00f7"+
		"\u00f8\7w\2\2\u00f8\u00f9\7g\2\2\u00f9 \3\2\2\2\u00fa\u00fb\7h\2\2\u00fb"+
		"\u00fc\7c\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7u\2\2\u00fe\u00ff\7g\2\2"+
		"\u00ff\"\3\2\2\2\u0100\u0101\7*\2\2\u0101$\3\2\2\2\u0102\u0103\7+\2\2"+
		"\u0103&\3\2\2\2\u0104\u0105\7]\2\2\u0105(\3\2\2\2\u0106\u0107\7_\2\2\u0107"+
		"*\3\2\2\2\u0108\u0109\7}\2\2\u0109,\3\2\2\2\u010a\u010b\7\177\2\2\u010b"+
		".\3\2\2\2\u010c\u010d\7>\2\2\u010d\60\3\2\2\2\u010e\u010f\7>\2\2\u010f"+
		"\u0110\7?\2\2\u0110\62\3\2\2\2\u0111\u0112\7@\2\2\u0112\64\3\2\2\2\u0113"+
		"\u0114\7@\2\2\u0114\u0115\7?\2\2\u0115\66\3\2\2\2\u0116\u0117\7>\2\2\u0117"+
		"\u0118\7>\2\2\u01188\3\2\2\2\u0119\u011a\7@\2\2\u011a\u011b\7@\2\2\u011b"+
		":\3\2\2\2\u011c\u011d\7-\2\2\u011d<\3\2\2\2\u011e\u011f\7-\2\2\u011f\u0120"+
		"\7-\2\2\u0120>\3\2\2\2\u0121\u0122\7/\2\2\u0122@\3\2\2\2\u0123\u0124\7"+
		"/\2\2\u0124\u0125\7/\2\2\u0125B\3\2\2\2\u0126\u0127\7,\2\2\u0127D\3\2"+
		"\2\2\u0128\u0129\7\61\2\2\u0129F\3\2\2\2\u012a\u012b\7\'\2\2\u012bH\3"+
		"\2\2\2\u012c\u012d\7(\2\2\u012dJ\3\2\2\2\u012e\u012f\7~\2\2\u012fL\3\2"+
		"\2\2\u0130\u0131\7(\2\2\u0131\u0132\7(\2\2\u0132N\3\2\2\2\u0133\u0134"+
		"\7~\2\2\u0134\u0135\7~\2\2\u0135P\3\2\2\2\u0136\u0137\7`\2\2\u0137R\3"+
		"\2\2\2\u0138\u0139\7#\2\2\u0139T\3\2\2\2\u013a\u013b\7\u0080\2\2\u013b"+
		"V\3\2\2\2\u013c\u013d\7A\2\2\u013dX\3\2\2\2\u013e\u013f\7<\2\2\u013fZ"+
		"\3\2\2\2\u0140\u0141\7<\2\2\u0141\u0142\7<\2\2\u0142\\\3\2\2\2\u0143\u0144"+
		"\7=\2\2\u0144^\3\2\2\2\u0145\u0146\7.\2\2\u0146`\3\2\2\2\u0147\u0148\7"+
		"?\2\2\u0148b\3\2\2\2\u0149\u014a\7,\2\2\u014a\u014b\7?\2\2\u014bd\3\2"+
		"\2\2\u014c\u014d\7\61\2\2\u014d\u014e\7?\2\2\u014ef\3\2\2\2\u014f\u0150"+
		"\7\'\2\2\u0150\u0151\7?\2\2\u0151h\3\2\2\2\u0152\u0153\7-\2\2\u0153\u0154"+
		"\7?\2\2\u0154j\3\2\2\2\u0155\u0156\7/\2\2\u0156\u0157\7?\2\2\u0157l\3"+
		"\2\2\2\u0158\u0159\7>\2\2\u0159\u015a\7>\2\2\u015a\u015b\7?\2\2\u015b"+
		"n\3\2\2\2\u015c\u015d\7@\2\2\u015d\u015e\7@\2\2\u015e\u015f\7?\2\2\u015f"+
		"p\3\2\2\2\u0160\u0161\7(\2\2\u0161\u0162\7?\2\2\u0162r\3\2\2\2\u0163\u0164"+
		"\7`\2\2\u0164\u0165\7?\2\2\u0165t\3\2\2\2\u0166\u0167\7~\2\2\u0167\u0168"+
		"\7?\2\2\u0168v\3\2\2\2\u0169\u016a\7?\2\2\u016a\u016b\7?\2\2\u016bx\3"+
		"\2\2\2\u016c\u016d\7#\2\2\u016d\u016e\7?\2\2\u016ez\3\2\2\2\u016f\u0170"+
		"\7\60\2\2\u0170|\3\2\2\2\u0171\u0176\5\177@\2\u0172\u0175\5\u0081A\2\u0173"+
		"\u0175\5\177@\2\u0174\u0172\3\2\2\2\u0174\u0173\3\2\2\2\u0175\u0178\3"+
		"\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177~\3\2\2\2\u0178\u0176"+
		"\3\2\2\2\u0179\u017a\t\2\2\2\u017a\u0080\3\2\2\2\u017b\u017c\t\3\2\2\u017c"+
		"\u0082\3\2\2\2\u017d\u0181\5\u0085C\2\u017e\u0181\5\u0087D\2\u017f\u0181"+
		"\5\u0091I\2\u0180\u017d\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u017f\3\2\2"+
		"\2\u0181\u0084\3\2\2\2\u0182\u0185\5\37\20\2\u0183\u0185\5!\21\2\u0184"+
		"\u0182\3\2\2\2\u0184\u0183\3\2\2\2\u0185\u0086\3\2\2\2\u0186\u018a\5\u0089"+
		"E\2\u0187\u0189\5\u0081A\2\u0188\u0187\3\2\2\2\u0189\u018c\3\2\2\2\u018a"+
		"\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018f\3\2\2\2\u018c\u018a\3\2"+
		"\2\2\u018d\u018f\5\u008bF\2\u018e\u0186\3\2\2\2\u018e\u018d\3\2\2\2\u018f"+
		"\u0088\3\2\2\2\u0190\u0191\t\4\2\2\u0191\u008a\3\2\2\2\u0192\u0193\t\5"+
		"\2\2\u0193\u008c\3\2\2\2\u0194\u0195\t\6\2\2\u0195\u008e\3\2\2\2\u0196"+
		"\u0198\5\u0081A\2\u0197\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u0197"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u0090\3\2\2\2\u019b\u019c\7)\2\2\u019c"+
		"\u019d\5\u0093J\2\u019d\u019e\7)\2\2\u019e\u0092\3\2\2\2\u019f\u01a1\5"+
		"\u0095K\2\u01a0\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a0\3\2\2\2"+
		"\u01a2\u01a3\3\2\2\2\u01a3\u0094\3\2\2\2\u01a4\u01a7\n\7\2\2\u01a5\u01a7"+
		"\5\u0097L\2\u01a6\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7\u0096\3\2\2"+
		"\2\u01a8\u01a9\5\u0099M\2\u01a9\u0098\3\2\2\2\u01aa\u01ab\7^\2\2\u01ab"+
		"\u01ac\t\b\2\2\u01ac\u009a\3\2\2\2\u01ad\u01af\7$\2\2\u01ae\u01b0\5\u009d"+
		"O\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1"+
		"\u01b2\7$\2\2\u01b2\u009c\3\2\2\2\u01b3\u01b5\5\u009fP\2\u01b4\u01b3\3"+
		"\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u009e\3\2\2\2\u01b8\u01c0\n\t\2\2\u01b9\u01c0\5\u0097L\2\u01ba\u01bb"+
		"\7^\2\2\u01bb\u01c0\7\f\2\2\u01bc\u01bd\7^\2\2\u01bd\u01be\7\17\2\2\u01be"+
		"\u01c0\7\f\2\2\u01bf\u01b8\3\2\2\2\u01bf\u01b9\3\2\2\2\u01bf\u01ba\3\2"+
		"\2\2\u01bf\u01bc\3\2\2\2\u01c0\u00a0\3\2\2\2\u01c1\u01c3\t\n\2\2\u01c2"+
		"\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2"+
		"\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\bQ\2\2\u01c7\u00a2\3\2\2\2\u01c8"+
		"\u01ca\7\17\2\2\u01c9\u01cb\7\f\2\2\u01ca\u01c9\3\2\2\2\u01ca\u01cb\3"+
		"\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ce\7\f\2\2\u01cd\u01c8\3\2\2\2\u01cd"+
		"\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\bR\2\2\u01d0\u00a4\3\2"+
		"\2\2\u01d1\u01d2\7\61\2\2\u01d2\u01d3\7,\2\2\u01d3\u01d7\3\2\2\2\u01d4"+
		"\u01d6\13\2\2\2\u01d5\u01d4\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d8\3"+
		"\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da"+
		"\u01db\7,\2\2\u01db\u01dc\7\61\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\bS"+
		"\2\2\u01de\u00a6\3\2\2\2\u01df\u01e0\7\61\2\2\u01e0\u01e1\7\61\2\2\u01e1"+
		"\u01e5\3\2\2\2\u01e2\u01e4\n\13\2\2\u01e3\u01e2\3\2\2\2\u01e4\u01e7\3"+
		"\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e8\3\2\2\2\u01e7"+
		"\u01e5\3\2\2\2\u01e8\u01e9\bT\2\2\u01e9\u00a8\3\2\2\2\24\2\u0174\u0176"+
		"\u0180\u0184\u018a\u018e\u0199\u01a2\u01a6\u01af\u01b6\u01bf\u01c4\u01ca"+
		"\u01cd\u01d7\u01e5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}