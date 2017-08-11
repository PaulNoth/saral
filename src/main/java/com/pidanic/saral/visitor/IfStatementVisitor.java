package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.block.IfStatement;
import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

import java.util.List;
import java.util.stream.Collectors;

public class IfStatementVisitor extends SaralBaseVisitor<IfStatement> {

    private Scope scope;

    public IfStatementVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    public Scope getScope() {
        return scope;
    }

    @Override
    public IfStatement visitIf_statement(SaralParser.If_statementContext ctx) {
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        SimpleStatementVisitor simpleStatementVisitor = new SimpleStatementVisitor(scope);

        Expression expression = ctx.expression().accept(expressionVisitor);
        List<SimpleStatement> trueStatement = ctx.block().get(0).statements().statement()
                .stream()
                .filter(stmt -> stmt.simple_statement() != null)
                .map(stmt -> stmt.simple_statement().accept(simpleStatementVisitor))
                .collect(Collectors.toList());
        List<SimpleStatement> falseStatement = null;
        if(ctx.block().size() == 2) {
            falseStatement = ctx.block().get(1).statements().statement()
                    .stream()
                    .filter(stmt -> stmt.simple_statement() != null)
                    .map(stmt -> stmt.simple_statement().accept(simpleStatementVisitor))
                    .collect(Collectors.toList());
        }
        return new IfStatement(scope, expression, trueStatement, falseStatement);
    }
}
