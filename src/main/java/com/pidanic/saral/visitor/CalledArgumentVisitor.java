package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.CalledArgument;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;

public class CalledArgumentVisitor extends SaralBaseVisitor<CalledArgument> {

    @Override
    public CalledArgument visitVar(SaralParser.VarContext ctx) {
        String argName = ctx.ID().getText();
        return new CalledArgument(argName);
    }
}
