package com.pidanic.saral.exception;

import com.pidanic.saral.domain.FunctionCall;

public class FunctionCallNotFoundException extends RuntimeException {
    public FunctionCallNotFoundException(FunctionCall functionCall) {
        super("No procedure found for name " + functionCall.getFunction().getName());
    }
}
