package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class EmptyWhileStatementBlock extends RuntimeException {
    public EmptyWhileStatementBlock(Scope scope) {
            super("You defined empty while loop");
    }
}
