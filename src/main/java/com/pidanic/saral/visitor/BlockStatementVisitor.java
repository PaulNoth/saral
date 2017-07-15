package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.BlockStatement;
import com.pidanic.saral.domain.Function;
import com.pidanic.saral.domain.Procedure;
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
}
