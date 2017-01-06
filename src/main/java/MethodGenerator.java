import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Collection;

public class MethodGenerator {

    private ClassWriter classWriter;

    public MethodGenerator(ClassWriter classWriter) {
        this.classWriter = classWriter;
    }

    public void generate(Function function) {
        Scope scope = function.getScope();
        String name = function.getName();
        String descriptor = DescriptorFactory.getMethodDescriptor(function);
        Collection<Statement> statements = function.getStatements();
        int access = Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC;
        MethodVisitor mw = classWriter.visitMethod(access, name, descriptor, null, null);
        mw.visitCode();

        StatementGenerator statementGenerator = new StatementGenerator(mw, scope);
        statements.forEach(statement -> statement.accept(statementGenerator));
        mw.visitInsn(Opcodes.RETURN);
        mw.visitMaxs(-1, -1);
        mw.visitEnd();
    }
}
