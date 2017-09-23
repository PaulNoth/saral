package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class EmptyForStatementBlock extends RuntimeException {
    public EmptyForStatementBlock(Scope scope) {
        super("You defined empty for statement");
    }
}
