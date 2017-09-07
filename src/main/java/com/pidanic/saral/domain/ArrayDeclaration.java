package com.pidanic.saral.domain;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import com.pidanic.saral.util.Type;

public class ArrayDeclaration implements SimpleStatement {

    private Type type;
    private Expression length;

    public ArrayDeclaration(Type type, Expression arrayLength) {
        this.type = type;
        this.length = arrayLength;
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((SimpleStatementGenerator) generator).generate(this);
    }
}