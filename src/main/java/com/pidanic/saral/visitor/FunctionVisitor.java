package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.block.Argument;
import com.pidanic.saral.domain.block.Function;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.FunctionHelper;
import com.pidanic.saral.util.StatementsHelper;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;

import java.util.List;
public class FunctionVisitor extends SaralBaseVisitor<Function> {

    private Scope scope;

    public FunctionVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public Function visitFunc_definition(SaralParser.Func_definitionContext ctx) {
        String functionName = ctx.ID().getText();

        List<Argument> arguments = FunctionHelper.parseFunctionArguments(ctx.arglist(), scope);
        List<Statement> allStatements = StatementsHelper.parseStatements(ctx.func_block().statements(), scope);

        String typeName = ctx.typeBasic().getText();
        Type retType = TypeResolver.getFromTypeName(typeName);

        SaralParser.ExpressionContext expressionContext = ctx.func_block().ret().expression();
        Expression expression = expressionContext.accept(new ExpressionVisitor(scope));
        ReturnStatement returnStatement = new ReturnStatement(expression);

        Function function = new Function(scope, functionName, arguments, allStatements, retType, returnStatement);

        return function;
    }
}
