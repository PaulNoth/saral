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
        final Type leftType = left.type();
        final Type rightType = right.type();
        if(type == BuiltInType.DOUBLE) {
            if(leftType == BuiltInType.LONG) {
                this.left = new CastExpression(BuiltInType.DOUBLE, left);
            }
            if(rightType == BuiltInType.LONG) {
                this.left = new CastExpression(BuiltInType.DOUBLE, right);
            }
        } else if(leftType == BuiltInType.LONG && right.type() == BuiltInType.DOUBLE) {
            this.left = new CastExpression(BuiltInType.DOUBLE, left);
        } else if(rightType == BuiltInType.LONG && left.type() == BuiltInType.DOUBLE) {
            this.left = new CastExpression(BuiltInType.DOUBLE, right);
        } else if(leftType == BuiltInType.CHAR && right.type() == BuiltInType.LONG) {
            this.right = new CastExpression(BuiltInType.INT, right);
        } else if(rightType == BuiltInType.CHAR && left.type() == BuiltInType.LONG) {
            this.left = new CastExpression(BuiltInType.INT, left);
        }
    }
}
