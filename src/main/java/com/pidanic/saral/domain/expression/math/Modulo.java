package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.BuiltInType;

public class Modulo extends ArithmeticExpression {
    public Modulo(Expression left, Expression right) {
        super(ArithmeticSign.MULT, left, right);
        if(left.getType() != BuiltInType.INT && left.getType() != BuiltInType.LONG) {
            throw new UnsupportedOperationException("Only numerical Integer expression supported. Actual expression type. Left: "
                    + left.getType() + ", right: " + right.getType());
        }
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
