package com.pidanic.saral.domain.expression.compare;

import com.pidanic.saral.domain.expression.BinaryExpression;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.CompareSign;

public class CompareExpression extends BinaryExpression {

    private CompareSign sign;

    public CompareExpression(CompareSign sign, Expression left, Expression right) {
        super(BuiltInType.BOOLEAN, left, right);
        this.sign = sign;
        if(left.getType() != BuiltInType.INT || right.getType() != BuiltInType.INT) {
            throw new UnsupportedOperationException("Currently there are only numerical comparisons allowed: "
                    + left.getType() + " vs. " + right.getType());
        }
    }

    public CompareSign getCompareSign() {
        return sign;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
