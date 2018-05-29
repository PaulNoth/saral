package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.scope.VariableExistsInScope;

public class VariableNameAlreadyExists extends RuntimeException {
    public VariableNameAlreadyExists(Scope scope, String varName) {
        super("Local variable " + varName + " already exists in scope " + scope);
    }

    public VariableNameAlreadyExists(VariableExistsInScope e) {
        super("Local variable " + e.getVarName() + " already exists in scope " + e.getScope());
    }
}
