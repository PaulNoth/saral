import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.List;

public class ClassGenerator {

    private static final int CLASS_VERSION = 52;

    private ClassWriter classWriter;

    public ClassGenerator() {
        this.classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
    }


    public ClassWriter generate(ClassDeclaration classDeclaration) {
        String className = classDeclaration.getClassName();
        classWriter.visit(CLASS_VERSION, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER
                , className, null, "java/lang/Object", null);
        List<Function> functions = classDeclaration.getMethods();
        functions.forEach(fun -> new MethodGenerator(classWriter).generate(fun));
        classWriter.visitEnd();
        return classWriter;
    }
}
