package com.pidanic.saral.domain;

import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;

public class ReadStatement implements SimpleStatement {

    private LocalVariable variable;

    public ReadStatement(LocalVariable variable) {
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