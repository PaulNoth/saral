// Generated from Enkel.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EnkelParser}.
 */
public interface EnkelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EnkelParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(EnkelParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(EnkelParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(EnkelParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(EnkelParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(EnkelParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(EnkelParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(EnkelParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(EnkelParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(EnkelParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(EnkelParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(EnkelParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(EnkelParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(EnkelParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(EnkelParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgument(EnkelParser.FunctionArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgument(EnkelParser.FunctionArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#functionParamDefaultValue}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParamDefaultValue(EnkelParser.FunctionParamDefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#functionParamDefaultValue}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParamDefaultValue(EnkelParser.FunctionParamDefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(EnkelParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(EnkelParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(EnkelParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(EnkelParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(EnkelParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(EnkelParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(EnkelParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(EnkelParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(EnkelParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(EnkelParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(EnkelParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(EnkelParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(EnkelParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(EnkelParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(EnkelParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(EnkelParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(EnkelParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(EnkelParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(EnkelParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(EnkelParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#varReference}.
	 * @param ctx the parse tree
	 */
	void enterVarReference(EnkelParser.VarReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#varReference}.
	 * @param ctx the parse tree
	 */
	void exitVarReference(EnkelParser.VarReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(EnkelParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(EnkelParser.ValueContext ctx);
}