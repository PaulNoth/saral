package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;

public class IncompatibleTypeArrayLengthException extends RuntimeException {
    public IncompatibleTypeArrayLengthException(Scope scope, String variableName, Type expressionType) {
        super("You are trying to assign and incompatible type to array length for array " + variableName
                + ". Integers allowed. Expression type: " + expressionType.getName() + " in scope:" + scope);
    }
}
