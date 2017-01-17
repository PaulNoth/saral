package com.pidanic.saral.generator;

import com.pidanic.saral.domain.Statements;
import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.VariableDeclaration;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public class ByteCodeGenerator {
    private static final int CLASS_VERSION = 52;

    public byte[] generateByteCode(Statements compilationUnit, String name) {
        ClassWriter cw = new ClassWriter(0);
        MethodVisitor mw;
        cw.visit(CLASS_VERSION, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, name, null, "java/lang/Object", null);

        // declare static void main
        mw = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        StatementGenerator statementGenerator = new StatementGenerator(mw);
        List<Statement> instructionQueue = compilationUnit.getInstructions();
        long localVariablesCount = instructionQueue.stream()
                .filter(instruction -> instruction instanceof VariableDeclaration).count();
        int maxStack = 100; //

        for(Statement ins : instructionQueue) {
            ins.accept(statementGenerator);
        }
        mw.visitInsn(Opcodes.RETURN);
        mw.visitMaxs(maxStack, (int) localVariablesCount);
        mw.visitEnd();

        cw.visitEnd();
        return cw.toByteArray();
    }
}
