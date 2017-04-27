package com.pidanic.saral.domain;

import com.pidanic.saral.generator.ReturnStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;

public class ReturnStatement implements Statement {

    private LocalVariable returnVariable;

    public ReturnStatement(LocalVariable variable) {
        this.returnVariable = variable;
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((ReturnStatementGenerator) generator).generate(this);
    }

    public LocalVariable getReturnVariable() {
        return returnVariable;
    }
}
