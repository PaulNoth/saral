package com.pidanic.saral.domain;

import com.pidanic.saral.util.Type;

public class LocalVariable {

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

    public Type getType() {
        return type;
    }

    public String getName() {
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
