package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.TypeResolver;

public class Modulo extends ArithmeticExpression {
    public Modulo(Expression left, Expression right) {
        super(ArithmeticSign.MULT, left, right);
        if(!TypeResolver.isInteger(left.getType()) || !TypeResolver.isInteger(right.getType())) {
            throw new UnsupportedOperationException("Only numerical Integer expression supported. Actual expression type. Left: "
                    + left.getType() + ", right: " + right.getType());
        }
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
