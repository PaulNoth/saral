package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

/**
 * Created by pavol.pidanic on 30/03/2017.
 */
public class FunctionNotFoundException extends RuntimeException {
    public FunctionNotFoundException(Scope scope, String functionName) {
        super("No procedure found for name " + functionName + " found in scope " + scope);
    }
}
