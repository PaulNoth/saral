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
		TYPE=1, INT_T=2, STRING_T=3, VARIABLE=4, PRINT=5, EQUALS=6, NUMBER=7, 
		STRING=8, ID=9, WS=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TYPE", "INT_T", "STRING_T", "VARIABLE", "PRINT", "EQUALS", "NUMBER", 
		"STRING", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'neskutočné numeralio'", "'slovo'", "'meňak'", "'ciskaj'", 
		"'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TYPE", "INT_T", "STRING_T", "VARIABLE", "PRINT", "EQUALS", "NUMBER", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\f_\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\5\2\32\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\6\bG\n\b\r\b\16"+
		"\bH\3\t\3\t\7\tM\n\t\f\t\16\tP\13\t\3\t\3\t\3\n\6\nU\n\n\r\n\16\nV\3\13"+
		"\6\13Z\n\13\r\13\16\13[\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\3\2\5\3\2\62;\31\2\62;C\\c|\u00c3\u00c3\u00c6\u00c6\u00cb"+
		"\u00cb\u00cf\u00cf\u00d5\u00d6\u00dc\u00dc\u00df\u00df\u00e3\u00e3\u00e6"+
		"\u00e6\u00eb\u00eb\u00ef\u00ef\u00f5\u00f6\u00fc\u00fc\u00ff\u00ff\u010e"+
		"\u0111\u013b\u013c\u013f\u0140\u0162\u0163\u0166\u0167\u017f\u0180\5\2"+
		"\13\f\17\17\"\"c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\3\31\3\2\2\2\5\33\3\2\2\2\7\60\3\2\2\2\t\66\3\2\2\2\13<\3\2\2\2\rC"+
		"\3\2\2\2\17F\3\2\2\2\21J\3\2\2\2\23T\3\2\2\2\25Y\3\2\2\2\27\32\5\7\4\2"+
		"\30\32\5\5\3\2\31\27\3\2\2\2\31\30\3\2\2\2\32\4\3\2\2\2\33\34\7p\2\2\34"+
		"\35\7g\2\2\35\36\7u\2\2\36\37\7m\2\2\37 \7w\2\2 !\7v\2\2!\"\7q\2\2\"#"+
		"\7\u010f\2\2#$\7p\2\2$%\7\u00eb\2\2%&\7\"\2\2&\'\7p\2\2\'(\7w\2\2()\7"+
		"o\2\2)*\7g\2\2*+\7t\2\2+,\7c\2\2,-\7n\2\2-.\7k\2\2./\7q\2\2/\6\3\2\2\2"+
		"\60\61\7u\2\2\61\62\7n\2\2\62\63\7q\2\2\63\64\7x\2\2\64\65\7q\2\2\65\b"+
		"\3\2\2\2\66\67\7o\2\2\678\7g\2\289\7\u014a\2\29:\7c\2\2:;\7m\2\2;\n\3"+
		"\2\2\2<=\7e\2\2=>\7k\2\2>?\7u\2\2?@\7m\2\2@A\7c\2\2AB\7l\2\2B\f\3\2\2"+
		"\2CD\7?\2\2D\16\3\2\2\2EG\t\2\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2"+
		"\2\2I\20\3\2\2\2JN\7$\2\2KM\13\2\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3"+
		"\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7$\2\2R\22\3\2\2\2SU\t\3\2\2TS\3\2\2\2UV"+
		"\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\24\3\2\2\2XZ\t\4\2\2YX\3\2\2\2Z[\3\2\2\2"+
		"[Y\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\b\13\2\2^\26\3\2\2\2\b\2\31HNV[\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}