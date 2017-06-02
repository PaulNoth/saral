package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.BinaryExpression;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;

public abstract class ArithmeticExpression extends BinaryExpression {

    ArithmeticExpression(Type type, Expression left, Expression right) {
        super(type, left, right);
        if(type != BuiltInType.INT) {
            throw new UnsupportedOperationException("Only numerical Arithmetic expression supported. Actual expression type: " + left.getType());
        }
    }
}
