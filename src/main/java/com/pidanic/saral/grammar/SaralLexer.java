package com.pidanic.saral.grammar;// Generated from Saral.g4 by ANTLR 4.5.3
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
		T__0=1, INDENT=2, DEDENT=3, TYPE=4, FUNCTION=5, LPAR=6, RPAR=7, INT_T=8, 
		STRING_T=9, VARIABLE=10, PRINT=11, EQUALS=12, NUMBER=13, STRING=14, ID=15, 
		WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "INDENT", "DEDENT", "TYPE", "FUNCTION", "LPAR", "RPAR", "INT_T", 
		"STRING_T", "VARIABLE", "PRINT", "EQUALS", "NUMBER", "STRING", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'{'", "'}'", null, "'bar'", "'('", "')'", "'neskutočné numeralio'", 
		"'slovo'", "'meňak'", "'ciskaj'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "INDENT", "DEDENT", "TYPE", "FUNCTION", "LPAR", "RPAR", "INT_T", 
		"STRING_T", "VARIABLE", "PRINT", "EQUALS", "NUMBER", "STRING", "ID", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\5\5,\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\6\16a\n\16\r\16\16\16b\3\17\3\17\7\17"+
		"g\n\17\f\17\16\17j\13\17\3\17\3\17\3\20\6\20o\n\20\r\20\16\20p\3\21\6"+
		"\21t\n\21\r\21\16\21u\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22\3\2\5\3\2\62;\31\2\62;"+
		"C\\c|\u00c3\u00c3\u00c6\u00c6\u00cb\u00cb\u00cf\u00cf\u00d5\u00d6\u00dc"+
		"\u00dc\u00df\u00df\u00e3\u00e3\u00e6\u00e6\u00eb\u00eb\u00ef\u00ef\u00f5"+
		"\u00f6\u00fc\u00fc\u00ff\u00ff\u010e\u0111\u013b\u013c\u013f\u0140\u0162"+
		"\u0163\u0166\u0167\u017f\u0180\5\2\13\f\17\17\"\"}\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7\'\3"+
		"\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21\65\3\2\2\2"+
		"\23J\3\2\2\2\25P\3\2\2\2\27V\3\2\2\2\31]\3\2\2\2\33`\3\2\2\2\35d\3\2\2"+
		"\2\37n\3\2\2\2!s\3\2\2\2#$\7.\2\2$\4\3\2\2\2%&\7}\2\2&\6\3\2\2\2\'(\7"+
		"\177\2\2(\b\3\2\2\2),\5\23\n\2*,\5\21\t\2+)\3\2\2\2+*\3\2\2\2,\n\3\2\2"+
		"\2-.\7d\2\2./\7c\2\2/\60\7t\2\2\60\f\3\2\2\2\61\62\7*\2\2\62\16\3\2\2"+
		"\2\63\64\7+\2\2\64\20\3\2\2\2\65\66\7p\2\2\66\67\7g\2\2\678\7u\2\289\7"+
		"m\2\29:\7w\2\2:;\7v\2\2;<\7q\2\2<=\7\u010f\2\2=>\7p\2\2>?\7\u00eb\2\2"+
		"?@\7\"\2\2@A\7p\2\2AB\7w\2\2BC\7o\2\2CD\7g\2\2DE\7t\2\2EF\7c\2\2FG\7n"+
		"\2\2GH\7k\2\2HI\7q\2\2I\22\3\2\2\2JK\7u\2\2KL\7n\2\2LM\7q\2\2MN\7x\2\2"+
		"NO\7q\2\2O\24\3\2\2\2PQ\7o\2\2QR\7g\2\2RS\7\u014a\2\2ST\7c\2\2TU\7m\2"+
		"\2U\26\3\2\2\2VW\7e\2\2WX\7k\2\2XY\7u\2\2YZ\7m\2\2Z[\7c\2\2[\\\7l\2\2"+
		"\\\30\3\2\2\2]^\7?\2\2^\32\3\2\2\2_a\t\2\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2"+
		"\2\2bc\3\2\2\2c\34\3\2\2\2dh\7$\2\2eg\13\2\2\2fe\3\2\2\2gj\3\2\2\2hf\3"+
		"\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7$\2\2l\36\3\2\2\2mo\t\3\2\2nm"+
		"\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q \3\2\2\2rt\t\4\2\2sr\3\2\2\2t"+
		"u\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\b\21\2\2x\"\3\2\2\2\b\2+bhp"+
		"u\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}