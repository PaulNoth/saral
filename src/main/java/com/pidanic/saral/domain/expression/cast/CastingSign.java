package com.pidanic.saral.domain.expression.cast;

import com.pidanic.saral.domain.expression.Sign;
import org.objectweb.asm.Opcodes;

public enum CastingSign implements Sign {
    LONG_TO_DOUBLE("l2d", Opcodes.L2D),
    DOUBLE_TO_LONG("d2l", Opcodes.D2L),
    LONG_TO_INT("l2i", Opcodes.L2I);

    CastingSign(String s, int opcode) {
        this.sign = s;
        this.opcode = opcode;
    }

    private String sign;
    private int opcode;

    @Override
    public int getOpcode() {
        return opcode;
    }

    @Override
    public String getSign() {
        return sign;
    }
}
