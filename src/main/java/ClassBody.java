import java.util.List;

public class ClassBody {
    private List<ClassScopeInstruction> instructions;

    public ClassBody(List<ClassScopeInstruction> instructions) {
        this.instructions = instructions;
    }

    public List<ClassScopeInstruction> getInstructions() {
        return instructions;
    }
}
