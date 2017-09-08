package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.block.Function;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.cast.CastExpression;
import com.pidanic.saral.exception.*;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleStatementVisitor extends SaralBaseVisitor<SimpleStatement> {

    private Scope scope;

    public SimpleStatementVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public SimpleStatement visitWrite(SaralParser.WriteContext ctx) {
        String varName = ctx.var().getText();
        LocalVariable localVariable = scope.getLocalVariable(varName);
        LocalVariable var = new LocalVariable(localVariable.getName(), localVariable.getType(), localVariable.isInitialized());
        if(!var.isInitialized()) {
            throw new VariableNotInitializedException(scope, var.getName());
        }
        return new PrintVariable(var);
    }

    @Override
    public SimpleStatement visitVar_definition(SaralParser.Var_definitionContext ctx) {
        TerminalNode varName = ctx.ID();
        String variableName = varName.getText();
        String varType = ctx.type().typeBasic().getText();
        Type variableType = TypeResolver.getFromTypeName(varType);

        SaralParser.ExpressionContext expressionContext = ctx.expression();
        Expression expression = parseExpression(expressionContext, variableType, variableName);

        LocalVariable var = new LocalVariable(variableName, variableType, true);
        scope.addVariable(var);
        return new VariableDeclaration(varName.getText(), expression);
    }

    @Override
    public SimpleStatement visitConst_definition(SaralParser.Const_definitionContext ctx) {
        TerminalNode varName = ctx.ID();
        String variableName = varName.getText();
        String varType = ctx.type().typeBasic().getText();
        Type variableType = TypeResolver.getFromTypeName(varType);

        SaralParser.ExpressionContext expressionContext = ctx.expression();
        Expression expression = parseExpression(expressionContext, variableType, variableName);

        LocalConstant var = new LocalConstant(variableName, variableType);
        scope.addVariable(var);
        return new ConstantDeclaration(varName.getText(), expression);
    }

    private Expression parseExpression(SaralParser.ExpressionContext expressionContext, Type variableType, String variableName) {
        Expression expression = expressionContext.accept(new ExpressionVisitor(scope));
        if(variableType != expression.getType()) {
            if(variableType == BuiltInType.DOUBLE && expression.getType() == BuiltInType.LONG) {
                expression = new CastExpression(BuiltInType.DOUBLE, expression);
            } else if(variableType == BuiltInType.INT && expression.getType() == BuiltInType.LONG) {
                expression = new CastExpression(BuiltInType.INT, expression);
            } else {
                throw new IncompatibleVariableTypeAssignmentException(scope, variableName, variableType, expression.getType());
            }
        }
        return expression;
    }

    @Override
    public SimpleStatement visitProc_call(SaralParser.Proc_callContext ctx) {
        String procedureName = ctx.ID().getText();
        List<SaralParser.VarContext> calledParameters = ctx.paramlist().var();
        return createProcedureCall(procedureName, calledParameters);
    }

    private ProcedureCall createProcedureCall(String functionName, List<SaralParser.VarContext> calledParameters) {
        List<CalledArgument> args = calledParameters.stream()
                .map(param -> param.accept(new CalledArgumentVisitor(scope)))
                .collect(Collectors.toList());

        Function proc = scope.getFunction(functionName);

        return new ProcedureCall(proc, args);
    }

    @Override
    public SimpleStatement visitVar_declaration(SaralParser.Var_declarationContext ctx) {
        TerminalNode varName = ctx.ID();
        String varType = ctx.type().typeBasic().getText();
        Type type = TypeResolver.getFromTypeName(varType);
        LocalVariable var = new LocalVariable(varName.getText(), type, false);
        scope.addVariable(var);
        return new VariableDeclaration(varName.getText());
    }

    @Override
    public SimpleStatement visitAssignment(SaralParser.AssignmentContext ctx) {
        String varName = ctx.var().getText();
        LocalVariable var = scope.getLocalVariable(varName);
        if(var == null) {
            throw new VariableNotFoundException(scope, varName);
        }
        if(var.isConstant()) {
            throw new ConstantAssignmentException(scope, varName);
        }
        var.initialize();
        SaralParser.ExpressionContext expressionContext = ctx.expression();
        Expression expression = expressionContext.accept(new ExpressionVisitor(scope));

        return new Assignment(varName, expression);
    }

    @Override
    public SimpleStatement visitArray_declaration(SaralParser.Array_declarationContext ctx) {
        String varName = ctx.ID().getText();
        Type arrayType = TypeResolver.getArrayTypeFromTypeName(ctx.typeArray().typeBasic().getText());
        Expression arrayLength = ctx.expression().accept(new ExpressionVisitor(scope));
        if(arrayLength.getType() != BuiltInType.LONG) {
            throw new IncompatibleTypeArrayLengthException(scope, varName, arrayLength.getType());
        }
        LocalVariable var = new LocalVariable(varName, arrayType, true);
        scope.addVariable(var);
        return new ArrayDeclaration(arrayType, arrayLength);
    }
}
