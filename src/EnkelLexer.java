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
		VARIABLE=1, PRINT=2, EQUALS=3, NUMBER=4, STRING=5, ID=6, WS=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"VARIABLE", "PRINT", "EQUALS", "NUMBER", "STRING", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'var'", "'print'", "'='"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\t\67\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\6\5\37\n\5\r\5\16\5 \3\6\3\6\7\6%\n\6\f"+
		"\6\16\6(\13\6\3\6\3\6\3\7\6\7-\n\7\r\7\16\7.\3\b\6\b\62\n\b\r\b\16\b\63"+
		"\3\b\3\b\2\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\5\3\2\62;\5\2\62;C\\"+
		"c|\5\2\13\f\17\17\"\":\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\25\3\2\2\2\7\33"+
		"\3\2\2\2\t\36\3\2\2\2\13\"\3\2\2\2\r,\3\2\2\2\17\61\3\2\2\2\21\22\7x\2"+
		"\2\22\23\7c\2\2\23\24\7t\2\2\24\4\3\2\2\2\25\26\7r\2\2\26\27\7t\2\2\27"+
		"\30\7k\2\2\30\31\7p\2\2\31\32\7v\2\2\32\6\3\2\2\2\33\34\7?\2\2\34\b\3"+
		"\2\2\2\35\37\t\2\2\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!"+
		"\n\3\2\2\2\"&\7$\2\2#%\13\2\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2"+
		"\2\')\3\2\2\2(&\3\2\2\2)*\7$\2\2*\f\3\2\2\2+-\t\3\2\2,+\3\2\2\2-.\3\2"+
		"\2\2.,\3\2\2\2./\3\2\2\2/\16\3\2\2\2\60\62\t\4\2\2\61\60\3\2\2\2\62\63"+
		"\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\b\b\2\2\66\20"+
		"\3\2\2\2\7\2 &.\63\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}