package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

/**
 * Created by pavol.pidanic on 30/03/2017.
 */
public class ProcedureNotFoundException extends RuntimeException {
    public ProcedureNotFoundException(Scope scope, String procedureName) {
        super("No procedure found for name " + procedureName + " found in scope " + scope);
    }
}
