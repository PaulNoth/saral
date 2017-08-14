package com.pidanic.saral.domain.expression;

import com.pidanic.saral.util.Type;

public abstract class UnaryExpression extends Expression {
    private Expression expression;
    private Sign sign;

    public UnaryExpression(Type type, Sign sign, Expression left) {
        super(type);
        this.expression = left;
        this.sign = sign;
    }

    public Expression getExpression() {
        return expression;
    }

    public Sign getSign() {
        return sign;
    }
}
