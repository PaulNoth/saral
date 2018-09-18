package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.CalledArgument;
import com.pidanic.saral.exception.VariableNotFound;
import com.pidanic.saral.scope.LocalVariable;
import com.pidanic.saral.exception.VariableNotInitialized;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

import java.util.Optional;

public class CalledArgumentVisitor extends SaralBaseVisitor<CalledArgument> {

    private Scope scope;

    public CalledArgumentVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public CalledArgument visitVarID(SaralParser.VarIDContext ctx) {
        String argName = ctx.ID().getText();
        Optional<LocalVariable> argVar = scope.getLocalVariable(argName);
        if(!argVar.isPresent()) {
            throw new VariableNotFound(scope, argName);
        }
        if (!argVar.get().isInitialized()) {
            throw new VariableNotInitialized(scope, argVar.get().name());
        }
        return new CalledArgument(argName);
    }
}
