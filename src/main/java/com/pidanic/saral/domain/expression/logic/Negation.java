package com.pidanic.saral.domain.expression.logic;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.UnaryExpression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.BuiltInType;

public class Negation extends UnaryExpression {

    public Negation(Expression expression) {
        super(BuiltInType.BOOLEAN, LogicSign.NOT, expression);
        if(expression.type() != BuiltInType.BOOLEAN) {
            throw new UnsupportedOperationException("Only Logical expression supported. Actual expression type. Expression: "
                    + expression.type());
        }
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
