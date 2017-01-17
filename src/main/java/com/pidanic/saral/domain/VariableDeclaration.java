package com.pidanic.saral.domain;

import com.pidanic.saral.generator.StatementGenerator;
import org.objectweb.asm.Opcodes;

public class VariableDeclaration implements Statement, Opcodes {
    private Variable variable;

    public VariableDeclaration(Variable variable) {
        this.variable = variable;
    }

    @Override
    public void accept(StatementGenerator statementGenerator) {
        statementGenerator.generate(this);
    }

    public Variable getVariable() {
        return variable;
    }
}