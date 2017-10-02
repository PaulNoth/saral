package com.pidanic.saral.domain.expression.string;

import com.pidanic.saral.domain.expression.BinaryExpression;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.BuiltInType;

public class Concatenation extends BinaryExpression {
    public Concatenation(Expression left, Expression right) {
        super(BuiltInType.STRING, StringOperationSign.CONCAT, left, right);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
