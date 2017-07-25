package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.TypeResolver;

public class CompareExpression extends BinaryExpression {

    public CompareExpression(Sign sign, Expression left, Expression right) {
        super(BuiltInType.BOOLEAN, sign, left, right);
        if(!TypeResolver.isInteger(left.getType()) || !TypeResolver.isInteger(right.getType())) {
            throw new UnsupportedOperationException("Currently there are only numerical comparisons allowed: "
                    + left.getType() + " vs. " + right.getType());
        }
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
