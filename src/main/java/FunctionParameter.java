public class FunctionParameter extends Expression {
    private String name;

    public FunctionParameter(String name, Type type) {
        super(type);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
