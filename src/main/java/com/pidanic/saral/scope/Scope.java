package com.pidanic.saral.scope;

import com.pidanic.saral.domain.Function;
import com.pidanic.saral.domain.LocalVariable;
import com.pidanic.saral.domain.Procedure;
import com.pidanic.saral.domain.Variable;
import com.pidanic.saral.exception.ProcedureNotFoundException;
import com.pidanic.saral.exception.VariableNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scope {

    private List<LocalVariable> localVariables;
    private List<Procedure> procedures;
    private List<Function> functions;
    private String className;

    public Scope(String className) {
        localVariables = new ArrayList<>();
        procedures = new ArrayList<>();
        functions = new ArrayList<>();
        this.className = className;
    }

    public Scope(Scope scope) {
        localVariables = new ArrayList<>(scope.localVariables);
        procedures = new ArrayList<>(scope.procedures);
        functions = new ArrayList<>(scope.functions);
        className = scope.className;
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

    public Procedure getProcedure(String procedureName) {
        return procedures.stream().filter(proc -> proc.getName().equals(procedureName))
                .findFirst()
                .orElseThrow(() -> new ProcedureNotFoundException(this, procedureName));
    }

    public String getClassName() {
        return className;
    }

    public void addFunction(Function function) {
        this.functions.add(function);
    }
}
