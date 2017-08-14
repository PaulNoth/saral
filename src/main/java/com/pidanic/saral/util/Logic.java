package com.pidanic.saral.util;

import java.util.Arrays;

public enum Logic {
    PRAVDA(1, "pravda"), OSAL(0, "ošaľ"), SKOROOSAL(2, "skoroošaľ");

    private final int value;

    private final String sValue;

    Logic(int value, String sValue) {
       this.value = value;
       this.sValue = sValue;
    }

    public Logic and(Logic other) {
        if(this == PRAVDA) {
           return other;
        } else if(this == SKOROOSAL) {
           return other == OSAL ? OSAL : SKOROOSAL;
        }
        return OSAL;
    }

    public Logic not() {
        if(this == PRAVDA) {
           return OSAL;
        } else if(this == OSAL) {
           return PRAVDA;
        }
        return SKOROOSAL;
    }

    public Logic or(Logic other) {
        if(this == OSAL) {
            return other == SKOROOSAL ? SKOROOSAL : OSAL;
        } else if(this == SKOROOSAL) {
            return other == PRAVDA ? PRAVDA : SKOROOSAL;
        }
        return PRAVDA;
    }

    public int getIntValue() {
        return value;
    }

    public String getStringValue() {
        return sValue;
    }

    public static Logic getFromString(String value) {
        return Arrays.stream(values()).filter(val -> val.sValue.compareToIgnoreCase(value) == 0)
                .findFirst().orElse(Logic.OSAL);
    }
}