package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.domain.block.WhileStatement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.exception.EmptyWhileStatementBlock;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

import java.util.List;
import java.util.stream.Collectors;

public class WhileStatementVisitor extends SaralBaseVisitor<WhileStatement> {
    private Scope scope;

    public WhileStatementVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public WhileStatement visitWhile_statement(SaralParser.While_statementContext ctx) {
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        SimpleStatementVisitor simpleStatementVisitor = new SimpleStatementVisitor(scope);
        Expression expression = ctx.expression().accept(expressionVisitor);
        List<SimpleStatement> block = ctx.block().statements().statement().stream()
                .filter(stmt -> stmt.simple_statement() != null)
                .map(stmt -> stmt.simple_statement().accept(simpleStatementVisitor))
                .filter(stmt -> stmt != null)
                .collect(Collectors.toList());
        if(block.isEmpty()) {
            throw new EmptyWhileStatementBlock(scope);
        }
        return new WhileStatement(scope, expression, block);
    }

    public Scope getScope() {
        return scope;
    }
}
