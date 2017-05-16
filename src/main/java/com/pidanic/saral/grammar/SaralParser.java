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
		RULE_var_declaration = 11, RULE_write = 12, RULE_proc_call = 13, RULE_func_call = 14, 
		RULE_paramlist = 15, RULE_var = 16, RULE_val = 17, RULE_type = 18, RULE_typeSimple = 19, 
		RULE_typeBasic = 20;
	public static final String[] ruleNames = {
		"init", "statements", "block", "func_block", "ret", "statement", "simple_statement", 
		"block_statement", "proc_definition", "func_definition", "arglist", "var_declaration", 
		"write", "proc_call", "func_call", "paramlist", "var", "val", "type", 
		"typeSimple", "typeBasic"
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
			setState(42);
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
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNCTION) | (1L << PROC_CALL) | (1L << FUNC_CALL) | (1L << VARIABLE) | (1L << PRINT) | (1L << INDENT))) != 0)) {
				{
				{
				setState(44);
				statement();
				}
				}
				setState(49);
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
			setState(50);
			match(INDENT);
			setState(51);
			statements();
			setState(52);
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
			setState(54);
			match(INDENT);
			setState(55);
			statements();
			setState(56);
			ret();
			setState(57);
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
			setState(59);
			match(RET);
			setState(60);
			match(ID);
			setState(61);
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
			setState(70);
			switch (_input.LA(1)) {
			case PROC_CALL:
			case FUNC_CALL:
			case VARIABLE:
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				simple_statement();
				setState(64);
				match(EOL);
				}
				break;
			case FUNCTION:
			case INDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				block_statement();
				setState(68);
				_la = _input.LA(1);
				if (_la==EOL) {
					{
					setState(67);
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
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
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
			setState(76);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				write();
				}
				break;
			case VARIABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				var_declaration();
				}
				break;
			case PROC_CALL:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				proc_call();
				}
				break;
			case FUNC_CALL:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
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
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				proc_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				func_definition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
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
			setState(83);
			match(FUNCTION);
			setState(84);
			match(ID);
			setState(85);
			match(LPAR);
			setState(86);
			arglist();
			setState(87);
			match(RPAR);
			setState(88);
			match(EOL);
			setState(89);
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
			setState(91);
			match(FUNCTION);
			setState(92);
			typeBasic();
			setState(93);
			match(ID);
			setState(94);
			match(LPAR);
			setState(95);
			arglist();
			setState(96);
			match(RPAR);
			setState(97);
			match(EOL);
			setState(98);
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
			setState(111);
			_la = _input.LA(1);
			if (_la==INT_T || _la==STRING_T) {
				{
				setState(100);
				type();
				setState(101);
				match(ID);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(102);
					match(T__0);
					setState(103);
					type();
					setState(104);
					match(ID);
					}
					}
					setState(110);
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

	public static class Var_declarationContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(SaralParser.VARIABLE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SaralParser.ID, 0); }
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public Var_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).enterVar_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SaralListener ) ((SaralListener)listener).exitVar_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SaralVisitor ) return ((SaralVisitor<? extends T>)visitor).visitVar_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declarationContext var_declaration() throws RecognitionException {
		Var_declarationContext _localctx = new Var_declarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_var_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(VARIABLE);
			setState(114);
			type();
			setState(115);
			match(ID);
			setState(116);
			match(T__1);
			setState(117);
			val();
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
		public TerminalNode ID() { return getToken(SaralParser.ID, 0); }
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
			setState(119);
			match(PRINT);
			setState(120);
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
			setState(122);
			match(PROC_CALL);
			setState(123);
			match(ID);
			setState(124);
			match(LPAR);
			setState(125);
			paramlist();
			setState(126);
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
			setState(128);
			match(FUNC_CALL);
			setState(129);
			match(ID);
			setState(130);
			match(LPAR);
			setState(131);
			paramlist();
			setState(132);
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
			setState(142);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(134);
				var();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(135);
					match(T__0);
					setState(136);
					var();
					}
					}
					setState(141);
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
			setState(144);
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
			setState(146);
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
		enterRule(_localctx, 36, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
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
		enterRule(_localctx, 38, RULE_typeSimple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
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
		enterRule(_localctx, 40, RULE_typeBasic);
		try {
			setState(154);
			switch (_input.LA(1)) {
			case INT_T:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				typeSimple();
				}
				break;
			case STRING_T:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u009f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\7\3\60\n\3\f\3\16"+
		"\3\63\13\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\5\7G\n\7\5\7I\n\7\3\b\3\b\3\b\3\b\5\bO\n\b\3\t\3\t\3\t\5"+
		"\tT\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\fm\n\f\f\f\16\fp\13\f\5\fr\n"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u008c\n\21\f\21\16"+
		"\21\u008f\13\21\5\21\u0091\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\5\26\u009d\n\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*\2\3\4\2\17\17\21\21\u0096\2,\3\2\2\2\4\61\3\2\2\2\6\64\3"+
		"\2\2\2\b8\3\2\2\2\n=\3\2\2\2\fH\3\2\2\2\16N\3\2\2\2\20S\3\2\2\2\22U\3"+
		"\2\2\2\24]\3\2\2\2\26q\3\2\2\2\30s\3\2\2\2\32y\3\2\2\2\34|\3\2\2\2\36"+
		"\u0082\3\2\2\2 \u0090\3\2\2\2\"\u0092\3\2\2\2$\u0094\3\2\2\2&\u0096\3"+
		"\2\2\2(\u0098\3\2\2\2*\u009c\3\2\2\2,-\5\4\3\2-\3\3\2\2\2.\60\5\f\7\2"+
		"/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\5\3\2\2\2\63\61"+
		"\3\2\2\2\64\65\7\27\2\2\65\66\5\4\3\2\66\67\7\30\2\2\67\7\3\2\2\289\7"+
		"\27\2\29:\5\4\3\2:;\5\n\6\2;<\7\30\2\2<\t\3\2\2\2=>\7\16\2\2>?\7\22\2"+
		"\2?@\7\24\2\2@\13\3\2\2\2AB\5\16\b\2BC\7\24\2\2CI\3\2\2\2DF\5\20\t\2E"+
		"G\7\24\2\2FE\3\2\2\2FG\3\2\2\2GI\3\2\2\2HA\3\2\2\2HD\3\2\2\2I\r\3\2\2"+
		"\2JO\5\32\16\2KO\5\30\r\2LO\5\34\17\2MO\5\36\20\2NJ\3\2\2\2NK\3\2\2\2"+
		"NL\3\2\2\2NM\3\2\2\2O\17\3\2\2\2PT\5\22\n\2QT\5\24\13\2RT\5\6\4\2SP\3"+
		"\2\2\2SQ\3\2\2\2SR\3\2\2\2T\21\3\2\2\2UV\7\5\2\2VW\7\22\2\2WX\7\b\2\2"+
		"XY\5\26\f\2YZ\7\t\2\2Z[\7\24\2\2[\\\5\6\4\2\\\23\3\2\2\2]^\7\5\2\2^_\5"+
		"*\26\2_`\7\22\2\2`a\7\b\2\2ab\5\26\f\2bc\7\t\2\2cd\7\24\2\2de\5\b\5\2"+
		"e\25\3\2\2\2fg\5&\24\2gn\7\22\2\2hi\7\3\2\2ij\5&\24\2jk\7\22\2\2km\3\2"+
		"\2\2lh\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2or\3\2\2\2pn\3\2\2\2qf\3\2"+
		"\2\2qr\3\2\2\2r\27\3\2\2\2st\7\f\2\2tu\5&\24\2uv\7\22\2\2vw\7\4\2\2wx"+
		"\5$\23\2x\31\3\2\2\2yz\7\r\2\2z{\7\22\2\2{\33\3\2\2\2|}\7\6\2\2}~\7\22"+
		"\2\2~\177\7\b\2\2\177\u0080\5 \21\2\u0080\u0081\7\t\2\2\u0081\35\3\2\2"+
		"\2\u0082\u0083\7\7\2\2\u0083\u0084\7\22\2\2\u0084\u0085\7\b\2\2\u0085"+
		"\u0086\5 \21\2\u0086\u0087\7\t\2\2\u0087\37\3\2\2\2\u0088\u008d\5\"\22"+
		"\2\u0089\u008a\7\3\2\2\u008a\u008c\5\"\22\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"!\3\2\2\2\u0092\u0093\7\22\2\2\u0093#\3\2\2\2\u0094\u0095\t\2\2\2\u0095"+
		"%\3\2\2\2\u0096\u0097\5*\26\2\u0097\'\3\2\2\2\u0098\u0099\7\n\2\2\u0099"+
		")\3\2\2\2\u009a\u009d\5(\25\2\u009b\u009d\7\13\2\2\u009c\u009a\3\2\2\2"+
		"\u009c\u009b\3\2\2\2\u009d+\3\2\2\2\f\61FHNSnq\u008d\u0090\u009c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}