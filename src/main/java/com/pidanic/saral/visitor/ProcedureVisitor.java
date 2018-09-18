package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.block.*;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.FunctionHelper;
import com.pidanic.saral.util.StatementsHelper;

import java.util.Collections;
import java.util.List;

public class ProcedureVisitor extends SaralBaseVisitor<Procedure> {

    private Scope scope;

    public ProcedureVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public Procedure visitProc_definition(SaralParser.Proc_definitionContext ctx) {
        String procedureName = ctx.ID().getText();

        List<Argument> arguments = FunctionHelper.parseFunctionArguments(ctx.arglist(), scope);
        Procedure me = new Procedure(scope, procedureName, arguments, Collections.emptyList());
        this.addMyselfToScope(me);

        List<Statement> allStatements = StatementsHelper.parseStatements(ctx.block().statements(), scope);
        me.setStatements(allStatements);
        return me;
    }

    private void addMyselfToScope(Function me) {
        this.scope.addFunction(me);
    }
}
