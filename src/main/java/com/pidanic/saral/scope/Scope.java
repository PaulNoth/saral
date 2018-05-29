package com.pidanic.saral.scope;

import com.pidanic.saral.domain.block.Function;
import com.pidanic.saral.exception.VariableNameAlreadyExists;
import com.pidanic.saral.util.BuiltInType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void addLocalVariable(LocalVariable localVariable) throws VariableExistsInScope{
        if(existsLocalVariable(localVariable.name())) {
            throw new VariableExistsInScope(this, localVariable.name());
        }
        localVariables.add(localVariable);
        if(localVariable.type() == BuiltInType.LONG || localVariable.type() == BuiltInType.DOUBLE) {
            localVariables.add(EMPTY);
        }
    }

    public boolean existsLocalVariable(String variableName) {
        return localVariables.stream().anyMatch(variable -> variable.name().equals(variableName));
    }

    public Optional<LocalVariable> getLocalVariable(String varName) {
        return localVariables.stream()
                .filter(variable -> variable.name().equals(varName))
                .findFirst();
    }

    public int getLocalVariableIndex(String varName) {
        return localVariables.stream().map(LocalVariable::name).collect(Collectors.toList()).indexOf(varName);
    }

    public Optional<Function> getFunction(String functionName) {
        return functions.stream().filter(proc -> proc.getName().equals(functionName))
                .findFirst();
    }

    public String getClassName() {
        return className;
    }

    public void addFunction(Function function) {
        this.functions.add(function);
    }

    public LocalVariable initializeLocalVariableAtIndex(int index) {
        LocalVariable localVariable = this.localVariables.get(index);
        LocalVariable initializedLocalVar = localVariable.initialize();
        this.localVariables.set(index, initializedLocalVar);
        return initializedLocalVar;
    }

    public LocalVariable initializeLocalVariable(String name) {
        LocalVariable localVariable = getLocalVariable(name).get();
        int index = getLocalVariableIndex(name);
        LocalVariable initializedLocalVar = localVariable.initialize();
        this.localVariables.set(index, initializedLocalVar);
        return initializedLocalVar;
    }

    public int localVariablesCount() {
        return localVariables.size();
    }
}
