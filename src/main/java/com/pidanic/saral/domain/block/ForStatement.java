package com.pidanic.saral.domain.block;

import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.domain.VariableDeclaration;
import com.pidanic.saral.domain.block.BlockStatementImpl;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.BlockStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import com.pidanic.saral.scope.Scope;

import java.util.Collections;
import java.util.List;

public class ForStatement extends BlockStatementImpl {
    public enum ForStatementPart {
        FROM, TO
    }

    private List<SimpleStatement> block;
    private Expression from;
    private Expression to;
    private VariableDeclaration var;

    public ForStatement(Scope scope, VariableDeclaration var, Expression from, Expression to, List<SimpleStatement> block) {
        super(scope);
        this.block = Collections.unmodifiableList(block);
        this.var = var;
        this.from = from;
        this.to = to;
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((BlockStatementGenerator) generator).generate(this);
    }
}
