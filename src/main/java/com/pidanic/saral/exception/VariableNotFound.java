package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class VariableNotFound extends RuntimeException {
    public VariableNotFound(Scope scope, String varName) {
        super("No local variable found for name " + varName + " found in scope " + scope);
    }
}
