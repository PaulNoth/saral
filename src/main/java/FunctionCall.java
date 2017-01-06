import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class FunctionCall extends Expression implements Statement {
    private Type owner;
    private FunctionSignature signature;
    private Collection<Expression> parameters;

    public FunctionCall(FunctionSignature signature, Collection<Expression> parameters, Type owner) {
        super(signature.getReturnType());
        this.signature = signature;
        this.parameters = parameters;
        this.owner = owner;
    }

    public String getFunctionName() {
        return signature.getName();
    }

    public Collection<Expression> getParameters() {
        return Collections.unmodifiableCollection(parameters);
    }

    public Optional<Type> getOwner() {
        return Optional.ofNullable(owner);
    }

    public FunctionSignature getSignature() {
        return signature;
    }

    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
