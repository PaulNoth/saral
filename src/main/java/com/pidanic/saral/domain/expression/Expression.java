package com.pidanic.saral.domain.expression;

import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.Type;

public abstract class Expression {
    private Type type;

    public Expression(Type type) {
        this.type = type;
    }

    public Type type() {
        return type;
    }

    public abstract void accept(ExpressionGenerator generator);
}
