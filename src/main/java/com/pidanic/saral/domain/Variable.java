package com.pidanic.saral.domain;

public class Variable {
    private String type;
    private String value;
    private String name;

    public Variable(String name, String type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}