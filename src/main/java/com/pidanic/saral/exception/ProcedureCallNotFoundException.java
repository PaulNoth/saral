package com.pidanic.saral.exception;

import com.pidanic.saral.domain.ProcedureCall;

public class ProcedureCallNotFoundException extends RuntimeException {
    public ProcedureCallNotFoundException(ProcedureCall procedureCall) {
        super("No procedure found for name " + procedureCall.getProcedure().getName());
    }
}
