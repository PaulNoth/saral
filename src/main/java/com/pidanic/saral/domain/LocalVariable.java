package com.pidanic.saral.domain;

import com.pidanic.saral.util.Type;

public class LocalVariable {

    private final String name;
    private final Type type;
    private boolean initialized;

    public LocalVariable(String name, Type type, boolean initialized) {
        this.name = name;
        this.type = type;
        this.initialized = initialized;
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
}
