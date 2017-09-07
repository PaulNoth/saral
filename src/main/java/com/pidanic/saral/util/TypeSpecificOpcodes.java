package com.pidanic.saral.util;

import static org.objectweb.asm.Opcodes.*;

public enum TypeSpecificOpcodes {

    INT(ILOAD, ISTORE, IRETURN, IADD, ISUB, IMUL, IDIV, IREM, INEG, 0), //values (-127,127) - one byte.
    LONG(LLOAD, LSTORE, LRETURN, LADD, LSUB, LMUL, LDIV, LREM, LNEG, 0),
    FLOAT(FLOAD, FSTORE, FRETURN, FADD, FSUB, FMUL, FDIV, FREM, FNEG, 0),
    DOUBLE(DLOAD, DSTORE, DRETURN, DADD, DSUB, DMUL, DDIV, DREM, DNEG, 0),
    VOID(ALOAD, ASTORE, RETURN, 0, 0, 0, 0, 0, 0, 0),
    OBJECT(ALOAD, ASTORE, ARETURN, 0, 0, 0, 0, 0, 0, NEW),
    BOOLEAN_ARRAY(BALOAD, BASTORE, ARETURN, 0, 0, 0, 0, 0, 0, ANEWARRAY),
    CHAR_ARRAY(CALOAD, CASTORE, ARETURN, 0, 0, 0, 0, 0, 0, ANEWARRAY),
    INT_ARRAY(IALOAD, IASTORE, ARETURN, 0, 0, 0, 0, 0, 0, ANEWARRAY),
    LONG_ARRAY(LALOAD, LASTORE, ARETURN, 0, 0, 0, 0, 0, 0, ANEWARRAY),
    FLOAT_ARRAY(FALOAD, FASTORE, ARETURN, 0, 0, 0, 0, 0, 0, ANEWARRAY),
    DOUBLE_ARRAY(DALOAD, DASTORE, ARETURN, 0, 0, 0, 0, 0, 0, ANEWARRAY),
    OBJECT_ARRAY(AALOAD, AASTORE, ARETURN, 0, 0, 0, 0, 0, 0, ANEWARRAY);


    private final int load;
    private final int store;
    private final int ret;
    private final int add;
    private final int sub;
    private final int mul;
    private final int div;
    private final int mod;
    private final int neg;
    private final int nu;

    TypeSpecificOpcodes(int load, int store, int ret, int add, int sub, int mul, int div, int mod, int neg, int nu) {
        this.load = load;
        this.store = store;
        this.ret = ret;
        this.add = add;
        this.sub = sub;
        this.mul = mul;
        this.div = div;
        this.mod = mod;
        this.neg = neg;
        this.nu = nu;
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

    public int getNew() {
        return nu;
    }
}