package com.pidanic.saral.domain;

import com.pidanic.saral.generator.BlockStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Procedure extends BlockStatementImpl {
    private String name;
    private List<Argument> arguments;
    private List<SimpleStatement> simpleStatements;
    private Type returnType = BuiltInType.VOID;

    public Procedure(Scope scope, String name, List<Argument> arguments, List<SimpleStatement> simpleStatements) {
        super(scope);
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

    public Type getReturnType() {
        return returnType;
    }
}
