package com.pidanic.saral.domain.block;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.generator.BlockStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import com.pidanic.saral.scope.Scope;

import java.util.Collections;
import java.util.List;

public class WhileStatement extends BlockStatementImpl {

    private List<Statement> block;
    private Expression expression;

    public WhileStatement(Scope scope, Expression expression, List<Statement> block) {
        super(scope);
        this.expression = expression;
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

    public Expression getExpression() {
        return expression;
    }

    public List<Statement> getBlock() {
        return block;
    }
}
