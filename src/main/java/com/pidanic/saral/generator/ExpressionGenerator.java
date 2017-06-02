package com.pidanic.saral.generator;

import com.pidanic.saral.domain.Argument;
import com.pidanic.saral.domain.CalledArgument;
import com.pidanic.saral.domain.LocalVariable;
import com.pidanic.saral.domain.expression.*;
import com.pidanic.saral.domain.expression.compare.*;
import com.pidanic.saral.domain.expression.math.*;
import com.pidanic.saral.exception.FunctionCallNotFoundException;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.*;
import com.pidanic.saral.util.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Method;
import java.util.*;

public class ExpressionGenerator extends StatementGenerator {

    private MethodVisitor methodVisitor;
    private Scope scope;

    public ExpressionGenerator(MethodVisitor methodVisitor, Scope scope) {
        this.methodVisitor = methodVisitor;
        this.scope = scope;
    }

    public void generate(Value val) {
        final Type type = TypeResolver.getFromValue(val.getValue());
        if(type == BuiltInType.INT) {
            int value = Integer.valueOf(val.getValue());
            methodVisitor.visitIntInsn(Opcodes.BIPUSH, value);
        } else if(type == BuiltInType.BOOLEAN) {
            String boolValue = val.getValue();
            int value = BooleanUtils.convertToBooleanValue(boolValue);
            methodVisitor.visitIntInsn(Opcodes.BIPUSH, value);
        } else if(type == BuiltInType.STRING) {
            String stringValue = val.getValue();
            stringValue = StringUtils.removeStart(stringValue, "\"");
            stringValue = StringUtils.removeEnd(stringValue, "\"");
            methodVisitor.visitLdcInsn(stringValue);
        }
    }

    public void generate(VariableRef varRef) {
        String varName = varRef.getVarName();
        int index = scope.getVariableIndex(varName);
        LocalVariable localVariable = scope.getLocalVariable(varName);
        Type type = localVariable.getType();
        if (type == BuiltInType.INT) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, index);
        } else {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, index);
        }
    }

    public void generate(FunctionCall functionCall) {
        List<Argument> parameters = functionCall.getFunction().getArguments();
        List<CalledArgument> calledParameter = functionCall.getCalledArguments();
        for(int i = 0; i < parameters.size(); i++) {
            Argument param = parameters.get(i);
            CalledArgument callArg = calledParameter.get(i);
            String realLocalVariableName = callArg.getName();
            param.accept(this, realLocalVariableName);
        }
        //Type owner = functionCall.getFunction().getReturnType().orElse(new ClassType(scope.getClassName()));
        Type owner = new ClassType(scope.getClassName());
        String ownerDescription = owner.getInternalName();
        String functionName = functionCall.getFunction().getName();
        String methodDescriptor = getFunctionDescriptor(functionCall);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, ownerDescription, functionName, methodDescriptor, false);
    }

    public void generate(Argument parameter, String localVariableName) {
        Type type = TypeResolver.getFromTypeName(parameter.getType());
        int index = scope.getVariableIndex(localVariableName);
        if (type == BuiltInType.INT) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, index);
        } else {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, index);
        }
    }

    private String getFunctionDescriptor(FunctionCall functionCall) {
        return Optional.of(getDescriptorForFunctionInScope(functionCall))
                .orElse(getDescriptorForFunctionOnClasspath(functionCall))
                .orElseThrow(() -> new FunctionCallNotFoundException(functionCall));
    }

    private Optional<String> getDescriptorForFunctionInScope(FunctionCall functionCall) {
        return Optional.ofNullable(DescriptorFactory.getMethodDescriptor(functionCall.getFunction()));
    }

    private Optional<String> getDescriptorForFunctionOnClasspath(FunctionCall functionCall) {
        try {
            String functionName = functionCall.getFunction().getName();
            Collection<CalledArgument> parameters = functionCall.getCalledArguments();
            Type owner = functionCall.getFunction().getReturnType();
            //String className = owner.isPresent() ? owner.get().getName() : scope.getClassName();
            String className = scope.getClassName();
            Class<?> aClass = Class.forName(className);
            Method method = aClass.getMethod(functionName);
            String methodDescriptor = org.objectweb.asm.Type.getMethodDescriptor(method);
            return Optional.of(methodDescriptor);
        } catch (ReflectiveOperationException e) {
            return Optional.empty();
        }
    }

    public void generate(Addition expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(Opcodes.IADD);
    }

    public void generate(Substraction expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(Opcodes.ISUB);
    }

    public void generate(Multiplication expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(Opcodes.IMUL);
    }

    public void generate(Division expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(Opcodes.IDIV);
    }

    public void generate(Modulo expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(Opcodes.IREM);
    }

    public void generate(CompareExpression expression) {
        generateBinaryExpressionComponents(expression);
        CompareSign compareSign = expression.getCompareSign();
        Label endLabel = new Label();
        Label falseLabel = new Label();
        methodVisitor.visitJumpInsn(compareSign.getOpcode(), falseLabel);
        methodVisitor.visitInsn(Opcodes.ICONST_1);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);
        methodVisitor.visitLabel(falseLabel);
        methodVisitor.visitInsn(Opcodes.ICONST_0);
        methodVisitor.visitLabel(endLabel);
    }

    private void generateBinaryExpressionComponents(BinaryExpression expression) {
        Expression leftExpression = expression.getLeft();
        Expression rightExpression = expression.getRight();
        leftExpression.accept(this);
        rightExpression.accept(this);
    }
}
