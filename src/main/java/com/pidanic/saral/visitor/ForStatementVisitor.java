package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.block.ForStatement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.exception.EmptyForStatementBlock;
import com.pidanic.saral.exception.IncompatibleTypeForStatement;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;

import java.util.List;
import java.util.stream.Collectors;

public class ForStatementVisitor extends SaralBaseVisitor<ForStatement> {

    private Scope scope;

    public ForStatementVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    public Scope getScope() {
        return scope;
    }

    @Override
    public ForStatement visitFor_statement(SaralParser.For_statementContext ctx) {
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        SimpleStatementVisitor simpleStatementVisitor = new SimpleStatementVisitor(scope);
        String varName = ctx.var().getText();
        Expression from = ctx.val(0).accept(expressionVisitor);
        Expression to = ctx.val(1).accept(expressionVisitor);
        if(from.getType() != BuiltInType.LONG) {
            throw new IncompatibleTypeForStatement(ForStatement.ForStatementPart.FROM, scope, from.getType());
        }
        if(to.getType() != BuiltInType.LONG) {
            throw new IncompatibleTypeForStatement(ForStatement.ForStatementPart.TO, scope, to.getType());
        }

        LocalVariable localVar = new LocalVariable(varName, BuiltInType.LONG, true);
        // TODO here recheck if already in scope
        scope.addVariable(localVar);
        VariableDeclaration var = new VariableDeclaration(varName, from);

        List<SimpleStatement> block = ctx.block().statements().statement().stream()
                .filter(stmt -> stmt.simple_statement() != null)
                .map(stmt -> stmt.simple_statement().accept(simpleStatementVisitor))
                .filter(stmt -> stmt != null)
                .collect(Collectors.toList());
        if(block.isEmpty()) {
            throw new EmptyForStatementBlock(scope);
        }
        return new ForStatement(scope, var, from, to, block);
    }
}
