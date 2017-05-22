package com.pidanic.saral.generator;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.domain.expression.FunctionCall;
import com.pidanic.saral.exception.FunctionCallNotFoundException;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.*;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class SimpleStatementGenerator extends StatementGenerator {

    private MethodVisitor methodVisitor;
    private Scope scope;
    private ExpressionGenerator expressionGenerator;

    public SimpleStatementGenerator(MethodVisitor methodVisitor, Scope scope) {
        super();
        this.methodVisitor = methodVisitor;
        this.scope = scope;
        this.expressionGenerator = new ExpressionGenerator(methodVisitor, scope);
    }

    public void generate(PrintVariable instruction) {
        final LocalVariable variable = instruction.getVariable();
        final Type type = variable.getType();
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
        final Expression expression = variableDeclaration.getExpression();
        final Type type = expression.getType();
        final int variableId = scope.getVariableIndex(variableName);
        expression.accept(expressionGenerator);
        if(type == BuiltInType.INT) {
            methodVisitor.visitVarInsn(Opcodes.ISTORE, variableId);
        } else if(type == BuiltInType.STRING) {
            methodVisitor.visitVarInsn(Opcodes.ASTORE, variableId);
        }
    }

     public void generate(ProcedureCall functionCall) {
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

    private String getFunctionDescriptor(ProcedureCall functionCall) {
        return Optional.of(getDescriptorForFunctionInScope(functionCall))
                .orElse(getDescriptorForFunctionOnClasspath(functionCall))
                .orElseThrow(() -> new FunctionCallNotFoundException(functionCall));
    }

    private Optional<String> getDescriptorForFunctionInScope(ProcedureCall functionCall) {
        return Optional.ofNullable(DescriptorFactory.getMethodDescriptor(functionCall.getFunction()));
    }

    private Optional<String> getDescriptorForFunctionOnClasspath(ProcedureCall functionCall) {
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
}
