package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class EmptyWhileStatementBlockException extends RuntimeException {
    public EmptyWhileStatementBlockException(Scope scope) {
            super("You defined empty while loop");
    }
}
