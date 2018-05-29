package com.pidanic.saral.scope;

public class VariableExistsInScope extends Exception {
    private final Scope scope;
    private final String varName;

    public VariableExistsInScope(Scope scope, String varName) {
        this.scope = new Scope(scope);
        this.varName = varName;
    }

    public Scope getScope() {
        return scope;
    }

    public String getVarName() {
        return varName;
    }
}
