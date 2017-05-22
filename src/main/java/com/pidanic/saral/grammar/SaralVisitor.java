// Generated from Saral.g4 by ANTLR 4.5.3
package com.pidanic.saral.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SaralParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SaralVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SaralParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(SaralParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(SaralParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SaralParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#func_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_block(SaralParser.Func_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(SaralParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SaralParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#simple_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_statement(SaralParser.Simple_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_statement(SaralParser.Block_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#proc_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc_definition(SaralParser.Proc_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#func_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_definition(SaralParser.Func_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(SaralParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#var_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_definition(SaralParser.Var_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite(SaralParser.WriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#proc_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc_call(SaralParser.Proc_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(SaralParser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamlist(SaralParser.ParamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(SaralParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(SaralParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link SaralParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(SaralParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Func}
	 * labeled alternative in {@link SaralParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(SaralParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Value}
	 * labeled alternative in {@link SaralParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SaralParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SaralParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#typeSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSimple(SaralParser.TypeSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#typeBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBasic(SaralParser.TypeBasicContext ctx);
}