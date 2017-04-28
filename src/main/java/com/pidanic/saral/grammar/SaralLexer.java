// Generated from Saral.g4 by ANTLR 4.5.3
package com.pidanic.saral.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SaralLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INDENT=2, DEDENT=3, TYPE=4, FUNCTION=5, PROC_CALL=6, FUNC_CALL=7, 
		LPAR=8, RPAR=9, INT_T=10, STRING_T=11, VARIABLE=12, PRINT=13, EQUALS=14, 
		RET=15, NUMBER=16, STRING=17, ID=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "INDENT", "DEDENT", "TYPE", "FUNCTION", "PROC_CALL", "FUNC_CALL", 
		"LPAR", "RPAR", "INT_T", "STRING_T", "VARIABLE", "PRINT", "EQUALS", "RET", 
		"NUMBER", "STRING", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'{'", "'}'", null, "'bar'", "'paľ do baru'", "'vrac z baru'", 
		"'('", "')'", "'neskutočné numeralio'", "'slovo'", "'meňak'", "'ciskaj'", 
		"'='", "'vrac'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "INDENT", "DEDENT", "TYPE", "FUNCTION", "PROC_CALL", "FUNC_CALL", 
		"LPAR", "RPAR", "INT_T", "STRING_T", "VARIABLE", "PRINT", "EQUALS", "RET", 
		"NUMBER", "STRING", "ID", "WS"
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


	public SaralLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Saral.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u009c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5\62\n\5\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\6\21\u0084\n\21\r\21\16\21\u0085\3\22\3\22\7\22\u008a\n\22\f\22\16"+
		"\22\u008d\13\22\3\22\3\22\3\23\6\23\u0092\n\23\r\23\16\23\u0093\3\24\6"+
		"\24\u0097\n\24\r\24\16\24\u0098\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		"\3\2\5\3\2\62;\31\2\62;C\\c|\u00c3\u00c3\u00c6\u00c6\u00cb\u00cb\u00cf"+
		"\u00cf\u00d5\u00d6\u00dc\u00dc\u00df\u00df\u00e3\u00e3\u00e6\u00e6\u00eb"+
		"\u00eb\u00ef\u00ef\u00f5\u00f6\u00fc\u00fc\u00ff\u00ff\u010e\u0111\u013b"+
		"\u013c\u013f\u0140\u0162\u0163\u0166\u0167\u017f\u0180\5\2\13\f\17\17"+
		"\"\"\u00a0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7-\3\2\2\2"+
		"\t\61\3\2\2\2\13\63\3\2\2\2\r\67\3\2\2\2\17C\3\2\2\2\21O\3\2\2\2\23Q\3"+
		"\2\2\2\25S\3\2\2\2\27h\3\2\2\2\31n\3\2\2\2\33t\3\2\2\2\35{\3\2\2\2\37"+
		"}\3\2\2\2!\u0083\3\2\2\2#\u0087\3\2\2\2%\u0091\3\2\2\2\'\u0096\3\2\2\2"+
		")*\7.\2\2*\4\3\2\2\2+,\7}\2\2,\6\3\2\2\2-.\7\177\2\2.\b\3\2\2\2/\62\5"+
		"\27\f\2\60\62\5\25\13\2\61/\3\2\2\2\61\60\3\2\2\2\62\n\3\2\2\2\63\64\7"+
		"d\2\2\64\65\7c\2\2\65\66\7t\2\2\66\f\3\2\2\2\678\7r\2\289\7c\2\29:\7\u0140"+
		"\2\2:;\7\"\2\2;<\7f\2\2<=\7q\2\2=>\7\"\2\2>?\7d\2\2?@\7c\2\2@A\7t\2\2"+
		"AB\7w\2\2B\16\3\2\2\2CD\7x\2\2DE\7t\2\2EF\7c\2\2FG\7e\2\2GH\7\"\2\2HI"+
		"\7|\2\2IJ\7\"\2\2JK\7d\2\2KL\7c\2\2LM\7t\2\2MN\7w\2\2N\20\3\2\2\2OP\7"+
		"*\2\2P\22\3\2\2\2QR\7+\2\2R\24\3\2\2\2ST\7p\2\2TU\7g\2\2UV\7u\2\2VW\7"+
		"m\2\2WX\7w\2\2XY\7v\2\2YZ\7q\2\2Z[\7\u010f\2\2[\\\7p\2\2\\]\7\u00eb\2"+
		"\2]^\7\"\2\2^_\7p\2\2_`\7w\2\2`a\7o\2\2ab\7g\2\2bc\7t\2\2cd\7c\2\2de\7"+
		"n\2\2ef\7k\2\2fg\7q\2\2g\26\3\2\2\2hi\7u\2\2ij\7n\2\2jk\7q\2\2kl\7x\2"+
		"\2lm\7q\2\2m\30\3\2\2\2no\7o\2\2op\7g\2\2pq\7\u014a\2\2qr\7c\2\2rs\7m"+
		"\2\2s\32\3\2\2\2tu\7e\2\2uv\7k\2\2vw\7u\2\2wx\7m\2\2xy\7c\2\2yz\7l\2\2"+
		"z\34\3\2\2\2{|\7?\2\2|\36\3\2\2\2}~\7x\2\2~\177\7t\2\2\177\u0080\7c\2"+
		"\2\u0080\u0081\7e\2\2\u0081 \3\2\2\2\u0082\u0084\t\2\2\2\u0083\u0082\3"+
		"\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\"\3\2\2\2\u0087\u008b\7$\2\2\u0088\u008a\13\2\2\2\u0089\u0088\3\2\2\2"+
		"\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7$\2\2\u008f$\3\2\2\2\u0090\u0092"+
		"\t\3\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094&\3\2\2\2\u0095\u0097\t\4\2\2\u0096\u0095\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u009b\b\24\2\2\u009b(\3\2\2\2\b\2\61\u0085\u008b\u0093"+
		"\u0098\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}