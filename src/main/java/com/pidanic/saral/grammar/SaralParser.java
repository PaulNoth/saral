// Generated from Saral.g4 by ANTLR 4.5.3
package com.pidanic.saral.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SaralParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, FUNCTION=3, PROC_CALL=4, FUNC_CALL=5, LPAR=6, RPAR=7, 
		INT_T=8, STRING_T=9, VARIABLE=10, PRINT=11, RET=12, NUMBER=13, DIGIT=14, 
		STRING=15, ID=16, LETTER=17, EOL=18, EMPTY_LINE=19, WS=20, INDENT=21, 
		DEDENT=22;
	public static final int
		RULE_init = 0, RULE_statements = 1, RULE_block = 2, RULE_func_block = 3, 
		RULE_ret = 4, RULE_statement = 5, RULE_simple_statement = 6, RULE_block_statement = 7, 
		RULE_proc_definition = 8, RULE_func_definition = 9, RULE_arglist = 10, 
		RULE_var_definition = 11, RULE_write = 12, RULE_proc_call = 13, RULE_func_call = 14, 
		RULE_paramlist = 15, RULE_var = 16, RULE_val = 17, RULE_expression = 18, 
		RULE_type = 19, RULE_typeSimple = 20, RULE_typeBasic = 21;
	public static final String[] ruleNames = {
		"init", "statements", "block", "func_block", "ret", "statement", "simple_statement", 
		"block_statement", "proc_definition", "func_definition", "arglist", "var_definition", 
		"write", "proc_call", "func_call", "paramlist", "var", "val", "expression", 
		"type", "typeSimple", "typeBasic"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'='", "'bar'", "'paľ do baru'", "'vrac z baru'", "'('", 
		"')'", "'neskutočné numeralio'", "'slovo'", "'meňak'", "'ciskaj'", "'vrac'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "FUNCTION", "PROC_CALL", "FUNC_CALL", "LPAR", "RPAR", 
		"INT_T", "STRING_T", "VARIABLE", "PRINT", "RET", "NUMBER", "DIGIT", "STRING", 
		"ID", "LETTER", "EOL", "EMPTY_LINE", "WS", "INDENT", "DEDENT"
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

	@Override
	public String getGrammarFileName() { return "Saral.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SaralParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InitContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			statements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNCTION) | (1L << PROC_CALL) | (1L << FUNC_CALL) | (1L << VARIABLE) | (1L << PRINT) | (1L << INDENT))) != 0)) {
				{
				{
				setState(46);
				statement();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode INDENT() { return getToken(SaralParser.INDENT, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(SaralParser.DEDENT, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(INDENT);
			setState(53);
			statements();
			setState(54);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_blockContext extends ParserRuleContext {
		public TerminalNode INDENT() { return getToken(SaralParser.INDENT, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(SaralParser.DEDENT, 0); }
		public Func_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterFunc_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitFunc_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitFunc_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_blockContext func_block() throws RecognitionException {
		Func_blockContext _localctx = new Func_blockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(INDENT);
			setState(57);
			statements();
			setState(58);
			ret();
			setState(59);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetContext extends ParserRuleContext {
		public TerminalNode RET() { return getToken(SaralParser.RET, 0); }
		public TerminalNode ID() { return getToken(SaralParser.ID, 0); }
		public TerminalNode EOL() { return getToken(SaralParser.EOL, 0); }
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(RET);
			setState(62);
			match(ID);
			setState(63);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Simple_statementContext simple_statement() {
			return getRuleContext(Simple_statementContext.class,0);
		}
		public TerminalNode EOL() { return getToken(SaralParser.EOL, 0); }
		public Block_statementContext block_statement() {
			return getRuleContext(Block_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		int _la;
		try {
			setState(72);
			switch (_input.LA(1)) {
			case PROC_CALL:
			case FUNC_CALL:
			case VARIABLE:
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				simple_statement();
				setState(66);
				match(EOL);
				}
				break;
			case FUNCTION:
			case INDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				block_statement();
				setState(70);
				_la = _input.LA(1);
				if (_la==EOL) {
					{
					setState(69);
					match(EOL);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_statementContext extends ParserRuleContext {
		public WriteContext write() {
			return getRuleContext(WriteContext.class,0);
		}
		public Var_definitionContext var_definition() {
			return getRuleContext(Var_definitionContext.class,0);
		}
		public Proc_callContext proc_call() {
			return getRuleContext(Proc_callContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public Simple_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterSimple_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitSimple_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitSimple_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_statementContext simple_statement() throws RecognitionException {
		Simple_statementContext _localctx = new Simple_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_simple_statement);
		try {
			setState(78);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				write();
				}
				break;
			case VARIABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				var_definition();
				}
				break;
			case PROC_CALL:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				proc_call();
				}
				break;
			case FUNC_CALL:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				func_call();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_statementContext extends ParserRuleContext {
		public Proc_definitionContext proc_definition() {
			return getRuleContext(Proc_definitionContext.class,0);
		}
		public Func_definitionContext func_definition() {
			return getRuleContext(Func_definitionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Block_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterBlock_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitBlock_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitBlock_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_statementContext block_statement() throws RecognitionException {
		Block_statementContext _localctx = new Block_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block_statement);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				proc_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				func_definition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Proc_definitionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(SaralParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(SaralParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SaralParser.LPAR, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SaralParser.RPAR, 0); }
		public TerminalNode EOL() { return getToken(SaralParser.EOL, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Proc_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proc_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterProc_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitProc_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitProc_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Proc_definitionContext proc_definition() throws RecognitionException {
		Proc_definitionContext _localctx = new Proc_definitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_proc_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(FUNCTION);
			setState(86);
			match(ID);
			setState(87);
			match(LPAR);
			setState(88);
			arglist();
			setState(89);
			match(RPAR);
			setState(90);
			match(EOL);
			setState(91);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_definitionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(SaralParser.FUNCTION, 0); }
		public TypeBasicContext typeBasic() {
			return getRuleContext(TypeBasicContext.class,0);
		}
		public TerminalNode ID() { return getToken(SaralParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SaralParser.LPAR, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SaralParser.RPAR, 0); }
		public TerminalNode EOL() { return getToken(SaralParser.EOL, 0); }
		public Func_blockContext func_block() {
			return getRuleContext(Func_blockContext.class,0);
		}
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterFunc_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitFunc_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitFunc_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_func_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(FUNCTION);
			setState(94);
			typeBasic();
			setState(95);
			match(ID);
			setState(96);
			match(LPAR);
			setState(97);
			arglist();
			setState(98);
			match(RPAR);
			setState(99);
			match(EOL);
			setState(100);
			func_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArglistContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(SaralParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SaralParser.ID, i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterArglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitArglist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitArglist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arglist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if (_la==INT_T || _la==STRING_T) {
				{
				setState(102);
				type();
				setState(103);
				match(ID);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(104);
					match(T__0);
					setState(105);
					type();
					setState(106);
					match(ID);
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_definitionContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(SaralParser.VARIABLE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SaralParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Var_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterVar_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitVar_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitVar_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_definitionContext var_definition() throws RecognitionException {
		Var_definitionContext _localctx = new Var_definitionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_var_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(VARIABLE);
			setState(116);
			type();
			setState(117);
			match(ID);
			setState(118);
			match(T__1);
			setState(119);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WriteContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(SaralParser.PRINT, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitWrite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitWrite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(PRINT);
			setState(122);
			var();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Proc_callContext extends ParserRuleContext {
		public TerminalNode PROC_CALL() { return getToken(SaralParser.PROC_CALL, 0); }
		public TerminalNode ID() { return getToken(SaralParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SaralParser.LPAR, 0); }
		public ParamlistContext paramlist() {
			return getRuleContext(ParamlistContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SaralParser.RPAR, 0); }
		public Proc_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proc_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterProc_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitProc_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitProc_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Proc_callContext proc_call() throws RecognitionException {
		Proc_callContext _localctx = new Proc_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_proc_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(PROC_CALL);
			setState(125);
			match(ID);
			setState(126);
			match(LPAR);
			setState(127);
			paramlist();
			setState(128);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_callContext extends ParserRuleContext {
		public TerminalNode FUNC_CALL() { return getToken(SaralParser.FUNC_CALL, 0); }
		public TerminalNode ID() { return getToken(SaralParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SaralParser.LPAR, 0); }
		public ParamlistContext paramlist() {
			return getRuleContext(ParamlistContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SaralParser.RPAR, 0); }
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterFunc_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitFunc_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitFunc_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_func_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(FUNC_CALL);
			setState(131);
			match(ID);
			setState(132);
			match(LPAR);
			setState(133);
			paramlist();
			setState(134);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamlistContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public ParamlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterParamlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitParamlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitParamlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamlistContext paramlist() throws RecognitionException {
		ParamlistContext _localctx = new ParamlistContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_paramlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(136);
				var();
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(137);
					match(T__0);
					setState(138);
					var();
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SaralParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(SaralParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(SaralParser.STRING, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==STRING) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncContext extends ExpressionContext {
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public FuncContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueContext extends ExpressionContext {
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public ValueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenContext extends ExpressionContext {
		public List<TerminalNode> LPAR() { return getTokens(SaralParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(SaralParser.LPAR, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expression);
		try {
			setState(156);
			switch (_input.LA(1)) {
			case LPAR:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(LPAR);
				setState(151);
				expression();
				setState(152);
				match(LPAR);
				}
				break;
			case FUNC_CALL:
				_localctx = new FuncContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				func_call();
				}
				break;
			case NUMBER:
			case STRING:
				_localctx = new ValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				val();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeBasicContext typeBasic() {
			return getRuleContext(TypeBasicContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			typeBasic();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSimpleContext extends ParserRuleContext {
		public TerminalNode INT_T() { return getToken(SaralParser.INT_T, 0); }
		public TypeSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSimple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterTypeSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitTypeSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitTypeSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSimpleContext typeSimple() throws RecognitionException {
		TypeSimpleContext _localctx = new TypeSimpleContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeSimple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(INT_T);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeBasicContext extends ParserRuleContext {
		public TypeSimpleContext typeSimple() {
			return getRuleContext(TypeSimpleContext.class,0);
		}
		public TerminalNode STRING_T() { return getToken(SaralParser.STRING_T, 0); }
		public TypeBasicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBasic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterTypeBasic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitTypeBasic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitTypeBasic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeBasicContext typeBasic() throws RecognitionException {
		TypeBasicContext _localctx = new TypeBasicContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeBasic);
		try {
			setState(164);
			switch (_input.LA(1)) {
			case INT_T:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				typeSimple();
				}
				break;
			case STRING_T:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(STRING_T);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u00a9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\7\3\62"+
		"\n\3\f\3\16\3\65\13\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\5\7I\n\7\5\7K\n\7\3\b\3\b\3\b\3\b\5\bQ\n\b\3"+
		"\t\3\t\3\t\5\tV\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\fo\n\f\f\f\16\fr\13"+
		"\f\5\ft\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u008e\n\21"+
		"\f\21\16\21\u0091\13\21\5\21\u0093\n\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u009f\n\24\3\25\3\25\3\26\3\26\3\27\3\27\5\27"+
		"\u00a7\n\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",\2\3\4\2\17\17\21\21\u00a1\2.\3\2\2\2\4\63\3\2\2\2\6\66\3\2\2\2\b:\3"+
		"\2\2\2\n?\3\2\2\2\fJ\3\2\2\2\16P\3\2\2\2\20U\3\2\2\2\22W\3\2\2\2\24_\3"+
		"\2\2\2\26s\3\2\2\2\30u\3\2\2\2\32{\3\2\2\2\34~\3\2\2\2\36\u0084\3\2\2"+
		"\2 \u0092\3\2\2\2\"\u0094\3\2\2\2$\u0096\3\2\2\2&\u009e\3\2\2\2(\u00a0"+
		"\3\2\2\2*\u00a2\3\2\2\2,\u00a6\3\2\2\2./\5\4\3\2/\3\3\2\2\2\60\62\5\f"+
		"\7\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\5\3\2"+
		"\2\2\65\63\3\2\2\2\66\67\7\27\2\2\678\5\4\3\289\7\30\2\29\7\3\2\2\2:;"+
		"\7\27\2\2;<\5\4\3\2<=\5\n\6\2=>\7\30\2\2>\t\3\2\2\2?@\7\16\2\2@A\7\22"+
		"\2\2AB\7\24\2\2B\13\3\2\2\2CD\5\16\b\2DE\7\24\2\2EK\3\2\2\2FH\5\20\t\2"+
		"GI\7\24\2\2HG\3\2\2\2HI\3\2\2\2IK\3\2\2\2JC\3\2\2\2JF\3\2\2\2K\r\3\2\2"+
		"\2LQ\5\32\16\2MQ\5\30\r\2NQ\5\34\17\2OQ\5\36\20\2PL\3\2\2\2PM\3\2\2\2"+
		"PN\3\2\2\2PO\3\2\2\2Q\17\3\2\2\2RV\5\22\n\2SV\5\24\13\2TV\5\6\4\2UR\3"+
		"\2\2\2US\3\2\2\2UT\3\2\2\2V\21\3\2\2\2WX\7\5\2\2XY\7\22\2\2YZ\7\b\2\2"+
		"Z[\5\26\f\2[\\\7\t\2\2\\]\7\24\2\2]^\5\6\4\2^\23\3\2\2\2_`\7\5\2\2`a\5"+
		",\27\2ab\7\22\2\2bc\7\b\2\2cd\5\26\f\2de\7\t\2\2ef\7\24\2\2fg\5\b\5\2"+
		"g\25\3\2\2\2hi\5(\25\2ip\7\22\2\2jk\7\3\2\2kl\5(\25\2lm\7\22\2\2mo\3\2"+
		"\2\2nj\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2sh\3\2"+
		"\2\2st\3\2\2\2t\27\3\2\2\2uv\7\f\2\2vw\5(\25\2wx\7\22\2\2xy\7\4\2\2yz"+
		"\5&\24\2z\31\3\2\2\2{|\7\r\2\2|}\5\"\22\2}\33\3\2\2\2~\177\7\6\2\2\177"+
		"\u0080\7\22\2\2\u0080\u0081\7\b\2\2\u0081\u0082\5 \21\2\u0082\u0083\7"+
		"\t\2\2\u0083\35\3\2\2\2\u0084\u0085\7\7\2\2\u0085\u0086\7\22\2\2\u0086"+
		"\u0087\7\b\2\2\u0087\u0088\5 \21\2\u0088\u0089\7\t\2\2\u0089\37\3\2\2"+
		"\2\u008a\u008f\5\"\22\2\u008b\u008c\7\3\2\2\u008c\u008e\5\"\22\2\u008d"+
		"\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u008a\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093!\3\2\2\2\u0094\u0095\7\22\2\2\u0095#\3\2\2\2\u0096"+
		"\u0097\t\2\2\2\u0097%\3\2\2\2\u0098\u0099\7\b\2\2\u0099\u009a\5&\24\2"+
		"\u009a\u009b\7\b\2\2\u009b\u009f\3\2\2\2\u009c\u009f\5\36\20\2\u009d\u009f"+
		"\5$\23\2\u009e\u0098\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\'\3\2\2\2\u00a0\u00a1\5,\27\2\u00a1)\3\2\2\2\u00a2\u00a3\7\n\2\2\u00a3"+
		"+\3\2\2\2\u00a4\u00a7\5*\26\2\u00a5\u00a7\7\13\2\2\u00a6\u00a4\3\2\2\2"+
		"\u00a6\u00a5\3\2\2\2\u00a7-\3\2\2\2\r\63HJPUps\u008f\u0092\u009e\u00a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}