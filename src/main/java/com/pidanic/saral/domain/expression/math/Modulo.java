package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.TypeResolver;

public class Modulo extends ArithmeticExpression {
    public Modulo(Expression left, Expression right) {
        super(ArithmeticSign.MOD, left, right);
        if(!TypeResolver.isInteger(left.type()) || !TypeResolver.isInteger(right.type())) {
            throw new UnsupportedOperationException("Only numerical Integer expression supported. Actual expression type. Left: "
                    + left.type() + ", right: " + right.type());
        }
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
