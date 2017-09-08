package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.CalledArgument;
import com.pidanic.saral.domain.LocalVariable;
import com.pidanic.saral.exception.VariableNotInitializedException;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

public class CalledArgumentVisitor extends SaralBaseVisitor<CalledArgument> {

    private Scope scope;

    public CalledArgumentVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public CalledArgument visitVarID(SaralParser.VarIDContext ctx) {
        String argName = ctx.ID().getText();
        LocalVariable argVar = scope.getLocalVariable(argName);
        if(!argVar.isInitialized()) {
            throw new VariableNotInitializedException(scope, argVar.getName());
        }
        return new CalledArgument(argName);
    }

    //@Override
    //public CalledArgument visitVar(SaralParser.VarContext ctx) {
    //    String argName = ctx.var().getText();
    //    LocalVariable argVar = scope.getLocalVariable(argName);
    //    if(!argVar.isInitialized()) {
    //        throw new VariableNotInitializedException(scope, argVar.getName());
    //    }
    //    return new CalledArgument(argName);
    //}
}
