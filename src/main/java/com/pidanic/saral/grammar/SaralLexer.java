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
		T__0=1, INDENT=2, DEDENT=3, TYPE=4, FUNCTION=5, PROC_CALL=6, LPAR=7, RPAR=8, 
		INT_T=9, STRING_T=10, VARIABLE=11, PRINT=12, EQUALS=13, RET=14, NUMBER=15, 
		STRING=16, ID=17, WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "INDENT", "DEDENT", "TYPE", "FUNCTION", "PROC_CALL", "LPAR", "RPAR", 
		"INT_T", "STRING_T", "VARIABLE", "PRINT", "EQUALS", "RET", "NUMBER", "STRING", 
		"ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'{'", "'}'", null, "'bar'", "'paľ do baru'", "'('", "')'", 
		"'neskutočné numeralio'", "'slovo'", "'meňak'", "'ciskaj'", "'='", "'vrac'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "INDENT", "DEDENT", "TYPE", "FUNCTION", "PROC_CALL", "LPAR", 
		"RPAR", "INT_T", "STRING_T", "VARIABLE", "PRINT", "EQUALS", "RET", "NUMBER", 
		"STRING", "ID", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u008e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5\60\n\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\6\20"+
		"v\n\20\r\20\16\20w\3\21\3\21\7\21|\n\21\f\21\16\21\177\13\21\3\21\3\21"+
		"\3\22\6\22\u0084\n\22\r\22\16\22\u0085\3\23\6\23\u0089\n\23\r\23\16\23"+
		"\u008a\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\5\3\2\62;\31\2\62;C\\c|"+
		"\u00c3\u00c3\u00c6\u00c6\u00cb\u00cb\u00cf\u00cf\u00d5\u00d6\u00dc\u00dc"+
		"\u00df\u00df\u00e3\u00e3\u00e6\u00e6\u00eb\u00eb\u00ef\u00ef\u00f5\u00f6"+
		"\u00fc\u00fc\u00ff\u00ff\u010e\u0111\u013b\u013c\u013f\u0140\u0162\u0163"+
		"\u0166\u0167\u017f\u0180\5\2\13\f\17\17\"\"\u0092\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3"+
		"\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t/\3\2\2\2\13\61\3\2\2\2\r\65\3\2\2\2\17"+
		"A\3\2\2\2\21C\3\2\2\2\23E\3\2\2\2\25Z\3\2\2\2\27`\3\2\2\2\31f\3\2\2\2"+
		"\33m\3\2\2\2\35o\3\2\2\2\37u\3\2\2\2!y\3\2\2\2#\u0083\3\2\2\2%\u0088\3"+
		"\2\2\2\'(\7.\2\2(\4\3\2\2\2)*\7}\2\2*\6\3\2\2\2+,\7\177\2\2,\b\3\2\2\2"+
		"-\60\5\25\13\2.\60\5\23\n\2/-\3\2\2\2/.\3\2\2\2\60\n\3\2\2\2\61\62\7d"+
		"\2\2\62\63\7c\2\2\63\64\7t\2\2\64\f\3\2\2\2\65\66\7r\2\2\66\67\7c\2\2"+
		"\678\7\u0140\2\289\7\"\2\29:\7f\2\2:;\7q\2\2;<\7\"\2\2<=\7d\2\2=>\7c\2"+
		"\2>?\7t\2\2?@\7w\2\2@\16\3\2\2\2AB\7*\2\2B\20\3\2\2\2CD\7+\2\2D\22\3\2"+
		"\2\2EF\7p\2\2FG\7g\2\2GH\7u\2\2HI\7m\2\2IJ\7w\2\2JK\7v\2\2KL\7q\2\2LM"+
		"\7\u010f\2\2MN\7p\2\2NO\7\u00eb\2\2OP\7\"\2\2PQ\7p\2\2QR\7w\2\2RS\7o\2"+
		"\2ST\7g\2\2TU\7t\2\2UV\7c\2\2VW\7n\2\2WX\7k\2\2XY\7q\2\2Y\24\3\2\2\2Z"+
		"[\7u\2\2[\\\7n\2\2\\]\7q\2\2]^\7x\2\2^_\7q\2\2_\26\3\2\2\2`a\7o\2\2ab"+
		"\7g\2\2bc\7\u014a\2\2cd\7c\2\2de\7m\2\2e\30\3\2\2\2fg\7e\2\2gh\7k\2\2"+
		"hi\7u\2\2ij\7m\2\2jk\7c\2\2kl\7l\2\2l\32\3\2\2\2mn\7?\2\2n\34\3\2\2\2"+
		"op\7x\2\2pq\7t\2\2qr\7c\2\2rs\7e\2\2s\36\3\2\2\2tv\t\2\2\2ut\3\2\2\2v"+
		"w\3\2\2\2wu\3\2\2\2wx\3\2\2\2x \3\2\2\2y}\7$\2\2z|\13\2\2\2{z\3\2\2\2"+
		"|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081"+
		"\7$\2\2\u0081\"\3\2\2\2\u0082\u0084\t\3\2\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086$\3\2\2\2"+
		"\u0087\u0089\t\4\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\b\23\2\2"+
		"\u008d&\3\2\2\2\b\2/w}\u0085\u008a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}