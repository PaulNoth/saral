// Generated from Saral.g4 by ANTLR 4.5.3
package com.pidanic.saral.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SaralParser}.
 */
public interface SaralListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SaralParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(SaralParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(SaralParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SaralParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SaralParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SaralParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SaralParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SaralParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SaralParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SaralParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(SaralParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(SaralParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SaralParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_statement(SaralParser.Block_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_statement(SaralParser.Block_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SaralParser#proc_definition}.
	 * @param ctx the parse tree
	 */
	void enterProc_definition(SaralParser.Proc_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#proc_definition}.
	 * @param ctx the parse tree
	 */
	void exitProc_definition(SaralParser.Proc_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SaralParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(SaralParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(SaralParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link SaralParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(SaralParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(SaralParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SaralParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(SaralParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(SaralParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SaralParser#write}.
	 * @param ctx the parse tree
	 */
	void enterWrite(SaralParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#write}.
	 * @param ctx the parse tree
	 */
	void exitWrite(SaralParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link SaralParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SaralParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SaralParser.ValueContext ctx);
}