package com.pidanic.saral.domain.expression.math;

import org.objectweb.asm.Opcodes;

import java.util.Arrays;

public enum CompareSign implements Sign {
    EQUAL("==", Opcodes.IF_ICMPNE),
    NOT_EQUAL("<>", Opcodes.IF_ICMPEQ),
    LESS("<", Opcodes.IF_ICMPGE),
    GREATER(">", Opcodes.IF_ICMPLE),
    LESS_OR_EQUAL("<=", Opcodes.IF_ICMPGT),
    GREATER_OR_EQUAL(">=", Opcodes.IF_ICMPLT);

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
