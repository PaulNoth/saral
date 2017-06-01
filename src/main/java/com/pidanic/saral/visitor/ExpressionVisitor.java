package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.FunctionCall;
import com.pidanic.saral.domain.expression.Value;
import com.pidanic.saral.domain.expression.VariableRef;
import com.pidanic.saral.domain.expression.math.Addition;
import com.pidanic.saral.domain.expression.math.Division;
import com.pidanic.saral.domain.expression.math.Multiplication;
import com.pidanic.saral.domain.expression.math.Substraction;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;
import org.antlr.v4.runtime.Token;

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

    @Override
    public Expression visitParen(SaralParser.ParenContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public Expression visitAdd(SaralParser.AddContext ctx) {
        SaralParser.ExpressionContext leftExpression = ctx.expression(0);
        SaralParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression left = leftExpression.accept(this);
        Expression right = rightExpression.accept(this);
        if("+".equals(ctx.op.getText())) {
            return new Addition(left, right);
        }
        return new Substraction(left, right);
    }

    @Override
    public Expression visitMul(SaralParser.MulContext ctx) {
        SaralParser.ExpressionContext leftExpression = ctx.expression(0);
        SaralParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression left = leftExpression.accept(this);
        Expression right = rightExpression.accept(this);
        if("*".equals(ctx.op.getText())) {
            return new Multiplication(left, right);
        }
        return new Division(left, right);
    }
}
