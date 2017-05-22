package com.pidanic.saral.domain;

import com.pidanic.saral.util.Type;

public class LocalVariable {

    private final String name;
    private final Type type;

    public LocalVariable(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
