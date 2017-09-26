package com.pidanic.saral.scope;

import com.pidanic.saral.util.Type;

public class LocalVariable {

    public static final String SYSTEM_IN = "SYSTEM_IN";

    private final String name;
    private final Type type;
    private boolean initialized;
    private boolean constant;

    public LocalVariable(String name, Type type, boolean initialized) {
        this(name, type, initialized, false);
    }

    LocalVariable(String name, Type type, boolean initialized, boolean constant) {
        this.name = name;
        this.type = type;
        this.initialized = initialized;
        this.constant = constant;
    }

    public Type type() {
        return type;
    }

    public String name() {
        return name;
    }

    public boolean isInitialized() {
        return initialized;
    }

    LocalVariable initialize() {
        return new LocalVariable(name(), type(), true, isConstant());
    }

    public boolean isConstant() {
        return constant;
    }
}
