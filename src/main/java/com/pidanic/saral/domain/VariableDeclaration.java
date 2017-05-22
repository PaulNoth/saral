package com.pidanic.saral.domain;

import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;

public class VariableDeclaration implements SimpleStatement {
    private String name;
    private String value;

    public VariableDeclaration(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void accept(StatementGenerator statementGenerator) {
        ((SimpleStatementGenerator) statementGenerator).generate(this);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}