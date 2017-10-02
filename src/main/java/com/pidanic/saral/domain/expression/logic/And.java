package com.pidanic.saral.domain.expression.logic;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.TypeResolver;

public class And extends LogicExpression {
    public And(Expression left, Expression right) {
        super(LogicSign.AND, left, right);
        if(!TypeResolver.isBoolean(left.type()) || !TypeResolver.isBoolean(right.type())) {
            throw new UnsupportedOperationException("Only logical expression supported. Actual expression type. Left: "
                    + left.type() + ", right: " + right.type());
        }
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
