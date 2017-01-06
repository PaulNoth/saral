public class StatementVisitor extends EnkelBaseVisitor<Statement> {

    private Scope scope;

    public StatementVisitor(Scope scope) {
        this.scope = scope;
    }


    @Override
    public Statement visitVariableDeclaration(EnkelParser.VariableDeclarationContext ctx) {
        String variableName = ctx.name().getText();
        EnkelParser.ExpressionContext expressionContext = ctx.expression();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        Expression expression = expressionContext.accept(expressionVisitor);
        scope.addLocalVariable(new LocalVariable(variableName, expression.getType()));
        return new VariableDeclaration(variableName, expression);
    }

    @Override
    public Statement visitPrintStatement(EnkelParser.PrintStatementContext ctx) {
        EnkelParser.ExpressionContext expressionContext = ctx.expression();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        Expression expression = expressionContext.accept(expressionVisitor);
        return new PrintStatement(expression);
    }

    @Override
    public Statement visitFunctionCall(EnkelParser.FunctionCallContext ctx) {
        return (Statement) ctx.accept(new ExpressionVisitor(scope));
    }
}
