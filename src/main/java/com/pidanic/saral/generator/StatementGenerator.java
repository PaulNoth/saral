package com.pidanic.saral.generator;

import com.pidanic.saral.domain.PrintVariable;
import com.pidanic.saral.domain.Variable;
import com.pidanic.saral.domain.VariableDeclaration;
import com.pidanic.saral.grammar.SaralLexer;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class StatementGenerator {

    private MethodVisitor methodVisitor;

    public StatementGenerator(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public void generate(PrintVariable instruction) {
        final Variable variable = instruction.getVariable();
        final int type = variable.getType();
        final int id = variable.getId();
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        if (type == SaralLexer.NUMBER) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, id);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                    "java/io/PrintStream", "println", "(I)V", false);
        } else if (type == SaralLexer.STRING) {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, id);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                    "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        }
    }

    public void generate(VariableDeclaration variableDeclaration) {
        final Variable variable = variableDeclaration.getVariable();
        final int type = variable.getType();
        if(type == SaralLexer.NUMBER) {
            int val = Integer.valueOf(variable.getValue());
            methodVisitor.visitIntInsn(Opcodes.BIPUSH, val);
            methodVisitor.visitVarInsn(Opcodes.ISTORE, variable.getId());
        } else if(type == SaralLexer.STRING) {
            methodVisitor.visitLdcInsn(variable.getValue());
            methodVisitor.visitVarInsn(Opcodes.ASTORE, variable.getId());
        }
    }
}
