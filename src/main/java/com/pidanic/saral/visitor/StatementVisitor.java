package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.PrintVariable;
import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.Variable;
import com.pidanic.saral.domain.VariableDeclaration;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;
import org.antlr.v4.runtime.tree.TerminalNode;

public class StatementVisitor extends SaralBaseVisitor<Statement> {

    private Scope scope;

    public StatementVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Statement visitPrint(SaralParser.PrintContext ctx) {
        TerminalNode varName = ctx.ID();
        Variable var = scope.getLocalVariable(varName.getText());
        logPrintStatementFound(varName, var);
        return new PrintVariable(var);
    }

    @Override
    public Statement visitVariable(SaralParser.VariableContext ctx) {
        TerminalNode varName = ctx.ID();
        SaralParser.ValueContext varValue = ctx.value();
        int varType = varValue.getStart().getType();
        String varTextValue = varValue.getText();
        Variable var = new Variable(varName.getText(), varType, varTextValue);
        scope.addVariable(var);
        logVariableDeclarationStatementFound(varName, varValue);
        return new VariableDeclaration(var);
    }

    private void logVariableDeclarationStatementFound(TerminalNode varName, SaralParser.ValueContext varValue) {
        final int line = varName.getSymbol().getLine();
        final String format = "OK: You declared variable named '%s' with value of '%s' at line '%s'.\n";
        System.out.printf(format, varName, varValue.getText(), line);
    }

    private void logPrintStatementFound(TerminalNode varName, Variable variable) {
        final int line = varName.getSymbol().getLine();
        final String format = "OK: You instructed to print variable '%s' which has value of '%s' at line '%s'.'\n";
        System.out.printf(format, variable.getName(), variable.getValue(), line);
    }
}
