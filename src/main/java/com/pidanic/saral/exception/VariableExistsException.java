package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class VariableExistsException extends RuntimeException {
    public VariableExistsException(Scope scope, String varName) {
        super("Local variable " + varName + " already exists in scope " + scope);
    }
}
