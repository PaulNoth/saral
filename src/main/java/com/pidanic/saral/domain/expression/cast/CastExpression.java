package com.pidanic.saral.domain.expression.cast;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.UnaryExpression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;

public class CastExpression extends UnaryExpression {
    public CastExpression(Type castingType, Expression expression) {
        super(castingType, getSign(castingType, expression.getType()), expression);
    }
    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    private static CastingSign getSign(Type castingType, Type expressionType) {
        if(castingType == BuiltInType.DOUBLE) {
            return CastingSign.LONG_TO_DOUBLE;
        }
        return CastingSign.LONG_TO_DOUBLE;
    }
}
