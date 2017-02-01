package com.pidanic.saral.generator;

import com.pidanic.saral.domain.LocalVariable;
import com.pidanic.saral.domain.PrintVariable;
import com.pidanic.saral.domain.VariableDeclaration;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.BuiltInType;
import com.pidanic.saral.util.Type;
import com.pidanic.saral.util.TypeResolver;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class SimpleStatementGenerator extends StatementGenerator {

    private MethodVisitor methodVisitor;
    private Scope scope;

    public SimpleStatementGenerator(MethodVisitor methodVisitor, Scope scope) {
        super();
        this.methodVisitor = methodVisitor;
        this.scope = scope;
    }

    public void generate(PrintVariable instruction) {
        final LocalVariable variable = instruction.getVariable();
        final String typeName = variable.getType();
        final Type type = TypeResolver.getFromTypeName(typeName);
        final int variableId = scope.getVariableIndex(variable.getName());
        String descriptor = "(" + type.getDescriptor() + ")V";
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        if (type == BuiltInType.INT) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, variableId);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                    "java/io/PrintStream", "println", descriptor, false);
        } else if (type == BuiltInType.STRING) {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, variableId);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                    "java/io/PrintStream", "println", descriptor, false);
        }
    }

    public void generate(VariableDeclaration variableDeclaration) {
        final String variableName = variableDeclaration.getName();
        final Type type = TypeResolver.getFromValue(variableDeclaration.getValue());
        final int variableId = scope.getVariableIndex(variableName);
        if(type == BuiltInType.INT) {
            int val = Integer.valueOf(variableDeclaration.getValue());
            methodVisitor.visitIntInsn(Opcodes.BIPUSH, val);
            methodVisitor.visitVarInsn(Opcodes.ISTORE, variableId);
        } else if(type == BuiltInType.STRING) {
            String stringValue = variableDeclaration.getValue();
            stringValue = StringUtils.removeStart(stringValue, "\"");
            stringValue = StringUtils.removeEnd(stringValue, "\"");
            methodVisitor.visitLdcInsn(stringValue);
            methodVisitor.visitVarInsn(Opcodes.ASTORE, variableId);
        }
    }
}
