package com.pidanic.saral.exception;

import com.pidanic.saral.domain.block.ForStatement;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;

public class IncompatibleTypeForStatement extends RuntimeException {
    public IncompatibleTypeForStatement(ForStatement.ForStatementPart part, Scope scope, Type type) {
        super("Only integer values are allowed in for-loops. Current type: " + part + " " + type.getName() + " found in scope " + scope);
    }
}
