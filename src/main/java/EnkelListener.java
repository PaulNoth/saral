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
	 * Enter a parse tree produced by {@link EnkelParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(EnkelParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(EnkelParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnkelParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(EnkelParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnkelParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(EnkelParser.PrintContext ctx);
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