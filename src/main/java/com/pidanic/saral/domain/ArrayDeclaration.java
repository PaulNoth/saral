package com.pidanic.saral.domain;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.cast.CastExpression;;
import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;

public class ArrayDeclaration implements SimpleStatement {

    private Type type;
    private Expression length;
    private String name;

    public ArrayDeclaration(String name, Type type, Expression arrayLength) {
        this.type = type;
        this.length = arrayLength;
        this.name = name;
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((SimpleStatementGenerator) generator).generate(this);
    }

    public Type getType() {
        return type;
    }

    public Expression getLength() {
        return new CastExpression(BuiltInType.INT, length);
    }

    public String getName() {
        return name;
    }
}