package com.pidanic.saral;

public class Variable {
    private int id;
    private int type;
    private String value;

    public Variable(int id, int type, String value) {
        this.id = id;
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
}