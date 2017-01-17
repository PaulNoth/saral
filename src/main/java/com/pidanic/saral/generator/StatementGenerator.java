package com.pidanic.saral.generator;

import com.pidanic.saral.domain.PrintVariable;
import com.pidanic.saral.domain.Variable;
import com.pidanic.saral.domain.VariableDeclaration;
import com.pidanic.saral.grammar.SaralLexer;
import com.pidanic.saral.scope.Scope;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class StatementGenerator {

    private MethodVisitor methodVisitor;
    private Scope scope;

    public StatementGenerator(MethodVisitor methodVisitor, Scope scope) {
        this.methodVisitor = methodVisitor;
        this.scope = scope;
    }

    public void generate(PrintVariable instruction) {
        final Variable variable = instruction.getVariable();
        final int type = variable.getType();
        final int variableId = scope.getVariableIndex(variable.getName());
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        if (type == SaralLexer.NUMBER) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, variableId);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                    "java/io/PrintStream", "println", "(I)V", false);
        } else if (type == SaralLexer.STRING) {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, variableId);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                    "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        }
    }

    public void generate(VariableDeclaration variableDeclaration) {
        final Variable variable = variableDeclaration.getVariable();
        final int type = variable.getType();
        final int variableId = scope.getVariableIndex(variable.getName());
        if(type == SaralLexer.NUMBER) {
            int val = Integer.valueOf(variable.getValue());
            methodVisitor.visitIntInsn(Opcodes.BIPUSH, val);
            methodVisitor.visitVarInsn(Opcodes.ISTORE, variableId);
        } else if(type == SaralLexer.STRING) {
            methodVisitor.visitLdcInsn(variable.getValue());
            methodVisitor.visitVarInsn(Opcodes.ASTORE, variableId);
        }
    }
}
