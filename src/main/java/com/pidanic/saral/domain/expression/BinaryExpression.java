package com.pidanic.saral.domain.expression;

import com.pidanic.saral.util.Type;

public abstract class BinaryExpression extends Expression {
    private Expression left;
    private Expression right;

    public BinaryExpression(Type type, Expression left, Expression right) {
        super(type);
        if(left.getType() != right.getType()) {
            throw new UnsupportedOperationException("Binary expression should have both sides with the same type. Left side: "
                    + left.getType() + ", right side: " + right.getType());
        }
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}
