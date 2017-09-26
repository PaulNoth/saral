package com.pidanic.saral.util;

import com.pidanic.saral.scope.LocalVariable;
import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.block.Argument;
import com.pidanic.saral.domain.block.ForStatement;
import com.pidanic.saral.domain.block.IfStatement;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.visitor.StatementVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class FunctionHelper {
    public static List<Statement> parseFunctionStatements(SaralParser.StatementsContext statementsContext, Scope scope) {
        List<Statement> allStatements = statementsContext.statement().stream().map(stmtCtx -> {
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

        List<Statement> statements = allStatements.stream()
                .filter(stmt -> stmt instanceof SimpleStatement || stmt instanceof ForStatement || stmt instanceof IfStatement)
                .collect(Collectors.toList());
        return statements;
    }

    public static List<Argument> parseFunctionArguments(SaralParser.ArglistContext arglistContext, Scope scope) {
        List<Argument> arguments = new ArrayList<>();
        for(int i = 0; i < arglistContext.ID().size(); i++) {
            String argName = arglistContext.ID(i).getText();
            SaralParser.TypeContext typeContext = arglistContext.type(i);
            Type argType;
            if(typeContext.typeBasic() != null) {
                String argTypeName = typeContext.typeBasic().getText();
                argType = TypeResolver.getFromTypeName(argTypeName);
            } else {
                argType = TypeResolver.getArrayTypeFromTypeName(typeContext.typeArray().typeBasic().getText());
            }
            LocalVariable var = new LocalVariable(argName, argType, true);
            scope.addLocalVariable(var);
            arguments.add(new Argument(argName, argType));
        }
        return arguments;
    }
}
