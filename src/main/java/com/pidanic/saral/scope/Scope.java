package com.pidanic.saral.scope;

import com.pidanic.saral.domain.block.Function;
import com.pidanic.saral.domain.LocalVariable;
import com.pidanic.saral.exception.FunctionNotFound;
import com.pidanic.saral.exception.VariableNameAlreadyExists;
import com.pidanic.saral.exception.VariableNotFound;
import com.pidanic.saral.util.BuiltInType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scope {

    private static final LocalVariable EMPTY = new LocalVariable("empty", BuiltInType.BOOLEAN, true);

    private List<LocalVariable> localVariables;
    private List<Function> functions;
    private String className;

    public Scope(String className) {
        localVariables = new ArrayList<>();
        functions = new ArrayList<>();
        this.className = className;
    }

    public Scope(Scope scope) {
        localVariables = new ArrayList<>(scope.localVariables);
        functions = new ArrayList<>(scope.functions);
        className = scope.className;
    }

    public List<LocalVariable> getLocalVariables() {
        return Collections.unmodifiableList(localVariables);
    }

    public void addVariable(LocalVariable localVariable) {
        if(existsLocalVariable(localVariable.name())) {
            throw new VariableNameAlreadyExists(this, localVariable.name());
        }
        localVariables.add(localVariable);
        if(localVariable.type() == BuiltInType.LONG || localVariable.type() == BuiltInType.DOUBLE) {
            localVariables.add(EMPTY);
        }
    }

    private boolean existsLocalVariable(String variableName) {
        return localVariables.stream().anyMatch(variable -> variable.name().equals(variableName));
    }

    public LocalVariable getLocalVariable(String varName) {
        return localVariables.stream()
                .filter(variable -> variable.name().equals(varName))
                .findFirst()
                .orElseThrow(() -> new VariableNotFound(this, varName));
    }

    public int getVariableIndex(String varName) {
        LocalVariable localVariable = getLocalVariable(varName);
        return localVariables.indexOf(localVariable);
    }

    public Function getFunction(String functionName) {
        return functions.stream().filter(proc -> proc.getName().equals(functionName))
                .findFirst()
                .orElseThrow(() -> new FunctionNotFound(this, functionName));
    }

    public String getClassName() {
        return className;
    }

    public void addFunction(Function function) {
        this.functions.add(function);
    }
}
