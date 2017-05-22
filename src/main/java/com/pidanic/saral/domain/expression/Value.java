package com.pidanic.saral.domain.expression;

import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.Type;

public class Value extends Expression {
    private String value;

    public Value(Type type, String value) {
        super(type);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
