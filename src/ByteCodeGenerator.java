import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.util.Queue;

public class ByteCodeGenerator implements Opcodes{
    public byte[] generateByteCode(Queue<Instruction> instructionQueue, String name) {
        ClassWriter cw = new ClassWriter(0);
        MethodVisitor mw;
        // version, access, name, signature, base class, interfaces
        cw.visit(52, ACC_PUBLIC + ACC_SUPER, name, null, "java/lang/Object", null);
        {
            // declare static void main
            mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            long localVariablesCount = instructionQueue.stream()
                    .filter(instruction -> instruction instanceof VariableDeclaration).count();
            int maxStack = 100; //
            for(Instruction ins : instructionQueue) {
                ins.apply(mw);
            }
            mw.visitInsn(RETURN);
            mw.visitMaxs(maxStack, (int) localVariablesCount);
            mw.visitEnd();
        }
        cw.visitEnd();
        return cw.toByteArray();
    }
}
