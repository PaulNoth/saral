package com.pidanic.saral.util;

import static org.objectweb.asm.Opcodes.*;

public enum ReferenceArrayTypeSpecificOpcodes {

    STRING(ANEWARRAY, "Ljava/lang/String;");
    //VOID(ANEWARRAY, 0),
    //OBJECT(ANEWARRAY, 0);

    private final int create;
    private final String atype;

    ReferenceArrayTypeSpecificOpcodes(int create, String atype) {
        this.create = create;
        this.atype = atype;
    }
}