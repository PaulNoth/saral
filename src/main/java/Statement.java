public interface Statement extends Node {
    void accept(StatementGenerator generator);
}
