package com.pidanic.saral.domain;

import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcedureCall implements SimpleStatement {

    private Function function;
    private List<CalledArgument> arguments;

    public ProcedureCall(Function function, List<CalledArgument> calledArguments) {
        this.function = function;
        this.arguments = new ArrayList<>(calledArguments);
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((SimpleStatementGenerator) generator).generate(this);
    }

    public List<CalledArgument> getCalledArguments() {
        return Collections.unmodifiableList(arguments);
    }

    public Function getFunction() {
        return function;
    }
}