package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

/**
 * Created by pavol.pidanic on 30/03/2017.
 */
public class FunctionNotFound extends RuntimeException {
    public FunctionNotFound(Scope scope, String functionName) {
        super("No procedure found for name " + functionName + " found in scope " + scope);
    }
}
