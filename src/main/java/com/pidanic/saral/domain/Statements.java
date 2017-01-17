package com.pidanic.saral.domain;

import java.util.List;

public class Statements {

    private List<Statement> instructions;

    public Statements(List<Statement> instructions) {
        this.instructions = instructions;
    }

    public List<Statement> getInstructions() {
        return instructions;
    }
}
