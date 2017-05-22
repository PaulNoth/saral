package com.pidanic.saral.exception;

import com.pidanic.saral.domain.ProcedureCall;
import com.pidanic.saral.domain.expression.FunctionCall;

public class FunctionCallNotFoundException extends RuntimeException {
    public FunctionCallNotFoundException(FunctionCall functionCall) {
        super("No procedure found for name " + functionCall.getFunction().getName());
    }

    public FunctionCallNotFoundException(ProcedureCall functionCall) {
        super("No procedure found for name " + functionCall.getFunction().getName());
    }
}
