import java.util.List;
import java.util.stream.Collectors;

public class FunctionVisitor extends EnkelBaseVisitor<Function> {

    private Scope scope;

    public FunctionVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public Function visitFunction(EnkelParser.FunctionContext ctx) {
        String name = getName(ctx);
        Type returnType = getReturnType(ctx);
        List<FunctionParameter> arguments = getArguments(ctx);
        List<Statement> instructions = getStatements(ctx);
        return new Function(scope, name, returnType, arguments, instructions);
    }

    private String getName(EnkelParser.FunctionContext ctx) {
        return ctx.functionDeclaration().functionName().getText();
    }

    private Type getReturnType(EnkelParser.FunctionContext context) {
        EnkelParser.TypeContext typeCtx = context.functionDeclaration().type();
        return TypeResolver.getFromTypeName(typeCtx);
    }

    private List<FunctionParameter> getArguments(EnkelParser.FunctionContext functionDeclarationContext) {
        List<EnkelParser.FunctionArgumentContext> argCtx
                = functionDeclarationContext.functionDeclaration().functionArgument();
        List<FunctionParameter> parameters = argCtx.stream()
                .map(ctx -> new FunctionParameter(ctx.ID().getText(), TypeResolver.getFromTypeName(ctx.type())))
                .peek(param -> scope.addLocalVariable(new LocalVariable(param.getName(), param.getType())))
                .collect(Collectors.toList());
        return parameters;
    }

    private List<Statement> getStatements(EnkelParser.FunctionContext ctx) {
        StatementVisitor statementVisitor = new StatementVisitor(scope);
        List<Statement> statements = ctx.blockStatement().stream()
                .map(stmt -> stmt.accept(statementVisitor)).collect(Collectors.toList());
        return statements;
    }
}
