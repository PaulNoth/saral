package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class VariableNameAlreadyExists extends RuntimeException {
    public VariableNameAlreadyExists(Scope scope, String varName) {
        super("Local variable " + varName + " already exists in scope " + scope);
    }
}
