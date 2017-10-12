package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.block.IfStatement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.StatementsHelper;

import java.util.List;

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

        Expression expression = ctx.expression().accept(expressionVisitor);
        List<Statement> trueStatement = StatementsHelper.parseStatements(ctx.block().get(0).statements(), scope);
        List<Statement> falseStatement = null;
        if(ctx.block().size() == 2) {
            falseStatement = StatementsHelper.parseStatements(ctx.block().get(1).statements(), scope);
        }
        return new IfStatement(scope, expression, trueStatement, falseStatement);
    }
}
