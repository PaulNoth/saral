package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

import java.util.List;
import java.util.stream.Collectors;

public class ProcedureVisitor extends SaralBaseVisitor<Procedure> {

    private Scope scope;

    public ProcedureVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public Procedure visitProc_definition(SaralParser.Proc_definitionContext ctx) {
        String procedureName = ctx.ID().getText();

        List<Argument> arguments = ctx.arglist().arg().stream()
                .map(arg -> arg.accept(new ArgumentVisitor()))
                .peek(arg -> scope.addVariable(new LocalVariable(arg.getName(), arg.getType())))
                .collect(Collectors.toList());

        StatementsVisitor statementsVisitor = new StatementsVisitor(scope);
        Statements statements = ctx.block().statements().accept(statementsVisitor);
        List<SimpleStatement> simpleStatements = statements.getStatements().stream()
                .filter(stmt -> stmt instanceof SimpleStatement)
                .map(statement -> (SimpleStatement) statement)
                .collect(Collectors.toList());
        Procedure procedure = new Procedure(scope, procedureName, arguments, simpleStatements);

        return procedure;
    }
}
