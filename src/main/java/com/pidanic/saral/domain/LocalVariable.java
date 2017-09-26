package com.pidanic.saral.domain;

import com.pidanic.saral.util.Type;

public class LocalVariable {

    public static final String IN = "IN";

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

    public void initialize() {
        this.initialized = true;
    }

    public boolean isConstant() {
        return constant;
    }
}
