package com.pidanic.saral;

import java.util.List;
import java.util.stream.Collectors;

public class CompilationUnitVisitor extends SaralBaseVisitor<CompilationUnit> {
    @Override
    public CompilationUnit visitCompilationUnit(SaralParser.CompilationUnitContext ctx) {
        StatementVisitor statementVisitor = new StatementVisitor();
        List<Instruction> instructionList = ctx.statement()
                .stream().map(statement -> statement.accept(statementVisitor))
                .collect(Collectors.toList());
        return new CompilationUnit(instructionList);
    }
}
