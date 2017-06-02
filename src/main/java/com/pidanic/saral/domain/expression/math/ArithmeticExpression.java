package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.BuiltInType;

public class ArithmeticExpression extends BinaryExpression {

    public ArithmeticExpression(Sign sign, Expression left, Expression right) {
        super(BuiltInType.INT, sign, left, right);
        if(left.getType() != BuiltInType.INT || right.getType() != BuiltInType.INT) {
            throw new UnsupportedOperationException("Only numerical Arithmetic expression supported. Actual expression type. Left: "
                    + left.getType() + ", right: " + right.getType());
        }
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
