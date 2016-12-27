package com.pidanic.saral.visitor;

import com.pidanic.saral.domain.CompilationUnit;
import com.pidanic.saral.domain.Instruction;
import com.pidanic.saral.grammar.SaralBaseVisitor;
import com.pidanic.saral.grammar.SaralParser;

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
