package com.pidanic.saral.domain;

import com.pidanic.saral.generator.InitGenerator;
import com.pidanic.saral.scope.Scope;

import java.util.List;

public class Init {
    private List<Statement> instructions;
    private Scope scope;

    public Init(Scope scope, List<Statement> instructions) {
        this.instructions = instructions;
        this.scope = scope;
    }

    public List<Statement> getStatements() {
        return instructions;
    }

    public void accept(InitGenerator generator) {
        generator.generate(this);
    }

    public Scope getScope() {
        return scope;
    }
}
