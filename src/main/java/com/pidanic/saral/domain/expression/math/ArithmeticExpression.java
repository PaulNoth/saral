package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.BinaryExpression;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.Sign;

abstract class ArithmeticExpression extends BinaryExpression {

    ArithmeticExpression(Sign sign, Expression left, Expression right) {
        super(left.getType(), sign, left, right);
    }
}
