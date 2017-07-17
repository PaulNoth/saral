package com.pidanic.saral.generator;

import com.pidanic.saral.domain.ReturnStatement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.Type;
import org.objectweb.asm.MethodVisitor;

public class ReturnStatementGenerator extends StatementGenerator {

    private final MethodVisitor methodVisitor;
    private final Scope scope;

    public ReturnStatementGenerator(Scope scope, MethodVisitor methodVisitor) {
        this.scope = scope;
        this.methodVisitor = methodVisitor;
    }

    public void generate(ReturnStatement retStatement) {
        Expression returnVariable = retStatement.getExpression();
        Type retType = returnVariable.getType();
        returnVariable.accept(new ExpressionGenerator(methodVisitor, scope));
        methodVisitor.visitInsn(retType.getTypeSpecificOpcode().getReturn());
    }
}
