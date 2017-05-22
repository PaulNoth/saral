package com.pidanic.saral.domain;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ReturnStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;

public class ReturnStatement implements Statement {

    private Expression expression;

    public ReturnStatement(Expression variable) {
        this.expression = variable;
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((ReturnStatementGenerator) generator).generate(this);
    }

    public Expression getExpression() {
        return expression;
    }
}
