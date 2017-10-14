package com.pidanic.saral.util;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.block.Argument;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.LocalVariable;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.visitor.BlockStatementVisitor;
import com.pidanic.saral.visitor.SimpleStatementVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class StatementsHelper {
    public static List<Statement> parseStatements(SaralParser.StatementsContext statementsContext, Scope scope) {
        List<Statement> allStatements = statementsContext.statement().stream().map(stmtCtx -> {
            SaralParser.Block_statementContext block = stmtCtx.block_statement();
            SaralParser.Simple_statementContext simpleStmt = stmtCtx.simple_statement();
            Statement val;
            if(block != null) {
                val = block.accept(new BlockStatementVisitor(scope));
            } else {
                val = simpleStmt.accept(new SimpleStatementVisitor(scope));
            }
            return val;
        }).collect(Collectors.toList());

        return allStatements;
    }
}
