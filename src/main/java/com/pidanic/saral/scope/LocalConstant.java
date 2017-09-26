package com.pidanic.saral.scope;

import com.pidanic.saral.util.Type;

public class LocalConstant extends LocalVariable {

    public LocalConstant(String name, Type type) {
        super(name, type, true, true);
    }
}
