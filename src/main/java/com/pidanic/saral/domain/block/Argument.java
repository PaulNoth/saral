package com.pidanic.saral.domain.block;

import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.util.Type;

public class Argument {
    private final Type type;
    private final String name;

    public Argument(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public void accept(SimpleStatementGenerator expressionGenerator, String localVariableName) {
        expressionGenerator.generate(this, localVariableName);
    }

    public void accept(ExpressionGenerator expressionGenerator, String localVariableName) {
        expressionGenerator.generate(this, localVariableName);
    }

}
