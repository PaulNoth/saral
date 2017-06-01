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
		T__0=1, T__1=2, FUNCTION=3, PROC_CALL=4, FUNC_CALL=5, LPAR=6, RPAR=7, 
		ADD=8, SUB=9, MUL=10, DIV=11, INT_T=12, STRING_T=13, VARIABLE=14, PRINT=15, 
		RET=16, NUMBER=17, DIGIT=18, STRING=19, ID=20, LETTER=21, EOL=22, EMPTY_LINE=23, 
		WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "FUNCTION", "PROC_CALL", "FUNC_CALL", "LPAR", "RPAR", 
		"ADD", "SUB", "MUL", "DIV", "INT_T", "STRING_T", "VARIABLE", "PRINT", 
		"RET", "NUMBER", "DIGIT", "STRING", "ID", "LETTER", "EOL", "EMPTY_LINE", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'='", "'bar'", "'paľ do baru'", "'vrac z baru'", "'('", 
		"')'", "'+'", "'-'", "'*'", null, "'neskutočné numeralio'", "'slovo'", 
		"'meňak'", "'ciskaj'", "'vrac'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "FUNCTION", "PROC_CALL", "FUNC_CALL", "LPAR", "RPAR", 
		"ADD", "SUB", "MUL", "DIV", "INT_T", "STRING_T", "VARIABLE", "PRINT", 
		"RET", "NUMBER", "DIGIT", "STRING", "ID", "LETTER", "EOL", "EMPTY_LINE", 
		"WS"
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
		case 21:
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
		case 21:
			return EOL_sempred((RuleContext)_localctx, predIndex);
		case 22:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00d4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\7\22\u0092"+
		"\n\22\f\22\16\22\u0095\13\22\5\22\u0097\n\22\3\23\3\23\3\24\3\24\3\24"+
		"\7\24\u009e\n\24\f\24\16\24\u00a1\13\24\3\24\3\24\3\25\5\25\u00a6\n\25"+
		"\3\25\3\25\3\25\3\25\7\25\u00ac\n\25\f\25\16\25\u00af\13\25\3\26\3\26"+
		"\3\27\3\27\3\27\5\27\u00b6\n\27\3\27\3\27\5\27\u00ba\n\27\3\27\5\27\u00bd"+
		"\n\27\5\27\u00bf\n\27\3\27\3\27\3\30\3\30\7\30\u00c5\n\30\f\30\16\30\u00c8"+
		"\13\30\3\30\3\30\3\30\3\30\3\31\6\31\u00cf\n\31\r\31\16\31\u00d0\3\31"+
		"\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\b\4\2\61"+
		"\61<<\3\2\63;\3\2\62;\3\2$$\30\2C\\c|\u00c3\u00c3\u00c6\u00c6\u00cb\u00cb"+
		"\u00cf\u00cf\u00d5\u00d6\u00dc\u00dc\u00df\u00df\u00e3\u00e3\u00e6\u00e6"+
		"\u00eb\u00eb\u00ef\u00ef\u00f5\u00f6\u00fc\u00fc\u00ff\u00ff\u010e\u0111"+
		"\u013b\u013c\u013f\u0140\u0162\u0163\u0166\u0167\u017f\u0180\4\2\13\13"+
		"\"\"\u00e1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t;\3\2"+
		"\2\2\13G\3\2\2\2\rS\3\2\2\2\17V\3\2\2\2\21Y\3\2\2\2\23[\3\2\2\2\25]\3"+
		"\2\2\2\27_\3\2\2\2\31a\3\2\2\2\33v\3\2\2\2\35|\3\2\2\2\37\u0082\3\2\2"+
		"\2!\u0089\3\2\2\2#\u0096\3\2\2\2%\u0098\3\2\2\2\'\u009a\3\2\2\2)\u00a5"+
		"\3\2\2\2+\u00b0\3\2\2\2-\u00be\3\2\2\2/\u00c2\3\2\2\2\61\u00ce\3\2\2\2"+
		"\63\64\7.\2\2\64\4\3\2\2\2\65\66\7?\2\2\66\6\3\2\2\2\678\7d\2\289\7c\2"+
		"\29:\7t\2\2:\b\3\2\2\2;<\7r\2\2<=\7c\2\2=>\7\u0140\2\2>?\7\"\2\2?@\7f"+
		"\2\2@A\7q\2\2AB\7\"\2\2BC\7d\2\2CD\7c\2\2DE\7t\2\2EF\7w\2\2F\n\3\2\2\2"+
		"GH\7x\2\2HI\7t\2\2IJ\7c\2\2JK\7e\2\2KL\7\"\2\2LM\7|\2\2MN\7\"\2\2NO\7"+
		"d\2\2OP\7c\2\2PQ\7t\2\2QR\7w\2\2R\f\3\2\2\2ST\7*\2\2TU\b\7\2\2U\16\3\2"+
		"\2\2VW\7+\2\2WX\b\b\3\2X\20\3\2\2\2YZ\7-\2\2Z\22\3\2\2\2[\\\7/\2\2\\\24"+
		"\3\2\2\2]^\7,\2\2^\26\3\2\2\2_`\t\2\2\2`\30\3\2\2\2ab\7p\2\2bc\7g\2\2"+
		"cd\7u\2\2de\7m\2\2ef\7w\2\2fg\7v\2\2gh\7q\2\2hi\7\u010f\2\2ij\7p\2\2j"+
		"k\7\u00eb\2\2kl\7\"\2\2lm\7p\2\2mn\7w\2\2no\7o\2\2op\7g\2\2pq\7t\2\2q"+
		"r\7c\2\2rs\7n\2\2st\7k\2\2tu\7q\2\2u\32\3\2\2\2vw\7u\2\2wx\7n\2\2xy\7"+
		"q\2\2yz\7x\2\2z{\7q\2\2{\34\3\2\2\2|}\7o\2\2}~\7g\2\2~\177\7\u014a\2\2"+
		"\177\u0080\7c\2\2\u0080\u0081\7m\2\2\u0081\36\3\2\2\2\u0082\u0083\7e\2"+
		"\2\u0083\u0084\7k\2\2\u0084\u0085\7u\2\2\u0085\u0086\7m\2\2\u0086\u0087"+
		"\7c\2\2\u0087\u0088\7l\2\2\u0088 \3\2\2\2\u0089\u008a\7x\2\2\u008a\u008b"+
		"\7t\2\2\u008b\u008c\7c\2\2\u008c\u008d\7e\2\2\u008d\"\3\2\2\2\u008e\u0097"+
		"\7\62\2\2\u008f\u0093\t\3\2\2\u0090\u0092\5%\23\2\u0091\u0090\3\2\2\2"+
		"\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0097"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u008e\3\2\2\2\u0096\u008f\3\2\2\2\u0097"+
		"$\3\2\2\2\u0098\u0099\t\4\2\2\u0099&\3\2\2\2\u009a\u009f\7$\2\2\u009b"+
		"\u009e\n\5\2\2\u009c\u009e\5-\27\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2"+
		"\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7$\2\2\u00a3(\3\2\2\2\u00a4"+
		"\u00a6\7a\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00ad\5+\26\2\u00a8\u00ac\5+\26\2\u00a9\u00ac\5%\23\2\u00aa"+
		"\u00ac\7a\2\2\u00ab\u00a8\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2"+
		"\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"*\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\t\6\2\2\u00b1,\3\2\2\2\u00b2"+
		"\u00b3\6\27\2\2\u00b3\u00bf\5\61\31\2\u00b4\u00b6\7\17\2\2\u00b5\u00b4"+
		"\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00ba\7\f\2\2\u00b8"+
		"\u00ba\7\17\2\2\u00b9\u00b5\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bc\3"+
		"\2\2\2\u00bb\u00bd\5\61\31\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00bf\3\2\2\2\u00be\u00b2\3\2\2\2\u00be\u00b9\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c1\b\27\4\2\u00c1.\3\2\2\2\u00c2\u00c6\6\30\3\2\u00c3\u00c5"+
		"\t\7\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\5-"+
		"\27\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\b\30\5\2\u00cc\60\3\2\2\2\u00cd"+
		"\u00cf\t\7\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3\2"+
		"\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\31\5\2\u00d3"+
		"\62\3\2\2\2\20\2\u0093\u0096\u009d\u009f\u00a5\u00ab\u00ad\u00b5\u00b9"+
		"\u00bc\u00be\u00c6\u00d0\6\3\7\2\3\b\3\3\27\4\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}