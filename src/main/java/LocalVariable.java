public class LocalVariable {
    private final String name;
    private final Type type;

    public LocalVariable(String name, Type type) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}