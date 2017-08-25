package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class VariableNotInitializedException extends RuntimeException {
    public VariableNotInitializedException(Scope scope, String varName) {
        super("Variable " + varName + " is not initialized in scope " + scope);
    }
}
