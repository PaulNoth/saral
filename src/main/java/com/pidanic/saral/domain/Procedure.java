package com.pidanic.saral.domain;

import com.pidanic.saral.generator.BlockStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import com.pidanic.saral.scope.Scope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Procedure implements BlockStatement {
    private Scope scope;
    private String name;
    private List<Argument> arguments;
    private List<SimpleStatement> simpleStatements;

    public Procedure(Scope scope, String name, List<Argument> arguments, List<SimpleStatement> simpleStatements) {
        this.scope = new Scope(scope);
        this.name = name;
        this.arguments = new ArrayList<>(arguments);
        this.simpleStatements = new ArrayList<>(simpleStatements);
    }

    public String getName() {
        return name;
    }

    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    public List<SimpleStatement> getSimpleStatements() {
        return Collections.unmodifiableList(simpleStatements);
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((BlockStatementGenerator) generator).generate(this);
    }

    public Scope getScope() {
        return scope;
    }
}
