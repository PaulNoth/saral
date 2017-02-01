package com.pidanic.saral.util;

import com.pidanic.saral.grammar.SaralParser;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

public class TypeResolver {

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
        return BuiltInType.STRING;
    }

    private static Optional<BuiltInType> getBuiltInType(String typeName) {
        return Arrays.stream(BuiltInType.values())
                .filter(type -> type.getName().equals(typeName))
                .findFirst();
    }
}
