package com.pidanic.saral.domain;

import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import org.objectweb.asm.Opcodes;

public class PrintVariable implements SimpleStatement, Opcodes {

    private LocalVariable variable;

    public PrintVariable(LocalVariable variable) {
        this.variable = variable;
    }

    @Override
    public void accept(StatementGenerator mv) {
        ((SimpleStatementGenerator) mv).generate(this);
    }

    public LocalVariable getVariable() {
        return variable;
    }
}