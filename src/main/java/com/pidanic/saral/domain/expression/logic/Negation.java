package com.pidanic.saral.domain.expression.logic;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.UnaryExpression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.BuiltInType;

public class Negation extends UnaryExpression {

    public Negation(Expression expression) {
        super(BuiltInType.BOOLEAN, LogicSign.NOT, expression);
        if(expression.getType() != BuiltInType.BOOLEAN) {
            throw new UnsupportedOperationException("Only numerical Logical expression supported. Actual expression type. Expression: "
                    + expression.getType());
        }
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
