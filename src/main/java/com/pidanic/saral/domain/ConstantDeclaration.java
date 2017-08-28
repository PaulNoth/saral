package com.pidanic.saral.domain;

import com.pidanic.saral.domain.expression.Expression;

public class ConstantDeclaration extends VariableDeclaration {
    public ConstantDeclaration(String variableName, Expression expression) {
        super(variableName, expression);
    }
}
