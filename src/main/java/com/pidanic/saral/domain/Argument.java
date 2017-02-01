package com.pidanic.saral.domain;

public class Argument {
    private final String type;
    private final String name;

    public Argument(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
