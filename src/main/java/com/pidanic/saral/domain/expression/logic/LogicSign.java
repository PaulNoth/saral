package com.pidanic.saral.domain.expression.logic;

import com.pidanic.saral.domain.expression.Sign;
import org.objectweb.asm.Opcodes;

import java.util.Arrays;

public enum LogicSign implements Sign {
    AND("a", Opcodes.IAND),
    OR("abo", Opcodes.IOR),
    NOT("ne", Opcodes.INEG);

    private String sign;
    private int opcode;

    LogicSign(String s, int opcode) {
        this.sign = s;
        this.opcode = opcode;
    }

    @Override
    public int getOpcode() {
        return opcode;
    }

    public static LogicSign fromString(String sign) {
        return Arrays.stream(values()).filter(cmpSign -> cmpSign.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Sign not implemented: " + sign));
    }

    @Override
    public String getSign() {
        return sign;
    }
}
