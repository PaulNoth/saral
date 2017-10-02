package com.pidanic.saral.domain.expression.string;

import com.pidanic.saral.domain.expression.Sign;

import java.util.Arrays;

public enum StringOperationSign implements Sign {
    CONCAT("+");

    private String sign;

    StringOperationSign(String s) {
        this.sign = s;
    }

    @Override
    public int getOpcode() {
        throw new UnsupportedOperationException("String operations do not have opcodes");
    }

    public static StringOperationSign fromString(String sign) {
        return Arrays.stream(values()).filter(numSign -> numSign.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Sign not implemented: " + sign));
    }

    @Override
    public String getSign() {
        return sign;
    }
}
