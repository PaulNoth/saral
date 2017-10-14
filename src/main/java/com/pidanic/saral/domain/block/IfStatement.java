package com.pidanic.saral.domain.block;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.exception.IncompatibleTypeIfElse;
import com.pidanic.saral.generator.BlockStatementGenerator;
import com.pidanic.saral.generator.StatementGenerator;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;

import java.util.Collections;
import java.util.List;

public class IfStatement extends BlockStatementImpl {
    private Expression booleanExpression;
    private List<Statement> trueBlock;
    private List<Statement> falseBlock;

    public IfStatement(Scope scope, Expression booleanExpression, List<Statement> trueBlock) {
        this(scope, booleanExpression, trueBlock, Collections.emptyList());
    }

    public IfStatement(Scope scope, Expression booleanExpression, List<Statement> trueBlock, List<Statement> falseBlock) {
        super(scope);
        if(booleanExpression.type() != BuiltInType.BOOLEAN) {
            throw new IncompatibleTypeIfElse(scope, booleanExpression.type().getName());
        }
        this.booleanExpression = booleanExpression;
        this.trueBlock = trueBlock;
        this.falseBlock = falseBlock;
        if(falseBlock == null) {
            this.falseBlock = Collections.emptyList();
        }
    }

    @Override
    public void accept(StatementGenerator generator) {
        ((BlockStatementGenerator) generator).generate(this);
    }

    public Expression getBooleanExpression() {
        return booleanExpression;
    }

    public List<Statement> getTrueBlock() {
        return Collections.unmodifiableList(trueBlock);
    }

    public List<Statement> getFalseBlock() {
        return Collections.unmodifiableList(falseBlock);
    }
}
