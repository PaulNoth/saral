// Generated from Enkel.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EnkelLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		VARIABLE=18, PRINT=19, EQUALS=20, NUMBER=21, STRING=22, ID=23, QUALIFIED_NAME=24, 
		WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"VARIABLE", "PRINT", "EQUALS", "NUMBER", "STRING", "ID", "QUALIFIED_NAME", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "'boolean'", "'['", "']'", "'string'", 
		"'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", 
		"'void'", "','", "'var'", "'print'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "VARIABLE", "PRINT", "EQUALS", "NUMBER", 
		"STRING", "ID", "QUALIFIED_NAME", "WS"
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


	public EnkelLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Enkel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00aa\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\6\26\u008b\n\26\r\26"+
		"\16\26\u008c\3\27\3\27\7\27\u0091\n\27\f\27\16\27\u0094\13\27\3\27\3\27"+
		"\3\30\6\30\u0099\n\30\r\30\16\30\u009a\3\31\3\31\3\31\6\31\u00a0\n\31"+
		"\r\31\16\31\u00a1\3\32\6\32\u00a5\n\32\r\32\16\32\u00a6\3\32\3\32\2\2"+
		"\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\5\3\2\62;\5"+
		"\2\62;C\\c|\5\2\13\f\17\17\"\"\u00ae\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3"+
		"\2\2\2\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\rE\3\2\2\2\17G\3"+
		"\2\2\2\21I\3\2\2\2\23P\3\2\2\2\25U\3\2\2\2\27Z\3\2\2\2\31`\3\2\2\2\33"+
		"d\3\2\2\2\35i\3\2\2\2\37o\3\2\2\2!v\3\2\2\2#{\3\2\2\2%}\3\2\2\2\'\u0081"+
		"\3\2\2\2)\u0087\3\2\2\2+\u008a\3\2\2\2-\u008e\3\2\2\2/\u0098\3\2\2\2\61"+
		"\u009c\3\2\2\2\63\u00a4\3\2\2\2\65\66\7}\2\2\66\4\3\2\2\2\678\7\177\2"+
		"\28\6\3\2\2\29:\7*\2\2:\b\3\2\2\2;<\7+\2\2<\n\3\2\2\2=>\7d\2\2>?\7q\2"+
		"\2?@\7q\2\2@A\7n\2\2AB\7g\2\2BC\7c\2\2CD\7p\2\2D\f\3\2\2\2EF\7]\2\2F\16"+
		"\3\2\2\2GH\7_\2\2H\20\3\2\2\2IJ\7u\2\2JK\7v\2\2KL\7t\2\2LM\7k\2\2MN\7"+
		"p\2\2NO\7i\2\2O\22\3\2\2\2PQ\7e\2\2QR\7j\2\2RS\7c\2\2ST\7t\2\2T\24\3\2"+
		"\2\2UV\7d\2\2VW\7{\2\2WX\7v\2\2XY\7g\2\2Y\26\3\2\2\2Z[\7u\2\2[\\\7j\2"+
		"\2\\]\7q\2\2]^\7t\2\2^_\7v\2\2_\30\3\2\2\2`a\7k\2\2ab\7p\2\2bc\7v\2\2"+
		"c\32\3\2\2\2de\7n\2\2ef\7q\2\2fg\7p\2\2gh\7i\2\2h\34\3\2\2\2ij\7h\2\2"+
		"jk\7n\2\2kl\7q\2\2lm\7c\2\2mn\7v\2\2n\36\3\2\2\2op\7f\2\2pq\7q\2\2qr\7"+
		"w\2\2rs\7d\2\2st\7n\2\2tu\7g\2\2u \3\2\2\2vw\7x\2\2wx\7q\2\2xy\7k\2\2"+
		"yz\7f\2\2z\"\3\2\2\2{|\7.\2\2|$\3\2\2\2}~\7x\2\2~\177\7c\2\2\177\u0080"+
		"\7t\2\2\u0080&\3\2\2\2\u0081\u0082\7r\2\2\u0082\u0083\7t\2\2\u0083\u0084"+
		"\7k\2\2\u0084\u0085\7p\2\2\u0085\u0086\7v\2\2\u0086(\3\2\2\2\u0087\u0088"+
		"\7?\2\2\u0088*\3\2\2\2\u0089\u008b\t\2\2\2\u008a\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d,\3\2\2\2\u008e"+
		"\u0092\7$\2\2\u008f\u0091\13\2\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u0096\7$\2\2\u0096.\3\2\2\2\u0097\u0099\t\3\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\60\3\2\2\2\u009c\u009f\5/\30\2\u009d\u009e\7\60\2\2\u009e\u00a0"+
		"\5/\30\2\u009f\u009d\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\62\3\2\2\2\u00a3\u00a5\t\4\2\2\u00a4\u00a3\3\2\2"+
		"\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00a9\b\32\2\2\u00a9\64\3\2\2\2\b\2\u008c\u0092\u009a\u00a1"+
		"\u00a6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}