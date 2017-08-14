package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.block.Function;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
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
        TerminalNode varName = ctx.var().ID();
        LocalVariable localVariable = scope.getLocalVariable(varName.getText());
        LocalVariable var = new LocalVariable(localVariable.getName(), localVariable.getType());
        return new PrintVariable(var);
    }

    @Override
    public SimpleStatement visitVar_definition(SaralParser.Var_definitionContext ctx) {
        TerminalNode varName = ctx.ID();
        SaralParser.ExpressionContext expressionContext = ctx.expression();
        Expression expression = expressionContext.accept(new ExpressionVisitor(scope));
        String varType = ctx.type().typeBasic().getText();
        Type type = TypeResolver.getFromTypeName(varType);
        LocalVariable var = new LocalVariable(varName.getText(), type);
        scope.addVariable(var);
        return new VariableDeclaration(varName.getText(), expression);
    }

    @Override
    public SimpleStatement visitProc_call(SaralParser.Proc_callContext ctx) {
        String procedureName = ctx.ID().getText();
        List<SaralParser.VarContext> calledParameters = ctx.paramlist().var();
        return createProcedureCall(procedureName, calledParameters);
    }

    private ProcedureCall createProcedureCall(String functionName, List<SaralParser.VarContext> calledParameters) {
        List<CalledArgument> args = calledParameters.stream()
                .map(param -> param.accept(new CalledArgumentVisitor()))
                .collect(Collectors.toList());

        Function proc = scope.getFunction(functionName);

        return new ProcedureCall(proc, args);
    }
}
