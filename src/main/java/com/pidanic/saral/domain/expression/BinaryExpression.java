package com.pidanic.saral.domain.expression;

import com.pidanic.saral.domain.expression.cast.CastExpression;
import com.pidanic.saral.exception.IncompatibleExpressionTypeException;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;

public abstract class BinaryExpression extends Expression {
    private Expression left;
    private Expression right;
    private Sign sign;

    public BinaryExpression(Type type, Sign sign, Expression left, Expression right) {
        super(type);
        Type leftType = left.getType();
        if(leftType == BuiltInType.STRING || leftType == BuiltInType.VOID) {
            throw new UnsupportedOperationException("Only numerical expression supported. Actual expression type. Left: "
                    + left.getType() + ", right: " + right.getType());
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
        if(type == BuiltInType.LONG && (left.getType() == BuiltInType.DOUBLE || right.getType() == BuiltInType.DOUBLE)) {
            throw new IncompatibleExpressionTypeException(type, left.getType(), right.getType());
        }
        if(type == BuiltInType.DOUBLE) {
            if(left.getType() == BuiltInType.LONG) {
                this.left = new CastExpression(BuiltInType.DOUBLE, left);
            }
            if(right.getType() == BuiltInType.LONG) {
                this.left = new CastExpression(BuiltInType.DOUBLE, right);
            }
        }
        if(left.getType() == BuiltInType.LONG && right.getType() == BuiltInType.DOUBLE) {
            this.left = new CastExpression(BuiltInType.DOUBLE, left);
        }
        if(right.getType() == BuiltInType.LONG && left.getType() == BuiltInType.DOUBLE) {
            this.left = new CastExpression(BuiltInType.DOUBLE, right);
        }

    }
}
