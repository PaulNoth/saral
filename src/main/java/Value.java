public class Value extends Expression {

    private final String value;

    public Value(Type type, String value) {
        super(type);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
