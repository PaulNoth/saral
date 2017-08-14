package com.pidanic.saral.domain.expression.math;

import com.pidanic.saral.domain.expression.Sign;
import org.objectweb.asm.Opcodes;

import java.util.Arrays;

public enum ArithmeticSign implements Sign {
    ADD("+", Opcodes.IADD),
    SUB("-", Opcodes.ISUB),
    MULT("*", Opcodes.IMUL),
    DIV("/", Opcodes.IDIV),
    DIV2(":", Opcodes.IDIV),
    MOD("%", Opcodes.IREM);

    private String sign;
    private int opcode;

    ArithmeticSign(String s, int opcode) {
        this.sign = s;
        this.opcode = opcode;
    }

    @Override
    public int getOpcode() {
        return opcode;
    }

    public static ArithmeticSign fromString(String sign) {
        return Arrays.stream(values()).filter(numSign -> numSign.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Sign not implemented: " + sign));
    }

    @Override
    public String getSign() {
        return sign;
    }
}
