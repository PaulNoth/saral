package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.block.WhileStatement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.exception.EmptyWhileStatementBlock;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.StatementsHelper;

import java.util.List;

public class WhileStatementVisitor extends SaralBaseVisitor<WhileStatement> {
    private Scope scope;

    public WhileStatementVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public WhileStatement visitWhile_statement(SaralParser.While_statementContext ctx) {
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        Expression expression = ctx.expression().accept(expressionVisitor);
        List<Statement> block = StatementsHelper.parseStatements(ctx.block().statements(), scope);
        if(block.isEmpty()) {
            throw new EmptyWhileStatementBlock(scope);
        }
        return new WhileStatement(scope, expression, block);
    }

    public Scope getScope() {
        return scope;
    }
}
