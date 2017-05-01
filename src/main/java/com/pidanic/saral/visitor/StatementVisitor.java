package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
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

    //@Override
    //public Statement visitBlock_statement(SaralParser.Block_statementContext ctx) {
    //    Procedure procedure = ctx.proc_definition().accept(new ProcedureVisitor(scope));
    //    Function function = ctx.func_definition().accept(new FunctionVisitor(scope));
    //    scope.addProcedure(procedure);
    //    scope.addFunction(function);
    //    return procedure;
    //}

    @Override
    public Statement visitProc_definition(SaralParser.Proc_definitionContext ctx) {
        Procedure procedure = ctx.accept(new ProcedureVisitor(scope));
        scope.addFunction(procedure);
        return procedure;
    }

    @Override
    public Statement visitFunc_definition(SaralParser.Func_definitionContext ctx) {
        Function function = ctx.accept(new FunctionVisitor(scope));
        scope.addFunction(function);
        return function;
    }
}
