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
		T__0=1, TYPE=2, FUNCTION=3, LPAR=4, RPAR=5, INT_T=6, STRING_T=7, VARIABLE=8, 
		PRINT=9, EQUALS=10, NUMBER=11, STRING=12, ID=13, EOL=14, WS=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "TYPE", "FUNCTION", "LPAR", "RPAR", "INT_T", "STRING_T", "VARIABLE", 
		"PRINT", "EQUALS", "NUMBER", "STRING", "ID", "EOL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", null, "'bar'", "'('", "')'", "'neskutočné numeralio'", "'slovo'", 
		"'meňak'", "'ciskaj'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "TYPE", "FUNCTION", "LPAR", "RPAR", "INT_T", "STRING_T", "VARIABLE", 
		"PRINT", "EQUALS", "NUMBER", "STRING", "ID", "EOL", "WS"
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


	    private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();

	    private java.util.Stack<Integer> indents = new java.util.Stack<>();

	    private int opened = 0;

	    private Token last = null;

	    @Override
	    public void emit(Token t) {
	        super.setToken(t);
	        tokens.offer(t);
	    }

	    @Override
	    public Token nextToken() {
	        // Check if the end-of-file is ahead and there are still some DEDENTS expected.
	        if(_input.LA(1) == EOF && !this.indents.isEmpty()) {
	            // Remove any trailing EOF tokens from our buffer.
	            for(int i = tokens.size() - 1; i >= 0; i--) {
	                if(tokens.get(i).getType() == EOF) {
	                    tokens.remove(i);
	                }
	            }

	            // First emit an extra line break that serves as the end of the statement.
	            this.emit(commonToken(SaralParser.EOL, "\n"));

	            // Now emit as much DEDENT tokens as needed.
	            while(!this.indents.isEmpty()) {
	                this.emit(createDedent());
	                indents.pop();
	            }

	            // Put the EOF back on the token stream.
	            this.emit(commonToken(SaralParser.EOF, "<EOF>"));
	        }

	        Token next = super.nextToken();
	        if(next.getChannel() == Token.DEFAULT_CHANNEL) {
	            // keep track of the latest token on the default channel
	            this.last = next;
	        }

	        return tokens.isEmpty() ? next : tokens.poll();
	    }

	    private Token createDedent() {
	        CommonToken dedent = commonToken(SaralParser.DEDENT, "");
	        dedent.setLine(this.last.getLine());
	        return dedent;
	    }

	    private CommonToken commonToken(int type, String text) {
	        int stop = this.getCharIndex() - 1;
	        int start = text.isEmpty() ? stop : stop - text.length() + 1;
	        return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
	    }

	    // Calculates the indentation of the provided spaces, taking the
	    // following rules into account:
	    //
	    // "Tabs are replaced (from left to right) by one to eight spaces
	    //  such that the total number of characters up to and including
	    //  the replacement is a multiple of eight [...]"
	    static int getIndentationCount(String spaces) {
	        int count = 0;

	        for(char ch : spaces.toCharArray()) {
	            switch(ch) {
	                case '\t':
	                    count += 8 - (count % 8);
	                    break;
	                default:
	                    count++;
	            }
	        }
	        return count;
	    }

	    boolean atStartOfInput() {
	        return super.getCharPositionInLine() == 0 && super.getLine() == 1;
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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 3:
			LPAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 4:
			RPAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 13:
			EOL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void LPAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			opened++;
			break;
		}
	}
	private void RPAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			opened--;
			break;
		}
	}
	private void EOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:

			        String newLine = getText().replaceAll("[^\r\n]+", "");
			        String spaces = getText().replaceAll("[\r\n]+", "");
			        int next = _input.LA(1);

			        if(opened > 0 || next == '\r' || next == '\n') {
			         // || next == '/') should skip comment
			            skip();
			        } else {
			            emit(commonToken(EOL, newLine));

			            int indent = getIndentationCount(spaces);
			            int previous = indents.isEmpty() ? 0 : indents.peek();

			            if(indent == previous) {
			                // skip indents of the same size as the present indent-size
			                skip();
			            } else if(indent > previous) {
			                indents.push(indent);
			                emit(commonToken(SaralParser.INDENT, spaces));
			            } else {
			                // Possibly emit more than 1 DEDENT token.
			                while(!indents.isEmpty() && indents.peek() > indent) {
			                    this.emit(createDedent());
			                    indents.pop();
			                }
			            }
			        }
			    
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return EOL_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean EOL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21\u0085\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3"+
		"\5\3&\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\f\6\f]\n\f\r\f\16\f^\3\r\3\r\7\rc\n\r\f\r\16\rf\13\r\3\r"+
		"\3\r\3\16\6\16k\n\16\r\16\16\16l\3\17\3\17\3\17\5\17r\n\17\3\17\3\17\5"+
		"\17v\n\17\3\17\5\17y\n\17\5\17{\n\17\3\17\3\17\3\20\6\20\u0080\n\20\r"+
		"\20\16\20\u0081\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\5\3\2\62;\31\2\62;C\\c|\u00c3"+
		"\u00c3\u00c6\u00c6\u00cb\u00cb\u00cf\u00cf\u00d5\u00d6\u00dc\u00dc\u00df"+
		"\u00df\u00e3\u00e3\u00e6\u00e6\u00eb\u00eb\u00ef\u00ef\u00f5\u00f6\u00fc"+
		"\u00fc\u00ff\u00ff\u010e\u0111\u013b\u013c\u013f\u0140\u0162\u0163\u0166"+
		"\u0167\u017f\u0180\4\2\13\13\"\"\u008d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5%\3\2\2\2\7\'\3\2\2\2\t+\3\2\2\2\13.\3"+
		"\2\2\2\r\61\3\2\2\2\17F\3\2\2\2\21L\3\2\2\2\23R\3\2\2\2\25Y\3\2\2\2\27"+
		"\\\3\2\2\2\31`\3\2\2\2\33j\3\2\2\2\35z\3\2\2\2\37\177\3\2\2\2!\"\7.\2"+
		"\2\"\4\3\2\2\2#&\5\17\b\2$&\5\r\7\2%#\3\2\2\2%$\3\2\2\2&\6\3\2\2\2\'("+
		"\7d\2\2()\7c\2\2)*\7t\2\2*\b\3\2\2\2+,\7*\2\2,-\b\5\2\2-\n\3\2\2\2./\7"+
		"+\2\2/\60\b\6\3\2\60\f\3\2\2\2\61\62\7p\2\2\62\63\7g\2\2\63\64\7u\2\2"+
		"\64\65\7m\2\2\65\66\7w\2\2\66\67\7v\2\2\678\7q\2\289\7\u010f\2\29:\7p"+
		"\2\2:;\7\u00eb\2\2;<\7\"\2\2<=\7p\2\2=>\7w\2\2>?\7o\2\2?@\7g\2\2@A\7t"+
		"\2\2AB\7c\2\2BC\7n\2\2CD\7k\2\2DE\7q\2\2E\16\3\2\2\2FG\7u\2\2GH\7n\2\2"+
		"HI\7q\2\2IJ\7x\2\2JK\7q\2\2K\20\3\2\2\2LM\7o\2\2MN\7g\2\2NO\7\u014a\2"+
		"\2OP\7c\2\2PQ\7m\2\2Q\22\3\2\2\2RS\7e\2\2ST\7k\2\2TU\7u\2\2UV\7m\2\2V"+
		"W\7c\2\2WX\7l\2\2X\24\3\2\2\2YZ\7?\2\2Z\26\3\2\2\2[]\t\2\2\2\\[\3\2\2"+
		"\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\30\3\2\2\2`d\7$\2\2ac\13\2\2\2ba\3"+
		"\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7$\2\2h\32"+
		"\3\2\2\2ik\t\3\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\34\3\2\2\2"+
		"no\6\17\2\2o{\5\37\20\2pr\7\17\2\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2sv\7\f"+
		"\2\2tv\7\17\2\2uq\3\2\2\2ut\3\2\2\2vx\3\2\2\2wy\5\37\20\2xw\3\2\2\2xy"+
		"\3\2\2\2y{\3\2\2\2zn\3\2\2\2zu\3\2\2\2{|\3\2\2\2|}\b\17\4\2}\36\3\2\2"+
		"\2~\u0080\t\4\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\b\20\5\2\u0084 \3\2\2\2"+
		"\f\2%^dlquxz\u0081\6\3\5\2\3\6\3\3\17\4\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}