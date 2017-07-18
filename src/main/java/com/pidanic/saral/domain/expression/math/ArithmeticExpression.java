package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;

abstract class ArithmeticExpression extends BinaryExpression {

    ArithmeticExpression(Sign sign, Expression left, Expression right) {
        super(left.getType(), sign, left, right);
        Type leftType = left.getType();
        if(leftType == BuiltInType.STRING || leftType == BuiltInType.VOID) {
            throw new UnsupportedOperationException("Only numerical Arithmetic expression supported. Actual expression type. Left: "
                    + left.getType() + ", right: " + right.getType());
        }
    }
}
