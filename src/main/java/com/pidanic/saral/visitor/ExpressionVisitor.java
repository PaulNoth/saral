package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.FunctionCall;
import com.pidanic.saral.domain.expression.Value;
import com.pidanic.saral.domain.expression.VariableRef;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;

import java.util.List;
import java.util.stream.Collectors;

public class ExpressionVisitor extends SaralBaseVisitor<Expression> {
    private Scope scope;

    public ExpressionVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public Expression visitFunc_call(SaralParser.Func_callContext ctx) {
        String functionName = ctx.ID().getText();
        List<SaralParser.VarContext> calledParameters = ctx.paramlist().var();
        return createFunctionCall(functionName, calledParameters);
    }

    private FunctionCall createFunctionCall(String functionName, List<SaralParser.VarContext> calledParameters) {
        List<CalledArgument> args = calledParameters.stream()
                .map(param -> param.accept(new CalledArgumentVisitor()))
                .collect(Collectors.toList());

        Function proc = scope.getFunction(functionName);

        return new FunctionCall(proc, args);
    }

    //@Override
    //public Expression visitVar_definition(SaralParser.Var_definitionContext ctx) {
    //    TerminalNode varName = ctx.ID();
    //    SaralParser.ValContext varValue = ctx.val();
    //    String varType = ctx.type().typeBasic().getText();
    //    String varTextValue = varValue.getText();
    //    LocalVariable var = new LocalVariable(varName.getText(), varType);
    //    scope.addVariable(var);
    //    return new VariableDeclaration(varName.getText(), varTextValue);
    //}


    @Override
    public Expression visitVal(SaralParser.ValContext ctx) {
        if(ctx.var() == null) {
            String value = ctx.getText();
            Type type = TypeResolver.getFromValue(ctx.getText());
            return new Value(type, value);
        }
        return visitVar(ctx.var());
    }

    @Override
    public Expression visitVar(SaralParser.VarContext ctx) {
        String varName = ctx.getText();
        LocalVariable localVariable = scope.getLocalVariable(varName);
        return new VariableRef(varName,localVariable.getType());
    }
}
