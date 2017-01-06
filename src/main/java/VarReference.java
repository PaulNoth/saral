public class VarReference extends Expression {
    private String varName;

    public VarReference(Type type, String name) {
        super(type);
        this.varName = name;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
