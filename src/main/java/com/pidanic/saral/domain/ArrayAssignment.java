package com.pidanic.saral.domain;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;

import java.util.Optional;

public class ArrayAssignment extends Assignment {
    private Expression index;

    public ArrayAssignment(String name, Expression index, Expression expression) {
        super(name, expression);
        this.index = index;
    }

    @Override
    public void accept(StatementGenerator statementGenerator) {
        ((SimpleStatementGenerator) statementGenerator).generate(this);
    }

    public Expression getIndex() {
        return index;
    }
}
