package com.pidanic.saral.domain;

import java.util.List;

public class Statements {

    private List<Instruction> instructions;

    public Statements(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
}
