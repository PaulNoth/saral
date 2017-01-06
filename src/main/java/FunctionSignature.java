import java.util.Collections;
import java.util.List;

public class FunctionSignature {
    private String name;
    private List<FunctionParameter> arguments;
    private Type returnType;

    public FunctionSignature(String name, List<FunctionParameter> arguments, Type returnType) {
        this.name = name;
        this.arguments = arguments;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<FunctionParameter> getArguments() {
        return Collections.unmodifiableList(arguments);
    }
}
