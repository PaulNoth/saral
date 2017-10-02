package com.pidanic.saral.domain.expression;

import com.pidanic.saral.domain.expression.cast.CastExpression;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;

public abstract class BinaryExpression extends Expression {
    private Expression left;
    private Expression right;
    private Sign sign;

    public BinaryExpression(Type type, Sign sign, Expression left, Expression right) {
        super(type);
        Type leftType = left.type();
        if(leftType == BuiltInType.VOID) {
            throw new UnsupportedOperationException("Only numerical, string and boolean expressions supported. Actual expression type. Left: "
                    + left.type() + ", right: " + right.type());
        }
        this.sign = sign;
        this.left = left;
        this.right = right;
        convertIfCast(type, left, right);
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

    private void convertIfCast(Type type, Expression left, Expression right) {
        if(type == BuiltInType.DOUBLE) {
            if(left.type() == BuiltInType.LONG) {
                this.left = new CastExpression(BuiltInType.DOUBLE, left);
            }
            if(right.type() == BuiltInType.LONG) {
                this.left = new CastExpression(BuiltInType.DOUBLE, right);
            }
        }
        if(left.type() == BuiltInType.LONG && right.type() == BuiltInType.DOUBLE) {
            this.left = new CastExpression(BuiltInType.DOUBLE, left);
        }
        if(right.type() == BuiltInType.LONG && left.type() == BuiltInType.DOUBLE) {
            this.left = new CastExpression(BuiltInType.DOUBLE, right);
        }

    }
}
