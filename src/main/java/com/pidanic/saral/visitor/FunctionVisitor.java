package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;

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

        List<Argument> arguments = ctx.arglist().arg().stream()
                .map(arg -> arg.accept(new ArgumentVisitor()))
                .peek(arg -> scope.addVariable(new LocalVariable(arg.getName(), arg.getType())))
                .collect(Collectors.toList());

        List<SimpleStatement> simpleStatements = ctx.func_block().simpleStatement().stream()
                .map(stmt -> stmt.accept(new SimpleStatementVisitor(scope)))
                .collect(Collectors.toList());

        String typeName = ctx.TYPE().getText();
        Type retType = TypeResolver.getFromTypeName(typeName);

        String returnVariableName = ctx.func_block().ret().ID().getText();
        LocalVariable retVariable = scope.getLocalVariable(returnVariableName);
        ReturnStatement returnStatement = new ReturnStatement(retVariable);

        Function function = new Function(scope, functionName, arguments, simpleStatements, retType, returnStatement);

        return function;
    }
}
