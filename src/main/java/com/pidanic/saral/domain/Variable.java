package com.pidanic.saral.domain;

public class Variable {
    private int id;
    private int type;
    private String value;
    private String name;

    public Variable(int id, String name,int type, String value) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}