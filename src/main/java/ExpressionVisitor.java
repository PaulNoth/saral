import java.util.List;
import java.util.stream.Collectors;

public class ExpressionVisitor extends EnkelBaseVisitor<Expression> {

    private Scope scope;

    public ExpressionVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Expression visitVarReference(EnkelParser.VarReferenceContext ctx) {
        String varName = ctx.getText();
        LocalVariable localVariable = scope.getLocalVariable(varName);
        return new VarReference(localVariable.getType(), varName);
    }

    @Override
    public Expression visitFunctionCall(EnkelParser.FunctionCallContext ctx) {
        String funName = ctx.functionName().getText();
        FunctionSignature signature = scope.getSignature(funName);
        List<FunctionParameter> signatureParameters = signature.getArguments();
        List<EnkelParser.ExpressionContext> calledParameters = ctx.expressionList().expression();
        List<Expression> arguments = calledParameters.stream()
                .map((expressionContext) -> expressionContext.accept(this))
                .collect(Collectors.toList());
        Type returnType = signature.getReturnType();
        return new FunctionCall(signature, arguments,returnType);
    }

    @Override
    public Expression visitValue(EnkelParser.ValueContext ctx) {
        String value = ctx.getText();
        Type type = TypeResolver.getFromValue(value);
        return new Value(type, value);
    }
}
