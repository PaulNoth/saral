package com.pidanic.saral.domain.block;

import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;

import java.util.List;

public class Procedure extends Function {

    public Procedure(Scope scope, String name, List<Argument> arguments, List<SimpleStatement> simpleStatements) {
        super(scope, name, arguments, simpleStatements, BuiltInType.VOID);
    }
}
