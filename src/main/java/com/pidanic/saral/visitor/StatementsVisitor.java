package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.Statements;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatementsVisitor extends SaralBaseVisitor<Statements> {

    private Scope scope;

    public StatementsVisitor(String className) {
        this.scope = new Scope(className);
    }

    @Override
    public Statements visitStatements(SaralParser.StatementsContext ctx) {
        StatementVisitor statementVisitor = new StatementVisitor(scope);
        List<Statement> ret = new ArrayList<>();
        ctx.statement().forEach(stmtCtx -> {
            Statement val = stmtCtx.accept(statementVisitor);
            ret.add(val);
        });
       // List<Statement> statements = ctx.statement().stream()
       //         .map(stmt -> stmt.accept(statementVisitor)).collect(Collectors.toList());

        return new Statements(scope, ret);
    }
}
