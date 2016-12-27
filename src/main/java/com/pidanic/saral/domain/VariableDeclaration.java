package com.pidanic.saral.domain;

import com.pidanic.saral.grammar.SaralLexer;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class VariableDeclaration implements Instruction, Opcodes {
    private Variable variable;

    public VariableDeclaration(Variable variable) {
        this.variable = variable;
    }

    @Override
    public void apply(MethodVisitor mv) {
        final int type = variable.getType();
        if(type == SaralLexer.NUMBER) {
            int val = Integer.valueOf(variable.getValue());
            mv.visitIntInsn(BIPUSH, val);
            mv.visitVarInsn(ISTORE, variable.getId());
        } else if(type == SaralLexer.STRING) {
            mv.visitLdcInsn(variable.getValue());
            mv.visitVarInsn(ASTORE, variable.getId());
        }
    }
}