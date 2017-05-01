package com.pidanic.saral.domain;

import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;

import java.util.List;

public class Procedure extends Function {

    public Procedure(Scope scope, String name, List<Argument> arguments, List<SimpleStatement> simpleStatements) {
        super(scope, name, arguments, simpleStatements, BuiltInType.VOID);
    }
}
