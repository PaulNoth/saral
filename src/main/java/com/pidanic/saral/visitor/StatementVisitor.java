package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.ExpressionGenerator;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import jdk.nashorn.internal.ir.Block;

public class StatementVisitor extends SaralBaseVisitor<Statement> {

    private Scope scope;

    public StatementVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Statement visitSimple_statement(SaralParser.Simple_statementContext ctx) {
        SimpleStatementVisitor simpleStatementVisitor = new SimpleStatementVisitor(scope);
        SimpleStatement simpleStatement = ctx.accept(simpleStatementVisitor);
        return simpleStatement;
    }

    @Override
    public Statement visitBlock_statement(SaralParser.Block_statementContext ctx) {
        BlockStatementVisitor blockStatementVisitor = new BlockStatementVisitor(scope);
        BlockStatement blockStatement = ctx.accept(blockStatementVisitor);
        return blockStatement;
    }
}
