package com.pidanic.saral.domain;

import com.pidanic.saral.generator.StatementGenerator;
import org.objectweb.asm.Opcodes;

public class PrintVariable implements Statement, Opcodes {

    private Variable variable;

    public PrintVariable(Variable variable) {
        this.variable = variable;
    }

    @Override
    public void accept(StatementGenerator mv) {
        mv.generate(this);
    }

    public Variable getVariable() {
        return variable;
    }
}