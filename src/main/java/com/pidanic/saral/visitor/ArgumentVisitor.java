package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.Argument;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;

public class ArgumentVisitor extends SaralBaseVisitor<Argument> {

    @Override
    public Argument visitArg(SaralParser.ArgContext ctx) {
        String argName = ctx.ID().getText();
        String argType = ctx.TYPE().getText();
        return new Argument(argName, argType);
    }
}
