package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.BinaryExpression;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.Sign;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;

abstract class ArithmeticExpression extends BinaryExpression {

    ArithmeticExpression(Sign sign, Expression left, Expression right) {
        super(calculateExpressionType(left.type(), right.type()), sign, left, right);
    }

    private static Type calculateExpressionType(Type leftType, Type rightType) {
        if(leftType == BuiltInType.LONG && rightType == BuiltInType.DOUBLE) {
            return BuiltInType.DOUBLE;
        }
        if(leftType == BuiltInType.DOUBLE && rightType == BuiltInType.LONG) {
            return BuiltInType.DOUBLE;
        }
        return leftType;
    }
}
