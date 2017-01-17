package com.pidanic.saral.generator;

import com.pidanic.saral.domain.Statements;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class ByteCodeGenerator {
    private static final int CLASS_VERSION = 52;

    public byte[] generateByteCode(Statements compilationUnit, String name) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);

        cw.visit(CLASS_VERSION, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, name, null, "java/lang/Object", null);

        StatementsGenerator statementsGenerator = new StatementsGenerator(cw);
        return statementsGenerator.generate(compilationUnit).toByteArray();
    }
}
