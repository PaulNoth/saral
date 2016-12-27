package com.pidanic.saral.grammar;// Generated from Saral.g4 by ANTLR 4.5.3
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
	 * Enter a parse tree produced by {@link SaralParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(SaralParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SaralParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(SaralParser.PrintContext ctx);
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