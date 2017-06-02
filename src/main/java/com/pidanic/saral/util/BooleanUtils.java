package com.pidanic.saral.util;

import java.util.*;

public final class BooleanUtils {

    private static Map<String, Integer> SARAL_JAVA_BOOL_VALUES;

    static {
        Map<String, Integer> boolMapping = new HashMap<>(3);
        boolMapping.put("pravda", 2);
        boolMapping.put("skoroošaľ", 1);
        boolMapping.put("ošaľ", 0);
        SARAL_JAVA_BOOL_VALUES = Collections.unmodifiableMap(boolMapping);
    }

    private static final Set<String> BOOL_VALUES;
    static {
        BOOL_VALUES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("pravda", "ošaľ", "skoroošaľ")));
    }

    public static int convertToBooleanValue(String boolValue) {
        return SARAL_JAVA_BOOL_VALUES.getOrDefault(boolValue, 0);
    }

    public static boolean isBooleanValue(String boolVal) {
        return BOOL_VALUES.contains(boolVal);
    }
}

