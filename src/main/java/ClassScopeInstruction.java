import org.objectweb.asm.MethodVisitor;

public interface ClassScopeInstruction {
    void apply(MethodVisitor methodVisitor);
}