import java.util.ArrayList;
import java.util.List;

public class Function {
    private String name;
    private List<FunctionParameter> arguments;
    private List<Statement> statements;
    private Type returnType;
    private Scope scope;

    public Function(Scope scope, String name, Type returnType, List<FunctionParameter> arguments, List<Statement> statements) {
        this.scope = scope;
        this.name = name;
        this.arguments = arguments;
        this.statements = statements;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public List<FunctionParameter> getArguments() {
        return new ArrayList<>(arguments);
    }

    public List<Statement> getStatements() {
        return new ArrayList<>(statements);
    }

    public Type getReturnType() {
        return returnType;
    }

    public Scope getScope() {
        return scope;
    }
}
