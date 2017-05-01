package com.pidanic.saral.domain;

import com.pidanic.saral.generator.BlockStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Function extends BlockStatementImpl {
    private String name;
    private List<Argument> arguments;
    private List<SimpleStatement> simpleStatements;
    private Optional<ReturnStatement> retStatement;
    private Type returnType;

    public Function(Scope scope, String name, List<Argument> arguments, List<SimpleStatement> simpleStatements, Type returnType, ReturnStatement retStatement) {
        super(scope);
        this.name = name;
        this.arguments = new ArrayList<>(arguments);
        this.simpleStatements = new ArrayList<>(simpleStatements);
        this.returnType = returnType;
        this.retStatement = Optional.ofNullable(retStatement);
    }

    Function(Scope scope, String name, List<Argument> arguments, List<SimpleStatement> simpleStatements, Type returnType) {
        this(scope, name, arguments, simpleStatements, returnType, null);
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

    public Optional<ReturnStatement> getReturnStatement() {
        return retStatement;
    }
}
