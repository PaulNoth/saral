package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;

public class Substraction extends ArithmeticExpression {
    public Substraction(Expression left, Expression right) {
        super(ArithmeticSign.SUB, left, right);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
