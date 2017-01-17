package com.pidanic.saral.scope;

import com.pidanic.saral.domain.Variable;
import com.pidanic.saral.exception.VariableNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scope {

    private List<Variable> variables;

    public Scope() {
        variables = new ArrayList<>();
    }

    public List<Variable> getVariables() {
        return Collections.unmodifiableList(variables);
    }

    public void addVariable(Variable localVariable) {
        variables.add(localVariable);
    }

    public Variable getLocalVariable(String varName) {
        return variables.stream()
                .filter(variable -> variable.getName().equals(varName))
                .findFirst()
                .orElseThrow(() -> new VariableNotFoundException(this, varName));
    }

    public int getVariableIndex(String varName) {
        Variable localVariable = getLocalVariable(varName);
        return variables.indexOf(localVariable);
    }
}
