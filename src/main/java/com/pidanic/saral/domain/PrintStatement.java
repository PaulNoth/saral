package com.pidanic.saral.domain;

import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import com.pidanic.saral.scope.LocalVariable;

public class PrintStatement implements SimpleStatement {

    private LocalVariable variable;

    public PrintStatement(LocalVariable variable) {
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