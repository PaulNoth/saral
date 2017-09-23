package com.pidanic.saral.util;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TypeResolver {

    private final static Map<String, Type> ARRAY_TYPES;
    static {
        Map<String, Type> map = new HashMap<>();
        map.put("logický", BuiltInType.BOOLEAN_ARR);
        map.put("písmeno", BuiltInType.CHAR_ARR);
        map.put("neskutočné numeralio", BuiltInType.LONG_ARR);
        map.put("skutočné numeralio", BuiltInType.DOUBLE_ARR);
        map.put("slovo", BuiltInType.STRING_ARR);
        ARRAY_TYPES = new HashMap<>(map);
    }

    public static Type getFromTypeName(String type) {
        if(type == null) {
            return BuiltInType.VOID;
        }
        Optional<? extends Type> builtInType = getBuiltInType(type);
        if(builtInType.isPresent()) {
            return builtInType.get();
        }
        return BuiltInType.VOID;
    }

    public static Type getFromValue(String value) {
        if(StringUtils.isEmpty(value)) {
            return BuiltInType.VOID;
        }
        if(Logic.isBooleanValue(value)) {
            return BuiltInType.BOOLEAN;
        }
        if(value.matches("[0-9]+.[0-9]+]")) {
            double val = Double.parseDouble(value);
            return BuiltInType.DOUBLE;
        }
        if(StringUtils.isNumeric(value)) {
            return BuiltInType.LONG;
        }

        return BuiltInType.STRING;
    }

    private static Optional<BuiltInType> getBuiltInType(String typeName) {
        return Arrays.stream(BuiltInType.values())
                .filter(type -> type.getName().equals(typeName))
                .findFirst();
    }

    public static boolean isInteger(Type type) {
        return type == BuiltInType.LONG;
    }

    public static boolean isDouble(Type type) {
        return type == BuiltInType.DOUBLE;
    }

    public static boolean isBoolean(Type type) {
        return type == BuiltInType.BOOLEAN;
    }

    public static boolean isNumber(Type type) {
        return isInteger(type) || isDouble(type);
    }

    public static Type getArrayTypeFromTypeName(String basicTypeName) {
        return ARRAY_TYPES.getOrDefault(basicTypeName, BuiltInType.STRING_ARR);
    }

    public static boolean isArray(Type type) {
        return ARRAY_TYPES.values().stream().anyMatch(arrayType -> arrayType == type);
    }
}
