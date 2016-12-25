import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;

public class ClassGenerator {

    public ClassWriter generate(ClassDeclaration classDeclaration) {
        ClassWriter cw = new ClassWriter(0);
        MethodVisitor mw;
        List<ClassScopeInstruction> instructionQueue = classDeclaration.getClassBody().getInstructions();
        // version, access, name, signature, base class, interfaces
        cw.visit(52, ACC_PUBLIC + ACC_SUPER, classDeclaration.getClassName(), null, "java/lang/Object", null);
        {
            // declare static void main
            mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            long localVariablesCount = instructionQueue.stream()
                    .filter(instruction -> instruction instanceof VariableDeclaration).count();
            int maxStack = 100; //
            for(ClassScopeInstruction ins : instructionQueue) {
                ins.apply(mw);
            }
            mw.visitInsn(RETURN);
            mw.visitMaxs(maxStack, (int) localVariablesCount);
            mw.visitEnd();
        }
        cw.visitEnd();
        return cw;
    }
}
