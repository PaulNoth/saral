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
		T__0=1, TYPE=2, FUNCTION=3, PROC_CALL=4, FUNC_CALL=5, LPAR=6, RPAR=7, 
		INT_T=8, STRING_T=9, VARIABLE=10, PRINT=11, EQUALS=12, RET=13, NUMBER=14, 
		STRING=15, ID=16, EOL=17, EMPTY_LINE=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "TYPE", "FUNCTION", "PROC_CALL", "FUNC_CALL", "LPAR", "RPAR", 
		"INT_T", "STRING_T", "VARIABLE", "PRINT", "EQUALS", "RET", "NUMBER", "STRING", 
		"ID", "EOL", "EMPTY_LINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", null, "'bar'", "'paľ do baru'", "'vrac z baru'", "'('", "')'", 
		"'neskutočné numeralio'", "'slovo'", "'meňak'", "'ciskaj'", "'='", "'vrac'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "TYPE", "FUNCTION", "PROC_CALL", "FUNC_CALL", "LPAR", "RPAR", 
		"INT_T", "STRING_T", "VARIABLE", "PRINT", "EQUALS", "RET", "NUMBER", "STRING", 
		"ID", "EOL", "EMPTY_LINE", "WS"
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
		case 5:
			LPAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 6:
			RPAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 16:
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
		case 16:
			return EOL_sempred((RuleContext)_localctx, predIndex);
		case 17:
			return EMPTY_LINE_sempred((RuleContext)_localctx, predIndex);
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
	private boolean EMPTY_LINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return getCharPositionInLine()==0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u00b5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\6\17\u0082\n\17\r\17\16\17\u0083"+
		"\3\20\3\20\7\20\u0088\n\20\f\20\16\20\u008b\13\20\3\20\3\20\3\21\6\21"+
		"\u0090\n\21\r\21\16\21\u0091\3\22\3\22\3\22\5\22\u0097\n\22\3\22\3\22"+
		"\5\22\u009b\n\22\3\22\5\22\u009e\n\22\5\22\u00a0\n\22\3\22\3\22\3\23\3"+
		"\23\7\23\u00a6\n\23\f\23\16\23\u00a9\13\23\3\23\3\23\3\23\3\23\3\24\6"+
		"\24\u00b0\n\24\r\24\16\24\u00b1\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		"\3\2\5\3\2\62;\31\2\62;C\\c|\u00c3\u00c3\u00c6\u00c6\u00cb\u00cb\u00cf"+
		"\u00cf\u00d5\u00d6\u00dc\u00dc\u00df\u00df\u00e3\u00e3\u00e6\u00e6\u00eb"+
		"\u00eb\u00ef\u00ef\u00f5\u00f6\u00fc\u00fc\u00ff\u00ff\u010e\u0111\u013b"+
		"\u013c\u013f\u0140\u0162\u0163\u0166\u0167\u017f\u0180\4\2\13\13\"\"\u00be"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2\t\63\3\2"+
		"\2\2\13?\3\2\2\2\rK\3\2\2\2\17N\3\2\2\2\21Q\3\2\2\2\23f\3\2\2\2\25l\3"+
		"\2\2\2\27r\3\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35\u0081\3\2\2\2\37\u0085\3"+
		"\2\2\2!\u008f\3\2\2\2#\u009f\3\2\2\2%\u00a3\3\2\2\2\'\u00af\3\2\2\2)*"+
		"\7.\2\2*\4\3\2\2\2+.\5\23\n\2,.\5\21\t\2-+\3\2\2\2-,\3\2\2\2.\6\3\2\2"+
		"\2/\60\7d\2\2\60\61\7c\2\2\61\62\7t\2\2\62\b\3\2\2\2\63\64\7r\2\2\64\65"+
		"\7c\2\2\65\66\7\u0140\2\2\66\67\7\"\2\2\678\7f\2\289\7q\2\29:\7\"\2\2"+
		":;\7d\2\2;<\7c\2\2<=\7t\2\2=>\7w\2\2>\n\3\2\2\2?@\7x\2\2@A\7t\2\2AB\7"+
		"c\2\2BC\7e\2\2CD\7\"\2\2DE\7|\2\2EF\7\"\2\2FG\7d\2\2GH\7c\2\2HI\7t\2\2"+
		"IJ\7w\2\2J\f\3\2\2\2KL\7*\2\2LM\b\7\2\2M\16\3\2\2\2NO\7+\2\2OP\b\b\3\2"+
		"P\20\3\2\2\2QR\7p\2\2RS\7g\2\2ST\7u\2\2TU\7m\2\2UV\7w\2\2VW\7v\2\2WX\7"+
		"q\2\2XY\7\u010f\2\2YZ\7p\2\2Z[\7\u00eb\2\2[\\\7\"\2\2\\]\7p\2\2]^\7w\2"+
		"\2^_\7o\2\2_`\7g\2\2`a\7t\2\2ab\7c\2\2bc\7n\2\2cd\7k\2\2de\7q\2\2e\22"+
		"\3\2\2\2fg\7u\2\2gh\7n\2\2hi\7q\2\2ij\7x\2\2jk\7q\2\2k\24\3\2\2\2lm\7"+
		"o\2\2mn\7g\2\2no\7\u014a\2\2op\7c\2\2pq\7m\2\2q\26\3\2\2\2rs\7e\2\2st"+
		"\7k\2\2tu\7u\2\2uv\7m\2\2vw\7c\2\2wx\7l\2\2x\30\3\2\2\2yz\7?\2\2z\32\3"+
		"\2\2\2{|\7x\2\2|}\7t\2\2}~\7c\2\2~\177\7e\2\2\177\34\3\2\2\2\u0080\u0082"+
		"\t\2\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\36\3\2\2\2\u0085\u0089\7$\2\2\u0086\u0088\13\2\2"+
		"\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7$\2\2\u008d"+
		" \3\2\2\2\u008e\u0090\t\3\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2"+
		"\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\"\3\2\2\2\u0093\u0094\6"+
		"\22\2\2\u0094\u00a0\5\'\24\2\u0095\u0097\7\17\2\2\u0096\u0095\3\2\2\2"+
		"\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009b\7\f\2\2\u0099\u009b"+
		"\7\17\2\2\u009a\u0096\3\2\2\2\u009a\u0099\3\2\2\2\u009b\u009d\3\2\2\2"+
		"\u009c\u009e\5\'\24\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0"+
		"\3\2\2\2\u009f\u0093\3\2\2\2\u009f\u009a\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a2\b\22\4\2\u00a2$\3\2\2\2\u00a3\u00a7\6\23\3\2\u00a4\u00a6\t\4\2"+
		"\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\5#\22\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00ad\b\23\5\2\u00ad&\3\2\2\2\u00ae\u00b0\t\4\2\2"+
		"\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\b\24\5\2\u00b4(\3\2\2\2\r\2-"+
		"\u0083\u0089\u0091\u0096\u009a\u009d\u009f\u00a7\u00b1\6\3\7\2\3\b\3\3"+
		"\22\4\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}