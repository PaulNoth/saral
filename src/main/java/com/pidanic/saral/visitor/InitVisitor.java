package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.Init;
import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.Statements;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

import java.util.ArrayList;
import java.util.List;

public class InitVisitor extends SaralBaseVisitor<Init> {

    private Scope scope;

    public InitVisitor(String className) {
        this.scope = new Scope(className);
    }

    @Override
    public Init visitInit(SaralParser.InitContext ctx) {
        StatementsVisitor statementsVisitor = new StatementsVisitor(scope);
        SaralParser.StatementsContext stmtsCtx = ctx.statements();
        Statements allStatements = stmtsCtx.accept(statementsVisitor);

        return new Init(scope, allStatements.getStatements());
    }
}
