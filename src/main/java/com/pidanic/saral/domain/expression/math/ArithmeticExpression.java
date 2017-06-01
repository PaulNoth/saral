package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;

public abstract class ArithmeticExpression extends Expression {
    private Expression left;
    private Expression right;

    ArithmeticExpression(Type type, Expression left, Expression right) {
        super(type);
        if(type != BuiltInType.INT) {
            throw new UnsupportedOperationException("Only numerical Arithmetic expression supported. Actual expression type: " + left.getType());
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
