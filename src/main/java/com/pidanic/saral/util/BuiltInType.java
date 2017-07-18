package com.pidanic.saral.util;

public enum BuiltInType implements Type {
    BOOLEAN("logický", boolean.class, "Z", TypeSpecificOpcodes.INT),
    INT ("neskutočné numeralio", int.class, "I", TypeSpecificOpcodes.INT),
    //CHAR ("písmeno", char.class, "C", TypeSpecificOpcodes.INT),
    //BYTE ("neskutočné numeralio", byte.class, "B", TypeSpecificOpcodes.INT),
    //SHORT ("neskutočné numeralio", short.class, "S", TypeSpecificOpcodes.INT),
    LONG ("neskutočné numeralio", long.class, "J", TypeSpecificOpcodes.LONG),
    FLOAT ("skutočné numeralio", float.class, "F", TypeSpecificOpcodes.FLOAT),
    DOUBLE ("skutočné numeralio", double.class, "D", TypeSpecificOpcodes.DOUBLE),
    STRING ("slovo", String.class, "Ljava/lang/String;", TypeSpecificOpcodes.OBJECT),
    //BOOLEAN_ARR("bool[]", boolean[].class, "[B"),
    //INT_ARR ("int[]", int[].class, "[I"),
    //CHAR_ARR ("char[]", char[].class, "[C"),
    //BYTE_ARR ("byte[]", byte[].class, "[B"),
    //SHORT_ARR ("short[]", short[].class, "[S"),
    //LONG_ARR ("long[]", long[].class, "[J"),
    //FLOAT_ARR ("float[]", float[].class, "[F"),
    //DOUBLE_ARR ("double[]", double[].class, "[D"),
    //STRING_ARR ("string[]", String[].class, "[Ljava/lang/String;"),
    //NONE("", null,""),
    VOID("void", void.class, "V", TypeSpecificOpcodes.VOID);

    private String name;
    private Class<?> typeClass;
    private String descriptor;
    private TypeSpecificOpcodes opCode;

    BuiltInType(String name, Class<?> typeClass, String descriptor, TypeSpecificOpcodes op) {
        this.name = name;
        this.typeClass = typeClass;
        this.descriptor = descriptor;
        this.opCode = op;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<?> getTypeClass() {
        return typeClass;
    }

    @Override
    public String getDescriptor() {
        return descriptor;
    }

    @Override
    public String getInternalName() {
        return getDescriptor();
    }

    @Override
    public TypeSpecificOpcodes getTypeSpecificOpcode() {
        return opCode;
    }
}