package com.pidanic.saral.domain;

public class Variable {
    private int type;
    private String value;
    private String name;

    public Variable(String name, int type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}