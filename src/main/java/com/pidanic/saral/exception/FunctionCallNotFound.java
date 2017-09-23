package com.pidanic.saral.exception;

import com.pidanic.saral.domain.ProcedureCall;
import com.pidanic.saral.domain.expression.FunctionCall;

public class FunctionCallNotFound extends RuntimeException {
    public FunctionCallNotFound(FunctionCall functionCall) {
        super("No procedure found for name " + functionCall.getFunction().getName());
    }

    public FunctionCallNotFound(ProcedureCall functionCall) {
        super("No procedure found for name " + functionCall.getFunction().getName());
    }
}
