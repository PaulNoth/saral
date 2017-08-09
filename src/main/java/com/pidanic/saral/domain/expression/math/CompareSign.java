package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Sign;
import org.objectweb.asm.Opcodes;

import java.util.Arrays;

public enum CompareSign implements Sign {
    // comparing longs pushes 1, 0, -1 on the stack. then compare with the 0
    EQUAL("==", Opcodes.IFNE),
    NOT_EQUAL("<>", Opcodes.IFEQ),
    LESS("<", Opcodes.IFGE),
    GREATER(">", Opcodes.IFLE),
    LESS_OR_EQUAL("<=", Opcodes.IFGT),
    GREATER_OR_EQUAL(">=", Opcodes.IFLT);

    private String sign;
    //reversed. '>' evalutes to le -> less or equal
    private int opcode;

    CompareSign(String s, int opcode) {
        this.sign = s;
        this.opcode = opcode;
    }

    @Override
    public int getOpcode() {
        return opcode;
    }

    public static CompareSign fromString(String sign) {
        return Arrays.stream(values()).filter(cmpSign -> cmpSign.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Sign not implemented: " + sign));
    }

    @Override
    public String getSign() {
        return sign;
    }
}
