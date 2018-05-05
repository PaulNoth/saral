package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.block.Function;
import com.pidanic.saral.domain.expression.*;
import com.pidanic.saral.domain.expression.logic.*;
import com.pidanic.saral.domain.expression.math.*;
import com.pidanic.saral.domain.expression.string.Concatenation;
import com.pidanic.saral.exception.FunctionNotFound;
import com.pidanic.saral.exception.IncompatibleTypeArrayIndex;
import com.pidanic.saral.exception.VariableNotFound;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.LocalVariable;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.domain.expression.math.CompareSign;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;

import java.util.List;
import java.util.Optional;
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
                .map(param -> param.accept(new CalledArgumentVisitor(scope)))
                .collect(Collectors.toList());

        Optional<Function> function = scope.getFunction(functionName);
        if(function.isPresent()) {
            return new FunctionCall(function.get(), args);
        } else {
            throw new FunctionNotFound(scope, functionName);
        }

    }

    @Override
    public Expression visitValVar(SaralParser.ValVarContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Expression visitValInt(SaralParser.ValIntContext ctx) {
        String value = ctx.getText();
        return new Value(BuiltInType.LONG, value);
    }

    @Override
    public Expression visitValString(SaralParser.ValStringContext ctx) {
        String value = ctx.getText();
        return new Value(BuiltInType.STRING, value);
    }

    @Override
    public Expression visitValChar(SaralParser.ValCharContext ctx) {
        String value = ctx.getText();
        return new Value(BuiltInType.CHAR, value);
    }

    @Override
    public Expression visitValFloat(SaralParser.ValFloatContext ctx) {
        String value = ctx.getText();
        return new Value(BuiltInType.DOUBLE, value);
    }

    @Override
    public Expression visitValBool(SaralParser.ValBoolContext ctx) {
        String value = ctx.getText();
        return new Value(BuiltInType.BOOLEAN, value);
    }

    @Override
    public Expression visitVarID(SaralParser.VarIDContext ctx) {
        String varName = ctx.ID().getText();
        Optional<LocalVariable> localVariable = scope.getLocalVariable(varName);
        if(localVariable.isPresent()) {
            return new VariableRef(varName, localVariable.get().type());
        } else {
            throw new VariableNotFound(scope, varName);
        }
    }

    @Override
    public Expression visitVarArray(SaralParser.VarArrayContext ctx) {
        String varName = ctx.ID().getText();
        Expression index = ctx.expression().accept(this);
        if(index.type() != BuiltInType.LONG) {
            throw new IncompatibleTypeArrayIndex(scope, varName, index.type());
        }
        return new ArrayRef(varName, index.type(), index);
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
        String operationSymbol = ctx.op.getText();
        Sign sign = ArithmeticSign.fromString(operationSymbol);
        if(sign == ArithmeticSign.ADD) {
            if(left.type() == BuiltInType.STRING || right.type() == BuiltInType.STRING) {
                return new Concatenation(left, right);
            }
            return new Addition(left, right);
        } else {
            return new Substraction(left, right);
        }
    }

    @Override
    public Expression visitUnaryMinus(SaralParser.UnaryMinusContext ctx) {
        Expression expression = ctx.expression().accept(this);
        return new UnaryMinus(expression);
    }

    @Override
    public Expression visitMul(SaralParser.MulContext ctx) {
        SaralParser.ExpressionContext leftExpression = ctx.expression(0);
        SaralParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression left = leftExpression.accept(this);
        Expression right = rightExpression.accept(this);
        String operationSymbol = ctx.op.getText();
        Sign sign = ArithmeticSign.fromString(operationSymbol);
        if(sign == ArithmeticSign.MOD) {
            return new Modulo(left, right);
        } else if(sign == ArithmeticSign.MULT) {
            return new Multiplication(left, right);
        } else {
            return new Division(left, right);
        }
    }

    @Override
    public Expression visitCompare(SaralParser.CompareContext ctx) {
        SaralParser.ExpressionContext leftExpression = ctx.expression(0);
        SaralParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression left = leftExpression.accept(this);
        Expression right = rightExpression.accept(this);
        String operationSymbol = ctx.op.getText();
        return new CompareExpression(CompareSign.fromString(operationSymbol), left, right);
    }

    @Override
    public Expression visitBoolNot(SaralParser.BoolNotContext ctx) {
        SaralParser.ExpressionContext expression = ctx.expression();

        Expression expr = expression.accept(this);
        return new Negation(expr);
    }

    @Override
    public Expression visitBoolAnd(SaralParser.BoolAndContext ctx) {
        SaralParser.ExpressionContext leftExpression = ctx.expression(0);
        SaralParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression left = leftExpression.accept(this);
        Expression right = rightExpression.accept(this);
        return new And(left, right);
    }

    @Override
    public Expression visitBoolOr(SaralParser.BoolOrContext ctx) {
        SaralParser.ExpressionContext leftExpression = ctx.expression(0);
        SaralParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression left = leftExpression.accept(this);
        Expression right = rightExpression.accept(this);
        return new Or(left, right);
    }
}
