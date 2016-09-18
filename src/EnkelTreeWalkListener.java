import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class EnkelTreeWalkListener extends EnkelBaseListener {
    Queue<Instruction> instructionsQueue = new ArrayDeque<>();
    Map<String, Variable> variables = new HashMap<>();

    @Override
    public void exitVariable(EnkelParser.VariableContext ctx) {
        TerminalNode varName = ctx.ID();
        EnkelParser.ValueContext varValue = ctx.value();
        int varType = varValue.getStart().getType();
        int varIndex = variables.size();
        String varTextValue = varValue.getText();
        Variable var = new Variable(varIndex, varType, varTextValue);
        variables.put(varName.getText(), var);
        instructionsQueue.add(new VariableDeclaration(var));
        logVariableDeclarationStatementFound(varName, varValue);
    }

    @Override
    public void exitPrint(EnkelParser.PrintContext ctx) {
        TerminalNode varName = ctx.ID();
        boolean printVarNotDeclared = variables.containsKey(varName.getText());
        if(printVarNotDeclared) {
            String err = "You are trying to print var '%s' which has not been declared";
            System.out.printf(err, varName.getText());
        }
        Variable var = variables.get(varName.getText());
        instructionsQueue.add(new PrintVariable(var));
        logPrintStatementFound(varName, var);
    }

    private void logVariableDeclarationStatementFound(TerminalNode varName, EnkelParser.ValueContext varValue) {
        final int line = varName.getSymbol().getLine();
        final String format = "OK: You declared variable named '%s' with value of '%s' at line '%s'.\n";
        System.out.printf(format, varName, varValue.getText(), line);
    }

    private void logPrintStatementFound(TerminalNode varName, Variable variable) {
        final int line = varName.getSymbol().getLine();
        final String format = "OK: You instructed to print variable '%s' which has value of '%s' at line '%s'.'\n";
        System.out.printf(format, variable.getId(), variable.getValue(), line);
    }

    public Queue<Instruction> getInstructionsQueue() {
        return instructionsQueue;
    }
}