package com.pidanic.saral.util;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TypeResolver {

    private static final Set<String> BOOL_VALUES;
    static {
        BOOL_VALUES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("pravda", "ošaľ", "skoroošaľ")));
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
        if(StringUtils.isNumeric(value)) {
            return BuiltInType.INT;
        }
        if(isBoolean(value)) {
            return BuiltInType.BOOLEAN;
        }
        return BuiltInType.STRING;
    }

    private static Optional<BuiltInType> getBuiltInType(String typeName) {
        return Arrays.stream(BuiltInType.values())
                .filter(type -> type.getName().equals(typeName))
                .findFirst();
    }

    private static boolean isBoolean(String boolVal) {
        return BOOL_VALUES.contains(boolVal);
    }
}
