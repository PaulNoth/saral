// Generated from Saral.g4 by ANTLR 4.5.3
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
		VARIABLE=1, PRINT=2, EQUALS=3, NUMBER=4, STRING=5, ID=6, WS=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"VARIABLE", "PRINT", "EQUALS", "NUMBER", "STRING", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'me≈?ak'", "'ciskaj'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "VARIABLE", "PRINT", "EQUALS", "NUMBER", "STRING", "ID", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\t;\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\6\5#\n\5\r\5\16\5$\3\6\3"+
		"\6\7\6)\n\6\f\6\16\6,\13\6\3\6\3\6\3\7\6\7\61\n\7\r\7\16\7\62\3\b\6\b"+
		"\66\n\b\r\b\16\b\67\3\b\3\b\2\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\5"+
		"\3\2\62;\33\2\62;C\\c|\u00a2\u00a2\u00a6\u00a6\u00ab\u00ab\u00af\u00af"+
		"\u00b6\u00b6\u00c6\u00c6\u0104\u0104\u0106\u0107\u013b\u013b\u0140\u0140"+
		"\u0144\u0144\u015c\u015c\u0161\u0161\u0163\u0163\u0166\u0167\u017b\u017b"+
		"\u017f\u017f\u02c9\u02c9\u02df\u02df\u201e\u2020\u2032\u2032\uffff\uffff"+
		"\5\2\13\f\17\17\"\">\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\30\3\2\2\2\7\37\3"+
		"\2\2\2\t\"\3\2\2\2\13&\3\2\2\2\r\60\3\2\2\2\17\65\3\2\2\2\21\22\7o\2\2"+
		"\22\23\7g\2\2\23\24\7\u013b\2\2\24\25\7\uffff\2\2\25\26\7c\2\2\26\27\7"+
		"m\2\2\27\4\3\2\2\2\30\31\7e\2\2\31\32\7k\2\2\32\33\7u\2\2\33\34\7m\2\2"+
		"\34\35\7c\2\2\35\36\7l\2\2\36\6\3\2\2\2\37 \7?\2\2 \b\3\2\2\2!#\t\2\2"+
		"\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\n\3\2\2\2&*\7$\2\2\')\13"+
		"\2\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-."+
		"\7$\2\2.\f\3\2\2\2/\61\t\3\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2"+
		"\62\63\3\2\2\2\63\16\3\2\2\2\64\66\t\4\2\2\65\64\3\2\2\2\66\67\3\2\2\2"+
		"\67\65\3\2\2\2\678\3\2\2\289\3\2\2\29:\b\b\2\2:\20\3\2\2\2\7\2$*\62\67"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}