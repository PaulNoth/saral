package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;

public class Multiplication extends ArithmeticExpression {
    public Multiplication(Expression left, Expression right) {
        super(ArithmeticSign.MOD, left, right);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
