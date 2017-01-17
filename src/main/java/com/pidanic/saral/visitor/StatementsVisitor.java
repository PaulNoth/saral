package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.Statements;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

import java.util.List;
import java.util.stream.Collectors;

public class StatementsVisitor extends SaralBaseVisitor<Statements> {

    private Scope scope;

    public StatementsVisitor() {
        this.scope = new Scope();
    }

    @Override
    public Statements visitStatements(SaralParser.StatementsContext ctx) {
        StatementVisitor statementVisitor = new StatementVisitor(this.scope);
        List<Statement> instructionList = ctx.statement()
                .stream().map(statement -> statement.accept(statementVisitor))
                .collect(Collectors.toList());
        return new Statements(scope, instructionList);
    }
}
