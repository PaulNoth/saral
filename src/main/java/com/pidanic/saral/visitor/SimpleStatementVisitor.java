package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SimpleStatementVisitor extends SaralBaseVisitor<SimpleStatement> {

    private Scope scope;

    public SimpleStatementVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public SimpleStatement visitWrite(SaralParser.WriteContext ctx) {
        TerminalNode varName = ctx.ID();
        LocalVariable localVariable = scope.getLocalVariable(varName.getText());
        LocalVariable var = new LocalVariable(localVariable.getName(), localVariable.getType());
        return new PrintVariable(var);
    }

    @Override
    public SimpleStatement visitVariable(SaralParser.VariableContext ctx) {
        TerminalNode varName = ctx.ID();
        SaralParser.ValueContext varValue = ctx.value();
        String varType = ctx.TYPE().getText();
        String varTextValue = varValue.getText();
        LocalVariable var = new LocalVariable(varName.getText(), varType);
        scope.addVariable(var);
        return new VariableDeclaration(varName.getText(), varTextValue);
    }

}
