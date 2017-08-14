package com.pidanic.saral.domain.expression;

import com.pidanic.saral.util.Type;

public abstract class BinaryExpression extends Expression {
    private Expression left;
    private Expression right;
    private Sign sign;

    public BinaryExpression(Type type, Sign sign, Expression left, Expression right) {
        super(type);
        if(left.getType() != right.getType()) {
            throw new UnsupportedOperationException("Binary expression should have both sides with the same type. Left side: "
                    + left.getType() + ", right side: " + right.getType());
        }
        this.left = left;
        this.right = right;
        this.sign = sign;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public Sign getSign() {
        return sign;
    }
}
