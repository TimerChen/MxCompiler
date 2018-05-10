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
		"XorAssign", "OrAssign", "Equal", "NotEqual", "Dot", "Identifier", "FirstNondigit", 
		"Nondigit", "Digit", "Const", "BoolConst", "IntConst", "NonzeroDigit", 
		"ZeroDigit", "Sign", "DigitSequence", "CharacterConstant", "CCharSequence", 
		"CChar", "EscapeSequence", "SimpleEscapeSequence", "StringLiteral", "SCharSequence", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2G\u01ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+"+
		"\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67"+
		"\3\67\38\38\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3"+
		"?\3?\3?\7?\u0177\n?\f?\16?\u017a\13?\3@\3@\3A\3A\3B\3B\3C\3C\3C\5C\u0185"+
		"\nC\3D\3D\5D\u0189\nD\3E\3E\7E\u018d\nE\fE\16E\u0190\13E\3E\5E\u0193\n"+
		"E\3F\3F\3G\3G\3H\3H\3I\6I\u019c\nI\rI\16I\u019d\3J\3J\3J\3J\3K\6K\u01a5"+
		"\nK\rK\16K\u01a6\3L\3L\5L\u01ab\nL\3M\3M\3N\3N\3N\3O\3O\5O\u01b4\nO\3"+
		"O\3O\3P\6P\u01b9\nP\rP\16P\u01ba\3Q\3Q\3Q\3Q\3Q\3Q\3Q\5Q\u01c4\nQ\3R\6"+
		"R\u01c7\nR\rR\16R\u01c8\3R\3R\3S\3S\5S\u01cf\nS\3S\5S\u01d2\nS\3S\3S\3"+
		"T\3T\3T\3T\7T\u01da\nT\fT\16T\u01dd\13T\3T\3T\3T\3T\3T\3U\3U\3U\3U\7U"+
		"\u01e8\nU\fU\16U\u01eb\13U\3U\3U\3\u01db\2V\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177\2\u0081"+
		"\2\u0083\2\u0085A\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091B\u0093"+
		"\2\u0095\2\u0097\2\u0099\2\u009b\2\u009dC\u009f\2\u00a1\2\u00a3D\u00a5"+
		"E\u00a7F\u00a9G\3\2\r\4\2C\\c|\5\2C\\aac|\3\2\62;\3\2\63;\3\2\62\62\4"+
		"\2--//\6\2\f\f\17\17))^^\f\2$$))AA^^cdhhppttvvxx\6\2\f\f\17\17$$^^\4\2"+
		"\13\13\"\"\4\2\f\f\17\17\2\u01f2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u"+
		"\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\u0085\3\2\2\2\2"+
		"\u0091\3\2\2\2\2\u009d\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7"+
		"\3\2\2\2\2\u00a9\3\2\2\2\3\u00ab\3\2\2\2\5\u00b0\3\2\2\2\7\u00b4\3\2\2"+
		"\2\t\u00b9\3\2\2\2\13\u00c0\3\2\2\2\r\u00c6\3\2\2\2\17\u00cf\3\2\2\2\21"+
		"\u00d4\3\2\2\2\23\u00d8\3\2\2\2\25\u00db\3\2\2\2\27\u00df\3\2\2\2\31\u00e6"+
		"\3\2\2\2\33\u00eb\3\2\2\2\35\u00f1\3\2\2\2\37\u00f7\3\2\2\2!\u00fc\3\2"+
		"\2\2#\u0102\3\2\2\2%\u0104\3\2\2\2\'\u0106\3\2\2\2)\u0108\3\2\2\2+\u010a"+
		"\3\2\2\2-\u010c\3\2\2\2/\u010e\3\2\2\2\61\u0110\3\2\2\2\63\u0113\3\2\2"+
		"\2\65\u0115\3\2\2\2\67\u0118\3\2\2\29\u011b\3\2\2\2;\u011e\3\2\2\2=\u0120"+
		"\3\2\2\2?\u0123\3\2\2\2A\u0125\3\2\2\2C\u0128\3\2\2\2E\u012a\3\2\2\2G"+
		"\u012c\3\2\2\2I\u012e\3\2\2\2K\u0130\3\2\2\2M\u0132\3\2\2\2O\u0135\3\2"+
		"\2\2Q\u0138\3\2\2\2S\u013a\3\2\2\2U\u013c\3\2\2\2W\u013e\3\2\2\2Y\u0140"+
		"\3\2\2\2[\u0142\3\2\2\2]\u0145\3\2\2\2_\u0147\3\2\2\2a\u0149\3\2\2\2c"+
		"\u014b\3\2\2\2e\u014e\3\2\2\2g\u0151\3\2\2\2i\u0154\3\2\2\2k\u0157\3\2"+
		"\2\2m\u015a\3\2\2\2o\u015e\3\2\2\2q\u0162\3\2\2\2s\u0165\3\2\2\2u\u0168"+
		"\3\2\2\2w\u016b\3\2\2\2y\u016e\3\2\2\2{\u0171\3\2\2\2}\u0173\3\2\2\2\177"+
		"\u017b\3\2\2\2\u0081\u017d\3\2\2\2\u0083\u017f\3\2\2\2\u0085\u0184\3\2"+
		"\2\2\u0087\u0188\3\2\2\2\u0089\u0192\3\2\2\2\u008b\u0194\3\2\2\2\u008d"+
		"\u0196\3\2\2\2\u008f\u0198\3\2\2\2\u0091\u019b\3\2\2\2\u0093\u019f\3\2"+
		"\2\2\u0095\u01a4\3\2\2\2\u0097\u01aa\3\2\2\2\u0099\u01ac\3\2\2\2\u009b"+
		"\u01ae\3\2\2\2\u009d\u01b1\3\2\2\2\u009f\u01b8\3\2\2\2\u00a1\u01c3\3\2"+
		"\2\2\u00a3\u01c6\3\2\2\2\u00a5\u01d1\3\2\2\2\u00a7\u01d5\3\2\2\2\u00a9"+
		"\u01e3\3\2\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7k\2"+
		"\2\u00ae\u00af\7u\2\2\u00af\4\3\2\2\2\u00b0\u00b1\7p\2\2\u00b1\u00b2\7"+
		"g\2\2\u00b2\u00b3\7y\2\2\u00b3\6\3\2\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6"+
		"\7q\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7n\2\2\u00b8\b\3\2\2\2\u00b9\u00ba"+
		"\7u\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7k\2\2\u00bd"+
		"\u00be\7p\2\2\u00be\u00bf\7i\2\2\u00bf\n\3\2\2\2\u00c0\u00c1\7d\2\2\u00c1"+
		"\u00c2\7t\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7m\2\2"+
		"\u00c5\f\3\2\2\2\u00c6\u00c7\7e\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7p"+
		"\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd"+
		"\7w\2\2\u00cd\u00ce\7g\2\2\u00ce\16\3\2\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d1"+
		"\7n\2\2\u00d1\u00d2\7u\2\2\u00d2\u00d3\7g\2\2\u00d3\20\3\2\2\2\u00d4\u00d5"+
		"\7h\2\2\u00d5\u00d6\7q\2\2\u00d6\u00d7\7t\2\2\u00d7\22\3\2\2\2\u00d8\u00d9"+
		"\7k\2\2\u00d9\u00da\7h\2\2\u00da\24\3\2\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd"+
		"\7p\2\2\u00dd\u00de\7v\2\2\u00de\26\3\2\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1"+
		"\7g\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7w\2\2\u00e3\u00e4\7t\2\2\u00e4"+
		"\u00e5\7p\2\2\u00e5\30\3\2\2\2\u00e6\u00e7\7x\2\2\u00e7\u00e8\7q\2\2\u00e8"+
		"\u00e9\7k\2\2\u00e9\u00ea\7f\2\2\u00ea\32\3\2\2\2\u00eb\u00ec\7y\2\2\u00ec"+
		"\u00ed\7j\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7n\2\2\u00ef\u00f0\7g\2\2"+
		"\u00f0\34\3\2\2\2\u00f1\u00f2\7e\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7"+
		"c\2\2\u00f4\u00f5\7u\2\2\u00f5\u00f6\7u\2\2\u00f6\36\3\2\2\2\u00f7\u00f8"+
		"\7v\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7w\2\2\u00fa\u00fb\7g\2\2\u00fb"+
		" \3\2\2\2\u00fc\u00fd\7h\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7n\2\2\u00ff"+
		"\u0100\7u\2\2\u0100\u0101\7g\2\2\u0101\"\3\2\2\2\u0102\u0103\7*\2\2\u0103"+
		"$\3\2\2\2\u0104\u0105\7+\2\2\u0105&\3\2\2\2\u0106\u0107\7]\2\2\u0107("+
		"\3\2\2\2\u0108\u0109\7_\2\2\u0109*\3\2\2\2\u010a\u010b\7}\2\2\u010b,\3"+
		"\2\2\2\u010c\u010d\7\177\2\2\u010d.\3\2\2\2\u010e\u010f\7>\2\2\u010f\60"+
		"\3\2\2\2\u0110\u0111\7>\2\2\u0111\u0112\7?\2\2\u0112\62\3\2\2\2\u0113"+
		"\u0114\7@\2\2\u0114\64\3\2\2\2\u0115\u0116\7@\2\2\u0116\u0117\7?\2\2\u0117"+
		"\66\3\2\2\2\u0118\u0119\7>\2\2\u0119\u011a\7>\2\2\u011a8\3\2\2\2\u011b"+
		"\u011c\7@\2\2\u011c\u011d\7@\2\2\u011d:\3\2\2\2\u011e\u011f\7-\2\2\u011f"+
		"<\3\2\2\2\u0120\u0121\7-\2\2\u0121\u0122\7-\2\2\u0122>\3\2\2\2\u0123\u0124"+
		"\7/\2\2\u0124@\3\2\2\2\u0125\u0126\7/\2\2\u0126\u0127\7/\2\2\u0127B\3"+
		"\2\2\2\u0128\u0129\7,\2\2\u0129D\3\2\2\2\u012a\u012b\7\61\2\2\u012bF\3"+
		"\2\2\2\u012c\u012d\7\'\2\2\u012dH\3\2\2\2\u012e\u012f\7(\2\2\u012fJ\3"+
		"\2\2\2\u0130\u0131\7~\2\2\u0131L\3\2\2\2\u0132\u0133\7(\2\2\u0133\u0134"+
		"\7(\2\2\u0134N\3\2\2\2\u0135\u0136\7~\2\2\u0136\u0137\7~\2\2\u0137P\3"+
		"\2\2\2\u0138\u0139\7`\2\2\u0139R\3\2\2\2\u013a\u013b\7#\2\2\u013bT\3\2"+
		"\2\2\u013c\u013d\7\u0080\2\2\u013dV\3\2\2\2\u013e\u013f\7A\2\2\u013fX"+
		"\3\2\2\2\u0140\u0141\7<\2\2\u0141Z\3\2\2\2\u0142\u0143\7<\2\2\u0143\u0144"+
		"\7<\2\2\u0144\\\3\2\2\2\u0145\u0146\7=\2\2\u0146^\3\2\2\2\u0147\u0148"+
		"\7.\2\2\u0148`\3\2\2\2\u0149\u014a\7?\2\2\u014ab\3\2\2\2\u014b\u014c\7"+
		",\2\2\u014c\u014d\7?\2\2\u014dd\3\2\2\2\u014e\u014f\7\61\2\2\u014f\u0150"+
		"\7?\2\2\u0150f\3\2\2\2\u0151\u0152\7\'\2\2\u0152\u0153\7?\2\2\u0153h\3"+
		"\2\2\2\u0154\u0155\7-\2\2\u0155\u0156\7?\2\2\u0156j\3\2\2\2\u0157\u0158"+
		"\7/\2\2\u0158\u0159\7?\2\2\u0159l\3\2\2\2\u015a\u015b\7>\2\2\u015b\u015c"+
		"\7>\2\2\u015c\u015d\7?\2\2\u015dn\3\2\2\2\u015e\u015f\7@\2\2\u015f\u0160"+
		"\7@\2\2\u0160\u0161\7?\2\2\u0161p\3\2\2\2\u0162\u0163\7(\2\2\u0163\u0164"+
		"\7?\2\2\u0164r\3\2\2\2\u0165\u0166\7`\2\2\u0166\u0167\7?\2\2\u0167t\3"+
		"\2\2\2\u0168\u0169\7~\2\2\u0169\u016a\7?\2\2\u016av\3\2\2\2\u016b\u016c"+
		"\7?\2\2\u016c\u016d\7?\2\2\u016dx\3\2\2\2\u016e\u016f\7#\2\2\u016f\u0170"+
		"\7?\2\2\u0170z\3\2\2\2\u0171\u0172\7\60\2\2\u0172|\3\2\2\2\u0173\u0178"+
		"\5\177@\2\u0174\u0177\5\u0083B\2\u0175\u0177\5\u0081A\2\u0176\u0174\3"+
		"\2\2\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179~\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017c\t\2\2\2"+
		"\u017c\u0080\3\2\2\2\u017d\u017e\t\3\2\2\u017e\u0082\3\2\2\2\u017f\u0180"+
		"\t\4\2\2\u0180\u0084\3\2\2\2\u0181\u0185\5\u0087D\2\u0182\u0185\5\u0089"+
		"E\2\u0183\u0185\5\u0093J\2\u0184\u0181\3\2\2\2\u0184\u0182\3\2\2\2\u0184"+
		"\u0183\3\2\2\2\u0185\u0086\3\2\2\2\u0186\u0189\5\37\20\2\u0187\u0189\5"+
		"!\21\2\u0188\u0186\3\2\2\2\u0188\u0187\3\2\2\2\u0189\u0088\3\2\2\2\u018a"+
		"\u018e\5\u008bF\2\u018b\u018d\5\u0083B\2\u018c\u018b\3\2\2\2\u018d\u0190"+
		"\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0193\3\2\2\2\u0190"+
		"\u018e\3\2\2\2\u0191\u0193\5\u008dG\2\u0192\u018a\3\2\2\2\u0192\u0191"+
		"\3\2\2\2\u0193\u008a\3\2\2\2\u0194\u0195\t\5\2\2\u0195\u008c\3\2\2\2\u0196"+
		"\u0197\t\6\2\2\u0197\u008e\3\2\2\2\u0198\u0199\t\7\2\2\u0199\u0090\3\2"+
		"\2\2\u019a\u019c\5\u0083B\2\u019b\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d"+
		"\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u0092\3\2\2\2\u019f\u01a0\7)"+
		"\2\2\u01a0\u01a1\5\u0095K\2\u01a1\u01a2\7)\2\2\u01a2\u0094\3\2\2\2\u01a3"+
		"\u01a5\5\u0097L\2\u01a4\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a4"+
		"\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u0096\3\2\2\2\u01a8\u01ab\n\b\2\2\u01a9"+
		"\u01ab\5\u0099M\2\u01aa\u01a8\3\2\2\2\u01aa\u01a9\3\2\2\2\u01ab\u0098"+
		"\3\2\2\2\u01ac\u01ad\5\u009bN\2\u01ad\u009a\3\2\2\2\u01ae\u01af\7^\2\2"+
		"\u01af\u01b0\t\t\2\2\u01b0\u009c\3\2\2\2\u01b1\u01b3\7$\2\2\u01b2\u01b4"+
		"\5\u009fP\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\3\2\2"+
		"\2\u01b5\u01b6\7$\2\2\u01b6\u009e\3\2\2\2\u01b7\u01b9\5\u00a1Q\2\u01b8"+
		"\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2"+
		"\2\2\u01bb\u00a0\3\2\2\2\u01bc\u01c4\n\n\2\2\u01bd\u01c4\5\u0099M\2\u01be"+
		"\u01bf\7^\2\2\u01bf\u01c4\7\f\2\2\u01c0\u01c1\7^\2\2\u01c1\u01c2\7\17"+
		"\2\2\u01c2\u01c4\7\f\2\2\u01c3\u01bc\3\2\2\2\u01c3\u01bd\3\2\2\2\u01c3"+
		"\u01be\3\2\2\2\u01c3\u01c0\3\2\2\2\u01c4\u00a2\3\2\2\2\u01c5\u01c7\t\13"+
		"\2\2\u01c6\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\bR\2\2\u01cb\u00a4\3\2"+
		"\2\2\u01cc\u01ce\7\17\2\2\u01cd\u01cf\7\f\2\2\u01ce\u01cd\3\2\2\2\u01ce"+
		"\u01cf\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01d2\7\f\2\2\u01d1\u01cc\3\2"+
		"\2\2\u01d1\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d4\bS\2\2\u01d4"+
		"\u00a6\3\2\2\2\u01d5\u01d6\7\61\2\2\u01d6\u01d7\7,\2\2\u01d7\u01db\3\2"+
		"\2\2\u01d8\u01da\13\2\2\2\u01d9\u01d8\3\2\2\2\u01da\u01dd\3\2\2\2\u01db"+
		"\u01dc\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01de\3\2\2\2\u01dd\u01db\3\2"+
		"\2\2\u01de\u01df\7,\2\2\u01df\u01e0\7\61\2\2\u01e0\u01e1\3\2\2\2\u01e1"+
		"\u01e2\bT\2\2\u01e2\u00a8\3\2\2\2\u01e3\u01e4\7\61\2\2\u01e4\u01e5\7\61"+
		"\2\2\u01e5\u01e9\3\2\2\2\u01e6\u01e8\n\f\2\2\u01e7\u01e6\3\2\2\2\u01e8"+
		"\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec\3\2"+
		"\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01ed\bU\2\2\u01ed\u00aa\3\2\2\2\24\2\u0176"+
		"\u0178\u0184\u0188\u018e\u0192\u019d\u01a6\u01aa\u01b3\u01ba\u01c3\u01c8"+
		"\u01ce\u01d1\u01db\u01e9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}