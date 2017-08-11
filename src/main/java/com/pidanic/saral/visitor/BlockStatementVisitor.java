package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

public class BlockStatementVisitor extends SaralBaseVisitor<BlockStatement> {

    private Scope scope;

    public BlockStatementVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public BlockStatement visitProc_definition(SaralParser.Proc_definitionContext ctx) {
        Procedure procedure = ctx.accept(new ProcedureVisitor(scope));
        scope.addFunction(procedure);
        return procedure;
    }

    @Override
    public BlockStatement visitFunc_definition(SaralParser.Func_definitionContext ctx) {
        Function function = ctx.accept(new FunctionVisitor(scope));
        scope.addFunction(function);
        return function;
    }

    @Override
    public BlockStatement visitIf_statement(SaralParser.If_statementContext ctx) {
       IfStatementVisitor ifStatementVisitor = new IfStatementVisitor(scope);
       IfStatement ifStatement = ctx.accept(ifStatementVisitor);
       return ifStatement;
    }

    @Override
    public BlockStatement visitFor_statement(SaralParser.For_statementContext ctx) {
        ForStatementVisitor forStatementVisitor = new ForStatementVisitor(scope);
        ForStatement forStatement = ctx.accept(forStatementVisitor);
        return forStatement;
    }
}
