package com.pidanic.saral.domain.block;

import com.pidanic.saral.scope.Scope;

abstract class BlockStatementImpl implements BlockStatement {
    private Scope scope;

    BlockStatementImpl(Scope scope) {
        this.scope = scope;
    }

    public Scope getScope() {
        return scope;
    }
}
