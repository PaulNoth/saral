package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class EmptyForStatementBlockException extends RuntimeException {
    public EmptyForStatementBlockException(Scope scope) {
        super("You defined empty for statement");
    }
}
