import java.util.Queue;

public class ClassDeclaration {

    private Queue<ClassScopeInstruction> instructions;
    private String className;

    public ClassDeclaration(Queue<ClassScopeInstruction> instructions, String className) {
        this.instructions = instructions;
        this.className = className;
    }

    public Queue<ClassScopeInstruction> getInstructions() {
        return instructions;
    }

    public String getClassName() {
        return className;
    }
}
