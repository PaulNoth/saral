package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;

public class IncompatibleVariableTypeAssignmentException extends RuntimeException {
    public IncompatibleVariableTypeAssignmentException(Scope scope, String variableName, Type variableType, Type expressionType) {
        super("You are trying to assign and incompatible type to variable " + variableName + ". Variable type: " + variableType.getName() + ", expression type: " + expressionType.getName() + " in scope:" + scope);
    }
}
