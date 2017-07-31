package com.pidanic.saral.domain.expression.logic;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.BinaryExpression;
import com.pidanic.saral.domain.expression.Sign;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.TypeResolver;

public abstract class LogicExpression extends BinaryExpression {

    public LogicExpression(Sign sign, Expression left, Expression right) {
        super(BuiltInType.BOOLEAN, sign, left, right);
        if(!TypeResolver.isBoolean(left.getType()) || !TypeResolver.isBoolean(right.getType())) {
            throw new UnsupportedOperationException("Currently there are only logical comparisons allowed: "
                    + left.getType() + " vs. " + right.getType());
        }
    }
}
