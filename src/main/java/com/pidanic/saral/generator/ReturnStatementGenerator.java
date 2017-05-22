package com.pidanic.saral.generator;

import com.pidanic.saral.domain.LocalVariable;
import com.pidanic.saral.domain.ReturnStatement;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ReturnStatementGenerator extends StatementGenerator {

    private final MethodVisitor methodVisitor;
    private final Scope scope;

    public ReturnStatementGenerator(Scope scope, MethodVisitor methodVisitor) {
        this.scope = scope;
        this.methodVisitor = methodVisitor;
    }

    public void generate(ReturnStatement retStatement) {
        Expression returnVariable = retStatement.getExpression();
        //String varName = returnVariable.getName();
        //int varIndex = scope.getVariableIndex(varName);
        Type retType = returnVariable.getType();
        returnVariable.accept(new ExpressionGenerator(methodVisitor, scope));
        if(retType == BuiltInType.INT) {
            //methodVisitor.visitVarInsn(Opcodes.ILOAD, varIndex);
            methodVisitor.visitInsn(Opcodes.IRETURN);
        } else {
            //methodVisitor.visitVarInsn(Opcodes.ALOAD, varIndex);
            methodVisitor.visitInsn(Opcodes.ARETURN);
        }
    }
}
