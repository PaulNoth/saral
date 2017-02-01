package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.Argument;
import com.pidanic.saral.domain.Procedure;
import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

public class StatementVisitor extends SaralBaseVisitor<Statement> {

    private Scope scope;

    public StatementVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Statement visitSimpleStatement(SaralParser.SimpleStatementContext ctx) {
        SimpleStatementVisitor simpleStatementVisitor = new SimpleStatementVisitor(scope);
        SimpleStatement simpleStatement = ctx.accept(simpleStatementVisitor);
        return simpleStatement;
    }

    @Override
    public Statement visitBlock_statement(SaralParser.Block_statementContext ctx) {
        Procedure procedure = ctx.proc_definition().accept(new ProcedureVisitor(scope));
        scope.addProcedure(procedure);
        return procedure;
    }
}
