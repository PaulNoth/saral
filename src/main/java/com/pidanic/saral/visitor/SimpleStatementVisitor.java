package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.block.Function;
import com.pidanic.saral.domain.expression.ArrayRef;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.VariableRef;
import com.pidanic.saral.domain.expression.cast.CastExpression;
import com.pidanic.saral.exception.*;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.LocalConstant;
import com.pidanic.saral.scope.LocalVariable;
import com.pidanic.saral.scope.LocalVariableArrayIndex;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SimpleStatementVisitor extends SaralBaseVisitor<SimpleStatement> {

    private Scope scope;

    public SimpleStatementVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public SimpleStatement visitWrite(SaralParser.WriteContext ctx) {
        return createPrintStatement(ctx.var());
    }

    @Override
    public SimpleStatement visitWrite2(SaralParser.Write2Context ctx) {
        return createPrintStatement(ctx.var());
    }

    private SimpleStatement createPrintStatement(SaralParser.VarContext varContext) {
        Expression varRef = varContext.accept(new ExpressionVisitor(scope));
        String varName = ((VariableRef) varRef).name();

        Optional<LocalVariable> localVariableOption = scope.getLocalVariable(varName);
        if(!localVariableOption.isPresent()) {
            throw new VariableNotFound(scope, varName);
        }
        LocalVariable localVariable = localVariableOption.get();

        LocalVariable var;
        if(varRef instanceof ArrayRef) {
            var = new LocalVariableArrayIndex(localVariable.name(), localVariable.type(), localVariable.isInitialized(), ((ArrayRef) varRef).getIndex());
        } else {
            var = new LocalVariable(localVariable.name(), localVariable.type(), localVariable.isInitialized());
        }
        if(!var.isInitialized()) {
            throw new VariableNotInitialized(scope, var.name());
        }
        return new PrintStatement(var);
    }

    @Override
    public SimpleStatement visitVar_definition(SaralParser.Var_definitionContext ctx) {
        TerminalNode varName = ctx.ID();
        String variableName = varName.getText();
        String varType = ctx.type().typeBasic().getText();
        Type variableType = TypeResolver.getFromTypeName(varType);

        SaralParser.ExpressionContext expressionContext = ctx.expression();
        Expression expression = parseExpression(expressionContext, variableType, variableName);

        if(scope.existsLocalVariable(variableName)) {
            throw new VariableNameAlreadyExists(scope, variableName);
        }
        LocalVariable var = new LocalVariable(variableName, variableType, true);
        scope.addLocalVariable(var);
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

        if(scope.existsLocalVariable(variableName)) {
            throw new VariableNameAlreadyExists(scope, variableName);
        }
        LocalConstant var = new LocalConstant(variableName, variableType);
        scope.addLocalVariable(var);
        return new ConstantDeclaration(varName.getText(), expression);
    }

    private Expression parseExpression(SaralParser.ExpressionContext expressionContext, Type variableType, String variableName) {
        Expression expression = expressionContext.accept(new ExpressionVisitor(scope));
        if(variableType != expression.type()) {
            if(variableType == BuiltInType.DOUBLE && expression.type() == BuiltInType.LONG) {
                expression = new CastExpression(BuiltInType.DOUBLE, expression);
            } else if(variableType == BuiltInType.INT && expression.type() == BuiltInType.LONG) {
                expression = new CastExpression(BuiltInType.INT, expression);
            } else {
                throw new IncompatibleVariableTypeAssignment(scope, variableName, variableType, expression.type());
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

        Optional<Function> proc = scope.getFunction(functionName);
        if(!proc.isPresent()) {
            throw new FunctionNotFound(scope, functionName);
        }

        return new ProcedureCall(proc.get(), args);
    }

    @Override
    public SimpleStatement visitVar_declaration(SaralParser.Var_declarationContext ctx) {
        TerminalNode varName = ctx.ID();
        String varType = ctx.type().typeBasic().getText();
        Type type = TypeResolver.getFromTypeName(varType);
        String variableName = varName.getText();
        if(scope.existsLocalVariable(variableName)) {
            throw new VariableNameAlreadyExists(scope, variableName);
        }
        LocalVariable var = new LocalVariable(variableName, type, false);
        scope.addLocalVariable(var);
        return new VariableDeclaration(variableName);
    }

    @Override
    public SimpleStatement visitAssignment(SaralParser.AssignmentContext ctx) {
        Expression varRef = ctx.var().accept(new ExpressionVisitor(scope));
        String varName;
        if(varRef instanceof ArrayRef) {
            varName = ((ArrayRef) varRef).name();
        } else {
            varName = ((VariableRef) varRef).name();
        }
        Optional<LocalVariable> varOption = scope.getLocalVariable(varName);
        if(!varOption.isPresent()) {
            throw new VariableNotFound(scope, varName);
        }

        LocalVariable var = varOption.get();
        if(var.isConstant() && !(varRef instanceof ArrayRef) && var.type() != BuiltInType.STRING) {
            throw new ConstantAssignmentNotAllowed(scope, varName);
        }
        scope.initializeLocalVariableAtIndex(scope.getLocalVariableIndex(varName));
        SaralParser.ExpressionContext expressionContext = ctx.expression();
        Expression expression = expressionContext.accept(new ExpressionVisitor(scope));

        if(varRef instanceof ArrayRef) {
            Expression index = ((ArrayRef) varRef).getIndex();
            return new ArrayAssignment(varName, index, expression);
        } else {
            return new Assignment(varName, expression);
        }

    }

    @Override
    public SimpleStatement visitArray_declaration(SaralParser.Array_declarationContext ctx) {
        String varName = ctx.ID().getText();
        Type arrayType = TypeResolver.getArrayTypeFromTypeName(ctx.typeArray().typeBasic().getText());
        Expression arrayLength = ctx.expression().accept(new ExpressionVisitor(scope));
        if(arrayLength.type() != BuiltInType.LONG) {
            throw new IncompatibleTypeArrayLength(scope, varName, arrayLength.type());
        }
        if(scope.existsLocalVariable(varName)) {
            throw new VariableNameAlreadyExists(scope, varName);
        }
        LocalVariable var = new LocalVariable(varName, arrayType, true);
        scope.addLocalVariable(var);
        return new ArrayDeclaration(varName, arrayType, arrayLength);
    }

    @Override
    public SimpleStatement visitRead(SaralParser.ReadContext ctx) {
        return createReadStatement(ctx.var());
    }

    @Override
    public SimpleStatement visitRead2(SaralParser.Read2Context ctx) {
        return createReadStatement(ctx.var());
    }

    private SimpleStatement createReadStatement(SaralParser.VarContext ctx) {
        Expression varRef = ctx.accept(new ExpressionVisitor(scope));
        String varName = ((VariableRef) varRef).name();

        Optional<LocalVariable> localVariableOption = scope.getLocalVariable(varName);
        if(!localVariableOption.isPresent()) {
            throw new VariableNotFound(scope, varName);
        }
        LocalVariable localVariable = localVariableOption.get();
        LocalVariable initializedLocalVariable;
        if(varRef instanceof ArrayRef) {
            initializedLocalVariable = new LocalVariableArrayIndex(localVariable.name(), localVariable.type(), localVariable.isInitialized(), ((ArrayRef) varRef).getIndex());
        } else {
            initializedLocalVariable = new LocalVariable(localVariable.name(), localVariable.type(), true);
            scope.initializeLocalVariable(varName);
        }
        if(!initializedLocalVariable.isInitialized()) {
            throw new VariableNotInitialized(scope, initializedLocalVariable.name());
        }

        return new ReadStatement(initializedLocalVariable);
    }
}
