import org.objectweb.asm.Opcodes;

public class ByteCodeGenerator implements Opcodes {
    public byte[] generateByteCode(CompilationUnit compilationUnit) {
        ClassDeclaration classDeclaration = compilationUnit.getClassDeclaration();
        return new ClassGenerator().generate(classDeclaration).toByteArray();
    }
}
