package com.pidanic.saral.util;

public interface Type {
    String getName();
    Class<?> getTypeClass();
    String getDescriptor();
    String getInternalName();
    TypeSpecificOpcodes getTypeSpecificOpcode();
}
