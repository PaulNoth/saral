package com.pidanic.saral;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class StatementVisitor extends SaralBaseVisitor<Instruction> {

    private Map<String, Variable> variables = new HashMap<>();

    @Override
    public Instruction visitPrint(SaralParser.PrintContext ctx) {
        TerminalNode varName = ctx.ID();
        boolean printVarNotDeclared = variables.containsKey(varName.getText());
        if(printVarNotDeclared) {
            String err = "You are trying to print var '%s' which has not been declared";
            System.out.printf(err, varName.getText());
        }
        Variable var = variables.get(varName.getText());
        //instructions.add(new PrintVariable(var));
        logPrintStatementFound(varName, var);
        return new PrintVariable(var);
    }

    @Override
    public Instruction visitVariable(SaralParser.VariableContext ctx) {
        TerminalNode varName = ctx.ID();
        SaralParser.ValueContext varValue = ctx.value();
        int varType = varValue.getStart().getType();
        int varIndex = variables.size();
        String varTextValue = varValue.getText();
        Variable var = new Variable(varIndex, varType, varTextValue);
        variables.put(varName.getText(), var);
        //instructions.add(new VariableDeclaration(var));
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
        System.out.printf(format, variable.getId(), variable.getValue(), line);
    }
}
