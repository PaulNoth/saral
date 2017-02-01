package com.pidanic.saral.domain;

public class LocalVariable {

    private final String name;
    private final String type;

    public LocalVariable(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
