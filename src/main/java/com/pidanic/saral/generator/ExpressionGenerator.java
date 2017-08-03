package com.pidanic.saral.generator;

import com.pidanic.saral.domain.Argument;
import com.pidanic.saral.domain.CalledArgument;
import com.pidanic.saral.domain.LocalVariable;
import com.pidanic.saral.domain.expression.*;
import com.pidanic.saral.domain.expression.logic.And;
import com.pidanic.saral.domain.expression.logic.Negation;
import com.pidanic.saral.domain.expression.logic.Or;
import com.pidanic.saral.domain.expression.math.*;
import com.pidanic.saral.exception.FunctionCallNotFoundException;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.*;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ExpressionGenerator extends StatementGenerator {

    private MethodVisitor methodVisitor;
    private Scope scope;

    public ExpressionGenerator(MethodVisitor methodVisitor, Scope scope) {
        this.methodVisitor = methodVisitor;
        this.scope = scope;
    }

    public void generate(Value val) {
        final Type type = val.getType();
        if(TypeResolver.isInteger(type)) {
            Long value = Long.valueOf(val.getValue());
            methodVisitor.visitLdcInsn(value);
        } else if(type == BuiltInType.BOOLEAN) {
            String boolValue = val.getValue();
            Integer value = BooleanUtils.convertToBooleanValue(boolValue);
            methodVisitor.visitLdcInsn(value);
        } else if(TypeResolver.isDouble(type)) {
            Double value = Double.valueOf(val.getValue());
            methodVisitor.visitLdcInsn(value);
        } else if(type == BuiltInType.CHAR) {
            String stringValue = val.getValue();
            stringValue = StringUtils.removeStart(stringValue, "\'");
            stringValue = StringUtils.removeEnd(stringValue, "\'");
            Character charr = stringValue.charAt(0);
            methodVisitor.visitLdcInsn(charr);
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
        methodVisitor.visitVarInsn(type.getTypeSpecificOpcode().getLoad(), index);
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
        methodVisitor.visitVarInsn(type.getTypeSpecificOpcode().getLoad(), index);
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
        methodVisitor.visitInsn(expression.getType().getTypeSpecificOpcode().getAdd());
    }

    public void generate(Substraction expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.getType().getTypeSpecificOpcode().getSubstract());
    }

    public void generate(Multiplication expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.getType().getTypeSpecificOpcode().getMultiply());
    }

    public void generate(Division expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.getType().getTypeSpecificOpcode().getDivide());
    }

    public void generate(Modulo expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.getType().getTypeSpecificOpcode().getModulo());
    }

    public void generate(CompareExpression expression) {
        generateBinaryExpressionComponents(expression);
        Sign compareSign = expression.getSign();
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

    public void generate(Negation expression) {
        Expression expr = expression.getExpression();
        expr.accept(this);

        //methodVisitor.visitInsn(expr.getType().getTypeSpecificOpcode().getNot());

        methodVisitor.visitInsn(Opcodes.ICONST_2);
        Label endLabel = new Label();
        Label falseLabel = new Label();
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, falseLabel);
        methodVisitor.visitInsn(Opcodes.ICONST_2);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);
        methodVisitor.visitLabel(falseLabel);
        expr.accept(this);
        methodVisitor.visitInsn(Opcodes.ICONST_1);
        methodVisitor.visitInsn(Opcodes.IXOR);
        methodVisitor.visitLabel(endLabel);
    }

    public void generate(And expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.getType().getTypeSpecificOpcode().getAnd());
        // TODO
    }

    public void generate(Or expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.getType().getTypeSpecificOpcode().getOr());
        // TODO
    }
}
