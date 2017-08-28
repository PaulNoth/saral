package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class ConstantAssignmentException extends RuntimeException {
    public ConstantAssignmentException(Scope scope, String varName) {
        super("You cannot change a value of a constant " + varName + ". In scope: " + scope);
    }
}
