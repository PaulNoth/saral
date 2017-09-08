package com.pidanic.saral.domain.expression;

import com.pidanic.saral.domain.expression.cast.CastExpression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;

public class ArrayRef extends Expression {
    private final String varName;
    private final Expression index;

    public ArrayRef(String varName, Type type, Expression index) {
        super(type);
        this.varName = varName;
        this.index = index;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    public Expression getIndex() {
        return new CastExpression(BuiltInType.INT, index);
    }
}
