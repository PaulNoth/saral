package com.pidanic.saral.util;

import static org.objectweb.asm.Opcodes.*;

public enum TypeSpecificOpcodes {

    INT(ILOAD, ISTORE, IRETURN, IADD, ISUB, IMUL, IDIV, IREM, INEG), //values (-127,127) - one byte.
    LONG(LLOAD, LSTORE, LRETURN, LADD, LSUB, LMUL, LDIV, LREM, LNEG),
    FLOAT(FLOAD, FSTORE, FRETURN, FADD, FSUB, FMUL, FDIV, FREM, FNEG),
    DOUBLE(DLOAD, DSTORE, DRETURN, DADD, DSUB, DMUL, DDIV, DREM, DNEG),
    VOID(ALOAD, ASTORE, RETURN, 0, 0, 0, 0, 0, 0),
    OBJECT(ALOAD, ASTORE, ARETURN, 0, 0, 0, 0, 0, 0);

    private final int load;
    private final int store;
    private final int ret;
    private final int add;
    private final int sub;
    private final int mul;
    private final int div;
    private final int mod;
    private final int neg;

    TypeSpecificOpcodes(int load, int store, int ret, int add, int sub, int mul, int div, int mod, int neg) {
        this.load = load;
        this.store = store;
        this.ret = ret;
        this.add = add;
        this.sub = sub;
        this.mul = mul;
        this.div = div;
        this.mod = mod;
        this.neg = neg;
    }

    public int getLoad() {
        return load;
    }

    public int getStore() {
        return store;
    }

    public int getReturn() {
        return ret;
    }

    public int getAdd() {
        return add;
    }

    public int getSubstract() {
        return sub;
    }

    public int getMultiply() {
        return mul;
    }

    public int getDivide() {
        return div;
    }

    public int getModulo() {
        return mod;
    }

    public int getNegation() {
        return neg;
    }
}