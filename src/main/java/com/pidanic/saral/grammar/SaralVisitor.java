package com.pidanic.saral.grammar;// Generated from Saral.g4 by ANTLR 4.5.3

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
	 * Visit a parse tree produced by {@link SaralParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(SaralParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SaralParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(SaralParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(SaralParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SaralParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SaralParser.ValueContext ctx);
}