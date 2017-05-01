package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.Statements;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

import java.util.ArrayList;
import java.util.List;

public class StatementsVisitor extends SaralBaseVisitor<Statements> {

    private Scope scope;

    public StatementsVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Statements visitStatements(SaralParser.StatementsContext ctx) {
        StatementVisitor statementVisitor = new StatementVisitor(scope);
        List<Statement> ret = new ArrayList<>();
        ctx.statement().forEach(stmtCtx -> {
            Statement val = stmtCtx.accept(statementVisitor);
            ret.add(val);
        });

        return new Statements(scope, ret);
    }
}
