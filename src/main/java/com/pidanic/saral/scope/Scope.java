package com.pidanic.saral.scope;

import com.pidanic.saral.domain.LocalVariable;
import com.pidanic.saral.domain.Procedure;
import com.pidanic.saral.domain.Variable;
import com.pidanic.saral.exception.VariableNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scope {

    private List<LocalVariable> localVariables;
    private List<Procedure> procedures;

    public Scope() {
        localVariables = new ArrayList<>();
        procedures = new ArrayList<>();
    }

    public Scope(Scope scope) {
        localVariables = new ArrayList<>(scope.localVariables);
        procedures = new ArrayList<>(scope.procedures);
    }

    public List<LocalVariable> getLocalVariables() {
        return Collections.unmodifiableList(localVariables);
    }

    public List<Procedure> getProcedures() {
        return Collections.unmodifiableList(procedures);
    }

    public void addProcedure(Procedure procedure) {
        procedures.add(procedure);
    }

    public void addVariable(LocalVariable localVariable) {
        localVariables.add(localVariable);
    }

    public LocalVariable getLocalVariable(String varName) {
        return localVariables.stream()
                .filter(variable -> variable.getName().equals(varName))
                .findFirst()
                .orElseThrow(() -> new VariableNotFoundException(this, varName));
    }

    public int getVariableIndex(String varName) {
        LocalVariable localVariable = getLocalVariable(varName);
        return localVariables.indexOf(localVariable);
    }
}
