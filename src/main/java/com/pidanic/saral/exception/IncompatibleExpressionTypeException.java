package com.pidanic.saral.exception;

import com.pidanic.saral.util.Type;

public class IncompatibleExpressionTypeException extends RuntimeException {
    public IncompatibleExpressionTypeException(Type type, Type leftType, Type rightType) {
        super("You are trying to assign and cast incompatible types - result type: " + type + ", left type: " + leftType + ", right type: " + rightType);
    }
}
