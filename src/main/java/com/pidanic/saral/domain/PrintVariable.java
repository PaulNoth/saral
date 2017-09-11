package com.pidanic.saral.domain;

import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;

public class PrintVariable implements SimpleStatement {

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