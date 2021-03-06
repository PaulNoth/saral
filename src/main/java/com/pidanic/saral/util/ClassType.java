package com.pidanic.saral.util;

public class ClassType implements Type {
    private String name;

    public ClassType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<?> getTypeClass() {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String getDescriptor() {
        return  "L" + getInternalName() + ";";
    }

    @Override
    public String getInternalName() {
        return  name.replace(".", "/");
    }

    @Override
    public TypeSpecificOpcodes getTypeSpecificOpcode() {
        // TODO
        return null;
    }
}
