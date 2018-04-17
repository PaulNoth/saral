package com.pidanic.saral.domain.block;

import com.pidanic.saral.domain.ReturnStatement;
import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.generator.CallableStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Function extends CallableStatement {
    private String name;
    private List<Argument> arguments;
    private List<Statement> statements;
    private ReturnStatement retStatement;
    private Type returnType;

    public Function(Scope scope, String name, List<Argument> arguments, List<Statement> statements, Type returnType, ReturnStatement retStatement) {
        super(scope);
        this.name = name;
        this.arguments = new ArrayList<>(arguments);
        this.statements = new ArrayList<>(statements);
        this.returnType = returnType;
        this.retStatement = retStatement;
    }

    Function(Scope scope, String name, List<Argument> arguments, List<Statement> statements, Type returnType) {
        this(scope, name, arguments, statements, returnType, null);
    }

    public String getName() {
        return name;
    }

    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    public List<Statement> getStatements() {
        return Collections.unmodifiableList(statements);
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((CallableStatementGenerator) generator).generate(this);
    }

    public Type getReturnType() {
        return returnType;
    }

    public Optional<ReturnStatement> getReturnStatement() {
        return Optional.ofNullable(retStatement);
    }

    public void setStatements(List<Statement> newStatements) {
        this.statements = newStatements;
    }

    public void setRetStatement(ReturnStatement newStatements) {
        this.retStatement = newStatements;
    }
}
