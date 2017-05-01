package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.Init;
import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.Statements;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InitVisitor extends SaralBaseVisitor<Init> {

    private Scope scope;

    public InitVisitor(String className) {
        this.scope = new Scope(className);
    }

    @Override
    public Init visitInit(SaralParser.InitContext ctx) {
        List<Statement> allStatements = ctx.statements().statement().stream().map(stmtCtx -> {
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

        return new Init(scope, allStatements);
    }
}
