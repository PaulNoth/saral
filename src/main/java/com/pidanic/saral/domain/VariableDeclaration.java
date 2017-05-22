package com.pidanic.saral.domain;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;

public class VariableDeclaration implements SimpleStatement {
    private String name;
    private Expression expression;

    public VariableDeclaration(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void accept(StatementGenerator statementGenerator) {
        ((SimpleStatementGenerator) statementGenerator).generate(this);
    }

    public String getName() {
        return name;
    }

    public Expression getExpression() {
        return expression;
    }
}