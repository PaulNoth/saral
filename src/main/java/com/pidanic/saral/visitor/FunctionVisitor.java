package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionVisitor extends SaralBaseVisitor<Function> {

    private Scope scope;

    public FunctionVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public Function visitFunc_definition(SaralParser.Func_definitionContext ctx) {
        String functionName = ctx.ID().getText();

        List<Argument> arguments = new ArrayList<>();
        for(int i = 0; i < ctx.arglist().ID().size(); i++) {
            String argName = ctx.arglist().ID(i).getText();
            String argType = ctx.arglist().type(i).getText();
            Type type = TypeResolver.getFromTypeName(argType);
            LocalVariable var = new LocalVariable(argName, type);
            scope.addVariable(var);
            arguments.add(new Argument(argName, argType));
        }

        List<Statement> allStatements = ctx.func_block().statements().statement().stream().map(stmtCtx -> {
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

        String typeName = ctx.typeBasic().getText();
        Type retType = TypeResolver.getFromTypeName(typeName);

        SaralParser.ExpressionContext expressionContext = ctx.func_block().ret().expression();
        Expression expression = expressionContext.accept(new ExpressionVisitor(scope));
        ReturnStatement returnStatement = new ReturnStatement(expression);

        List<SimpleStatement> simpleStatements = allStatements.stream()
                .filter(stmt -> stmt instanceof SimpleStatement)
                .map(statement -> (SimpleStatement) statement)
                .collect(Collectors.toList());
        Function function = new Function(scope, functionName, arguments, simpleStatements, retType, returnStatement);

        return function;
    }
}
