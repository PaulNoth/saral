package com.pidanic.saral.domain.expression;

import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.util.Type;

public class VariableRef extends Expression {
    private final String varName;

    public VariableRef(String varName,Type type) {
        super(type);
        this.varName = varName;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
