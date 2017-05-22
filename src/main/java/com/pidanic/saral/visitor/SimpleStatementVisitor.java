package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
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
        SaralParser.ValContext varValue = ctx.val();
        String varType = ctx.type().typeBasic().getText();
        String varTextValue = varValue.getText();
        LocalVariable var = new LocalVariable(varName.getText(), varType);
        scope.addVariable(var);
        return new VariableDeclaration(varName.getText(), varTextValue);
    }

    @Override
    public SimpleStatement visitProc_call(SaralParser.Proc_callContext ctx) {
        String procedureName = ctx.ID().getText();
        List<SaralParser.VarContext> calledParameters = ctx.paramlist().var();
        return createFunctionCall(procedureName, calledParameters);
    }

    @Override
    public SimpleStatement visitFunc_call(SaralParser.Func_callContext ctx) {
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
}
