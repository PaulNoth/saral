package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class VariableNotInitialized extends RuntimeException {
    public VariableNotInitialized(Scope scope, String varName) {
        super("Variable " + varName + " is not initialized in scope " + scope);
    }
}
