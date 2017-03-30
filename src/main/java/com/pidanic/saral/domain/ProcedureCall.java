package com.pidanic.saral.domain;

import com.pidanic.saral.generator.SimpleStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;

import java.util.ArrayList;
import java.util.List;

public class ProcedureCall implements SimpleStatement {

    private Procedure procedure;
    private List<CalledArgument> arguments;

    public ProcedureCall(Procedure procedure, List<CalledArgument> calledArguments) {
        this.procedure = procedure;
        this.arguments = new ArrayList<>(calledArguments);
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((SimpleStatementGenerator) generator).generate(this);
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public List<CalledArgument> getCalledArguments() {
        return arguments;
    }
}
