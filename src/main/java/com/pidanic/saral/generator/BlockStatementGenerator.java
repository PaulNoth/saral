package com.pidanic.saral.generator;

import com.pidanic.saral.domain.IfStatement;
import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.scope.Scope;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public class BlockStatementGenerator extends StatementGenerator {

    private MethodVisitor methodVisitor;
    private Scope scope;

    public BlockStatementGenerator(MethodVisitor methodVisitor, Scope scope) {
        super();
        this.methodVisitor = methodVisitor;
        this.scope = scope;
    }

    public void generate(IfStatement ifStatement) {
        Scope scope = ifStatement.getScope();
        ExpressionGenerator expressionGenerator = new ExpressionGenerator(methodVisitor, scope);
        SimpleStatementGenerator simpleStatementGenerator = new SimpleStatementGenerator(methodVisitor, scope);

        Expression booleanExpression = ifStatement.getBooleanExpression();
        booleanExpression.accept(expressionGenerator);
        List<SimpleStatement> falseBlock = ifStatement.getFalseBlock();
        List<SimpleStatement> trueBlock = ifStatement.getTrueBlock();

        Label trueLabel = new Label();
        Label endLabel = new Label();
        methodVisitor.visitJumpInsn(Opcodes.IFNE, trueLabel);
        falseBlock.forEach(statement -> statement.accept(simpleStatementGenerator));
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);
        methodVisitor.visitLabel(trueLabel);
        trueBlock.forEach(statement -> statement.accept(simpleStatementGenerator));
        methodVisitor.visitLabel(endLabel);
    }
}
