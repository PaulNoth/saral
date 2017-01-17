package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class VariableNotFoundException extends RuntimeException {
    public VariableNotFoundException(Scope scope, String varName) {
        super("No local variable found for name " + varName + " found in scope" + scope);
    }
}
