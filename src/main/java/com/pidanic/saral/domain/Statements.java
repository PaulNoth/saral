package com.pidanic.saral.domain;

import com.pidanic.saral.generator.StatementsGenerator;
import com.pidanic.saral.scope.Scope;

import java.util.List;

public class Statements {

    private List<Statement> instructions;
    private Scope scope;

    public Statements(Scope scope, List<Statement> instructions) {
        this.instructions = instructions;
        this.scope = scope;
    }

    public List<Statement> getStatements() {
        return instructions;
    }

    public void accept(StatementsGenerator generator) {
        generator.generate(this);
    }

    public Scope getScope() {
        return scope;
    }
}
