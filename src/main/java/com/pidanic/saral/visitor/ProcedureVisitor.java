package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.block.*;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;

import java.util.ArrayList;
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

        List<Argument> arguments = new ArrayList<>();
        for(int i = 0; i < ctx.arglist().ID().size(); i++) {
            String argName = ctx.arglist().ID(i).getText();
            String argType = ctx.arglist().type(i).getText();
            Type type = TypeResolver.getFromTypeName(argType);
            LocalVariable var = new LocalVariable(argName, type);
            scope.addVariable(var);
            arguments.add(new Argument(argName, argType));
        }


        List<Statement> allStatements = ctx.block().statements().statement().stream().map(stmtCtx -> {
            SaralParser.Block_statementContext block = stmtCtx.block_statement();
            SaralParser.Simple_statementContext simpleStmt = stmtCtx.simple_statement();
            Statement val;
            if(block != null) {
                val = block.accept(new StatementVisitor(scope));
            } else {
                val = simpleStmt.accept(new StatementVisitor(scope));
            }
            return val;
        }).collect(Collectors.toList());

        List<Statement> simpleStatements = allStatements.stream()
                .filter(stmt -> stmt instanceof SimpleStatement || stmt instanceof ForStatement || stmt instanceof IfStatement)
                .collect(Collectors.toList());
        Procedure procedure = new Procedure(scope, procedureName, arguments, simpleStatements);

        return procedure;
    }
}
