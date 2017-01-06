// Generated from Enkel.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EnkelParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EnkelVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EnkelParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(EnkelParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(EnkelParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(EnkelParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(EnkelParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(EnkelParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(EnkelParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(EnkelParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#functionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgument(EnkelParser.FunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#functionParamDefaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParamDefaultValue(EnkelParser.FunctionParamDefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(EnkelParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(EnkelParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(EnkelParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(EnkelParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(EnkelParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(EnkelParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(EnkelParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(EnkelParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(EnkelParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(EnkelParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#varReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarReference(EnkelParser.VarReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnkelParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(EnkelParser.ValueContext ctx);
}