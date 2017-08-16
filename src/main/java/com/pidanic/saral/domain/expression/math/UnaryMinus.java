package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.UnaryExpression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.TypeResolver;

public class UnaryMinus extends UnaryExpression {
    public UnaryMinus(Expression expression) {
        super(expression.getType(), ArithmeticSign.UNARY_MINUS, expression);
        if(TypeResolver.isNumber(expression.getType())) {
            throw new UnsupportedOperationException("Only numerical Logical expression supported. Actual expression type. Expression: "
                    + expression.getType());
        }
    }
    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
