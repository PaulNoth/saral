package com.pidanic.saral.scope;

import com.pidanic.saral.domain.block.Function;
import com.pidanic.saral.domain.LocalVariable;
import com.pidanic.saral.exception.FunctionNotFoundException;
import com.pidanic.saral.exception.VariableExistsException;
import com.pidanic.saral.exception.VariableNotFoundException;
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
        if(existsLocalVariable(localVariable.getName())) {
            throw new VariableExistsException(this, localVariable.getName());
        }
        localVariables.add(localVariable);
        if(localVariable.getType() == BuiltInType.LONG || localVariable.getType() == BuiltInType.DOUBLE) {
            localVariables.add(EMPTY);
        }
    }

    private boolean existsLocalVariable(String variableName) {
        return localVariables.stream().anyMatch(variable -> variable.getName().equals(variableName));
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

    public Function getFunction(String functionName) {
        return functions.stream().filter(proc -> proc.getName().equals(functionName))
                .findFirst()
                .orElseThrow(() -> new FunctionNotFoundException(this, functionName));
    }

    public String getClassName() {
        return className;
    }

    public void addFunction(Function function) {
        this.functions.add(function);
    }
}
