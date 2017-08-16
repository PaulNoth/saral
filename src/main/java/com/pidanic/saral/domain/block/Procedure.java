package com.pidanic.saral.domain.block;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;

import java.util.List;

public class Procedure extends Function {

    public Procedure(Scope scope, String name, List<Argument> arguments, List<Statement> statements) {
        super(scope, name, arguments, statements, BuiltInType.VOID);
    }
}
