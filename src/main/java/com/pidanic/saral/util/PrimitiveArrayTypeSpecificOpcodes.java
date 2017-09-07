package com.pidanic.saral.util;

import static org.objectweb.asm.Opcodes.*;

public enum PrimitiveArrayTypeSpecificOpcodes {

    BOOLEAN(NEWARRAY, T_BOOLEAN),
    CHAR(NEWARRAY, T_CHAR),
    INT(NEWARRAY, T_INT),
    LONG(NEWARRAY, T_LONG),
    FLOAT(NEWARRAY, T_FLOAT),
    DOUBLE(NEWARRAY, T_DOUBLE);

    private final int create;
    private final int atype;

    PrimitiveArrayTypeSpecificOpcodes(int create, int atype) {
        this.create = create;
        this.atype = atype;
    }
}