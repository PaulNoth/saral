package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.block.ForStatement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.exception.EmptyForStatementBlock;
import com.pidanic.saral.exception.IncompatibleTypeForStatement;
import com.pidanic.saral.exception.VariableNameAlreadyExists;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.LocalVariable;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.StatementsHelper;

import java.util.List;

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
        String varName = ctx.var().getText();
        Expression from = ctx.val(0).accept(expressionVisitor);
        Expression to = ctx.val(1).accept(expressionVisitor);
        if(from.type() != BuiltInType.LONG) {
            throw new IncompatibleTypeForStatement(ForStatement.ForStatementPart.FROM, scope, from.type());
        }
        if(to.type() != BuiltInType.LONG) {
            throw new IncompatibleTypeForStatement(ForStatement.ForStatementPart.TO, scope, to.type());
        }

        LocalVariable localVar = new LocalVariable(varName, BuiltInType.LONG, true);
        try {
            scope.addLocalVariable(localVar);
            VariableDeclaration var = new VariableDeclaration(varName, from);

            List<Statement> block = StatementsHelper.parseStatements(ctx.block().statements(),scope);
            if(block.isEmpty()) {
                throw new EmptyForStatementBlock(scope);
            }
            return new ForStatement(scope, var, from, to, block);
        } catch (VariableNameAlreadyExists e) {
            throw e;
        }

    }
}
