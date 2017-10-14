package com.pidanic.saral.domain.block;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.VariableDeclaration;
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

    private List<Statement> block;
    private Expression from;
    private Expression to;
    private VariableDeclaration var;

    public ForStatement(Scope scope, VariableDeclaration var, Expression from, Expression to, List<Statement> block) {
        super(scope);
        this.var = var;
        this.from = from;
        this.to = to;
        if(block != null) {
            this.block = Collections.unmodifiableList(block);
        } else {
            this.block = Collections.emptyList();
        }
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((BlockStatementGenerator) generator).generate(this);
    }

    public Expression getFromExpression() {
        return from;
    }

    public Expression getToExpression() {
        return to;
    }

    public VariableDeclaration getVariable() {
        return var;
    }

    public List<Statement> getBlock() {
        return block;
    }
}
