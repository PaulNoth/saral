package com.pidanic.saral.scope;

import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.util.Type;

public class LocalVariableArrayIndex extends LocalVariable {

    private Expression index;

    public LocalVariableArrayIndex(String name, Type type, boolean initialized, Expression index) {
        super(name, type, initialized, false);
        this.index = index;
    }

    public Expression getIndex() {
        return index;
    }
}
