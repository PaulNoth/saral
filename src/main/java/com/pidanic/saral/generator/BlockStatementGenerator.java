package com.pidanic.saral.generator;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.VariableDeclaration;
import com.pidanic.saral.domain.block.ForStatement;
import com.pidanic.saral.domain.block.IfStatement;
import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.domain.block.WhileStatement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.VariableRef;
import com.pidanic.saral.domain.expression.math.CompareExpression;
import com.pidanic.saral.domain.expression.math.CompareSign;
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

    public void generate(ForStatement forLoop) {
        Scope loopScope = forLoop.getScope();
        SimpleStatementGenerator simpleStatementGenerator = new SimpleStatementGenerator(methodVisitor, loopScope);
        ExpressionGenerator expressionGenerator = new ExpressionGenerator(methodVisitor, loopScope);

        VariableDeclaration iteratorVariable = forLoop.getVariable();
        Expression from = forLoop.getFromExpression();
        Expression to = forLoop.getToExpression();
        List<SimpleStatement> block = forLoop.getBlock();
        Expression iteratorVarRef = new VariableRef(iteratorVariable.getName(), from.type());

        Label incrementationSection = new Label();
        Label decrementationSection = new Label();
        Label endLoopSection = new Label();

        CompareExpression iteratorGreaterThanEndConditional = new CompareExpression(CompareSign.GREATER, iteratorVarRef, to);
        CompareExpression iteratorLessThanEndConditional = new CompareExpression(CompareSign.LESS, iteratorVarRef, to);

        int localVariableIndex = loopScope.getLocalVariableIndex(iteratorVariable.getName());
        iteratorVariable.accept(simpleStatementGenerator);

        //Pushes 0 or 1 onto the stack
        iteratorLessThanEndConditional.accept(expressionGenerator);
        // IFNE - is value on the stack (result of conditional) different than 0 (success)?
        methodVisitor.visitJumpInsn(Opcodes.IFNE, incrementationSection);

        //Decrementation section
        methodVisitor.visitLabel(decrementationSection);
        block.forEach(simpleStatement -> simpleStatement.accept(simpleStatementGenerator));
        decrementIteratorVariable(localVariableIndex);
        iteratorLessThanEndConditional.accept(expressionGenerator);
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, decrementationSection);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLoopSection);

        //Incrementation section
        methodVisitor.visitLabel(incrementationSection);
        block.forEach(simpleStatement -> simpleStatement.accept(simpleStatementGenerator));
        incrementIteratorVariable(localVariableIndex);
        iteratorGreaterThanEndConditional.accept(expressionGenerator); //is iterator greater than range end?
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, incrementationSection); //if it is not go back loop again
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLoopSection);

        methodVisitor.visitLabel(endLoopSection);
    }

    private void incrementIteratorVariable(int variableIndex) {
        methodVisitor.visitVarInsn(Opcodes.LLOAD, variableIndex);
        methodVisitor.visitInsn(Opcodes.LCONST_1);
        methodVisitor.visitInsn(Opcodes.LADD);
        methodVisitor.visitVarInsn(Opcodes.LSTORE, variableIndex);
    }

    private void decrementIteratorVariable(int variableIndex) {
        methodVisitor.visitVarInsn(Opcodes.LLOAD, variableIndex);
        methodVisitor.visitInsn(Opcodes.LCONST_1);
        methodVisitor.visitInsn(Opcodes.LSUB);
        methodVisitor.visitVarInsn(Opcodes.LSTORE, variableIndex);
    }

    public void generate(WhileStatement whileLoop) {
        Scope loopScope = whileLoop.getScope();
        SimpleStatementGenerator simpleStatementGenerator = new SimpleStatementGenerator(methodVisitor, loopScope);
        ExpressionGenerator expressionGenerator = new ExpressionGenerator(methodVisitor, loopScope);

        Expression expression = whileLoop.getExpression();
        List<Statement> block = whileLoop.getBlock();

        Label expressionSection = new Label();
        Label endLoopSection = new Label();

        methodVisitor.visitLabel(expressionSection);
        block.forEach(statement -> {
            if(statement instanceof SimpleStatement) {
                statement.accept(simpleStatementGenerator);
            } else {
                statement.accept(this);
            }
        });
        expression.accept(expressionGenerator);
        methodVisitor.visitJumpInsn(Opcodes.IFNE, expressionSection);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLoopSection);

        methodVisitor.visitLabel(endLoopSection);
    }
}
