package com.pidanic.saral.generator;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.block.Argument;
import com.pidanic.saral.domain.expression.Expression;
import com.pidanic.saral.exception.ConstantAssignmentNotAllowed;
import com.pidanic.saral.exception.FunctionCallNotFound;
import com.pidanic.saral.exception.VariableNotInitialized;
import com.pidanic.saral.scope.LocalVariable;
import com.pidanic.saral.scope.LocalVariableArrayIndex;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.*;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class SimpleStatementGenerator extends StatementGenerator {

    private interface BooleanByteValue {
        void putOnStack();
    }

    private MethodVisitor methodVisitor;
    private Scope scope;
    private ExpressionGenerator expressionGenerator;

    public SimpleStatementGenerator(MethodVisitor methodVisitor, Scope scope) {
        super();
        this.methodVisitor = methodVisitor;
        this.scope = scope;
        this.expressionGenerator = new ExpressionGenerator(methodVisitor, scope);
    }

    public void generate(PrintStatement instruction) {
        final LocalVariable variable = instruction.getVariable();
        if(!variable.isInitialized()) {
            throw new VariableNotInitialized(scope, variable.name());
        }
        final Type type = variable.type();
        final int variableId = scope.getLocalVariableIndex(variable.name());
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        String descriptor = createPrintlnDescriptor(type);
        if(variable instanceof LocalVariableArrayIndex) {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, variableId);
            LocalVariableArrayIndex localArrayIndex = (LocalVariableArrayIndex) variable;
            Expression index = localArrayIndex.getIndex();
            index.accept(expressionGenerator);
            if(type == BuiltInType.STRING) {
                descriptor = "(C)V";
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/lang/String;", "charAt", "(I)C", false);
            } else {
                methodVisitor.visitInsn(type.getTypeSpecificOpcode().getLoad());
                if(type == BuiltInType.BOOLEAN_ARR) {
                    generateBooleanAsKleene(() -> {
                        methodVisitor.visitVarInsn(Opcodes.ALOAD, variableId);
                        index.accept(expressionGenerator);
                        methodVisitor.visitInsn(type.getTypeSpecificOpcode().getLoad());
                    });
                }
            }
        } else {
            methodVisitor.visitVarInsn(type.getTypeSpecificOpcode().getLoad(), variableId);
            if (type == BuiltInType.BOOLEAN) {
                generateBooleanAsKleene(() -> methodVisitor.visitVarInsn(type.getTypeSpecificOpcode().getLoad(), variableId));

            }
        }
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                "Ljava/io/PrintStream;", "println", descriptor, false);
    }

    public void generate(ReadStatement readStatement) {
        if(!scope.existsLocalVariable(LocalVariable.SYSTEM_IN)) {
            initializeSystemIn();
        }
        int systemInIndex = scope.getLocalVariableIndex(LocalVariable.SYSTEM_IN);

        final LocalVariable variable = readStatement.variable();
        if(!variable.isInitialized()) {
            throw new VariableNotInitialized(scope, variable.name());
        }
        if(variable.isConstant()) {
            throw new ConstantAssignmentNotAllowed(scope, variable.name());
        }
        final Type variableType = variable.type();
        final int variableId = scope.getLocalVariableIndex(variable.name());

        if(variable instanceof LocalVariableArrayIndex) {

            if (variableType == BuiltInType.BOOLEAN_ARR) {
                String tempVarName = "booleanTemp" + scope.localVariablesCount();
                scope.addLocalVariable(new LocalVariable(tempVarName, BuiltInType.BOOLEAN, true));

                int booleanTempIndex = scope.getLocalVariableIndex(tempVarName);

                methodVisitor.visitVarInsn(Opcodes.ALOAD, systemInIndex);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/util/Scanner;",
                        getScannerMethod(variableType), getScannerMethodReturnDescriptor(variableType), false);

                Label endLabel = new Label();
                Label pravdaLabel = new Label();
                Label osalLabel = new Label();
                Label skoroosalLabel = new Label();

                methodVisitor.visitInsn(Opcodes.DUP);

                methodVisitor.visitLdcInsn(Logic.PRAVDA.getStringValue());
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/lang/String;", "compareTo", "(Ljava/lang/String;)I", false);
                methodVisitor.visitJumpInsn(Opcodes.IFNE, skoroosalLabel);
                methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.PRAVDA.getIntValue());
                methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);

                methodVisitor.visitLabel(skoroosalLabel);
                methodVisitor.visitInsn(Opcodes.DUP);
                methodVisitor.visitLdcInsn(Logic.SKOROOSAL.getStringValue());
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/lang/String;", "compareTo", "(Ljava/lang/String;)I", false);

                methodVisitor.visitJumpInsn(Opcodes.IFNE, osalLabel);
                methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.SKOROOSAL.getIntValue());
                methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);

                methodVisitor.visitLabel(osalLabel);
                methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.OSAL.getIntValue());

                methodVisitor.visitLabel(endLabel);

                methodVisitor.visitVarInsn(Opcodes.ISTORE, booleanTempIndex);

                methodVisitor.visitVarInsn(Opcodes.ALOAD, variableId);
                LocalVariableArrayIndex localArrayIndex = (LocalVariableArrayIndex) variable;

                Expression index = localArrayIndex.getIndex();
                index.accept(expressionGenerator);

                methodVisitor.visitVarInsn(Opcodes.ILOAD, booleanTempIndex);
            } else {
                methodVisitor.visitVarInsn(Opcodes.ALOAD, variableId);
                LocalVariableArrayIndex localArrayIndex = (LocalVariableArrayIndex) variable;

                Expression index = localArrayIndex.getIndex();
                index.accept(expressionGenerator);

                methodVisitor.visitVarInsn(Opcodes.ALOAD, systemInIndex);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/util/Scanner;",
                        getScannerMethod(variableType), getScannerMethodReturnDescriptor(variableType), false);

                if (variableType == BuiltInType.CHAR_ARR) {
                    methodVisitor.visitInsn(Opcodes.ICONST_0);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/lang/String;", "charAt", "(I)C", false);
                }
            }

            methodVisitor.visitInsn(variableType.getTypeSpecificOpcode().getStore());
        } else {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, systemInIndex);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/util/Scanner;",
                    getScannerMethod(variableType), getScannerMethodReturnDescriptor(variableType), false);

            if (TypeResolver.isBoolean(variableType)) {
                Label endLabel = new Label();
                Label pravdaLabel = new Label();
                Label osalLabel = new Label();
                Label skoroosalLabel = new Label();

                methodVisitor.visitInsn(Opcodes.DUP);

                methodVisitor.visitLdcInsn(Logic.PRAVDA.getStringValue());
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/lang/String;", "compareTo", "(Ljava/lang/String;)I", false);
                methodVisitor.visitJumpInsn(Opcodes.IFNE, skoroosalLabel);
                methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.PRAVDA.getIntValue());
                methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);

                methodVisitor.visitLabel(skoroosalLabel);
                methodVisitor.visitInsn(Opcodes.DUP);
                methodVisitor.visitLdcInsn(Logic.SKOROOSAL.getStringValue());
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/lang/String;", "compareTo", "(Ljava/lang/String;)I", false);

                methodVisitor.visitJumpInsn(Opcodes.IFNE, osalLabel);
                methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.SKOROOSAL.getIntValue());
                methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);

                methodVisitor.visitLabel(osalLabel);
                methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.OSAL.getIntValue());

                methodVisitor.visitLabel(endLabel);
            }
            if (TypeResolver.isChar(variableType)) {
                methodVisitor.visitInsn(Opcodes.ICONST_0);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/lang/String;", "charAt", "(I)C", false);
            }
            methodVisitor.visitVarInsn(variableType.getTypeSpecificOpcode().getStore(), variableId);
        }
    }

    private void initializeSystemIn() {
        LocalVariable scanner = new LocalVariable(LocalVariable.SYSTEM_IN, BuiltInType.STRING, true);
        scope.addLocalVariable(scanner);

        int systemInIndex = scope.getLocalVariableIndex(LocalVariable.SYSTEM_IN);
        methodVisitor.visitTypeInsn(Opcodes.NEW, "Ljava/util/Scanner;");
        //methodVisitor.visitInsn(Opcodes.DUP);

        methodVisitor.visitVarInsn(Opcodes.ASTORE, systemInIndex);

        methodVisitor.visitVarInsn(Opcodes.ALOAD, systemInIndex);
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "Ljava/util/Scanner;", "<init>", "(Ljava/io/InputStream;)V", false);
    }

    private String getScannerMethod(Type variableType) {
        if(variableType == BuiltInType.LONG || variableType == BuiltInType.LONG_ARR) {
            return "nextLong";
        }
        if(variableType == BuiltInType.DOUBLE || variableType == BuiltInType.DOUBLE_ARR) {
            return "nextDouble";
        }
        return "next";
    }

    private String getScannerMethodReturnDescriptor(Type variableType) {
        if(variableType == BuiltInType.LONG || variableType == BuiltInType.LONG_ARR) {
            return "()" + BuiltInType.LONG.getDescriptor();
        }
        if(variableType == BuiltInType.DOUBLE || variableType == BuiltInType.DOUBLE_ARR) {
            return "()" + BuiltInType.DOUBLE.getDescriptor();
        }
        return "()" + BuiltInType.STRING.getDescriptor();
    }

    private String createPrintlnDescriptor(Type type) {
        String descriptor = "(" + type.getDescriptor() + ")V";
        if (type == BuiltInType.BOOLEAN) {
            descriptor = "(" + BuiltInType.STRING.getDescriptor() + ")V";
        } else if(type == BuiltInType.BOOLEAN_ARR) {
            descriptor = "(" + BuiltInType.STRING.getDescriptor() + ")V";
        } else if(type == BuiltInType.LONG_ARR) {
            descriptor = "(" + BuiltInType.LONG.getDescriptor() + ")V";
        } else if(type == BuiltInType.DOUBLE_ARR) {
            descriptor = "(" + BuiltInType.DOUBLE.getDescriptor() + ")V";
        } else if(type == BuiltInType.CHAR_ARR) {
            descriptor = "(" + BuiltInType.CHAR.getDescriptor() + ")V";
        } else if(type == BuiltInType.STRING_ARR) {
            descriptor = "(" + BuiltInType.STRING.getDescriptor() + ")V";
        }
        return descriptor;
    }

    private void generateBooleanAsKleene(BooleanByteValue valueOnStack) {
        Label endLabel = new Label();
        Label pravdaLabel = new Label();
        Label osalLabel = new Label();
        Label skoroosalLabel = new Label();

        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.PRAVDA.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, osalLabel);
        methodVisitor.visitLdcInsn(Logic.PRAVDA.getStringValue());
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);
        methodVisitor.visitLabel(osalLabel);

        // comparing value of the left expression if "false"
        valueOnStack.putOnStack();
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.OSAL.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, skoroosalLabel);
        methodVisitor.visitLdcInsn(Logic.OSAL.getStringValue());
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);

        methodVisitor.visitLabel(skoroosalLabel);
        methodVisitor.visitLdcInsn(Logic.SKOROOSAL.getStringValue());

        methodVisitor.visitLabel(endLabel);
    }

    public void generate(VariableDeclaration variableDeclaration) {
        final String variableName = variableDeclaration.getName();
        final int variableId = scope.getLocalVariableIndex(variableName);
        final Optional<Expression> expressionOption = variableDeclaration.getExpression();
        if(expressionOption.isPresent()) {
            Expression expression = expressionOption.get();
            expression.accept(expressionGenerator);
            final Type type = expression.type();
            methodVisitor.visitVarInsn(type.getTypeSpecificOpcode().getStore(), variableId);
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
        Type argumentType = parameter.getType();
        int index = scope.getLocalVariableIndex(localVariableName);
        if(TypeResolver.isArray(argumentType)) {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, index);
        } else {
            methodVisitor.visitVarInsn(argumentType.getTypeSpecificOpcode().getLoad(), index);
        }
    }

    private String getFunctionDescriptor(ProcedureCall functionCall) {
        return Optional.of(getDescriptorForFunctionInScope(functionCall))
                .orElse(getDescriptorForFunctionOnClasspath(functionCall))
                .orElseThrow(() -> new FunctionCallNotFound(functionCall));
    }

    private Optional<String> getDescriptorForFunctionInScope(ProcedureCall functionCall) {
        return Optional.ofNullable(DescriptorFactory.getMethodDescriptor(functionCall.getFunction()));
    }

    private Optional<String> getDescriptorForFunctionOnClasspath(ProcedureCall functionCall) {
        try {
            String functionName = functionCall.getFunction().getName();
            Collection<CalledArgument> parameters = functionCall.getCalledArguments();
            Type owner = functionCall.getFunction().getReturnType();
            //String className = owner.isPresent() ? owner.get().name() : scope.getClassName();
            String className = scope.getClassName();
            Class<?> aClass = Class.forName(className);
            Method method = aClass.getMethod(functionName);
            String methodDescriptor = org.objectweb.asm.Type.getMethodDescriptor(method);
            return Optional.of(methodDescriptor);
        } catch (ReflectiveOperationException e) {
            return Optional.empty();
        }
    }

    public void generate(Assignment assignment) {
        final String variableName = assignment.getName();
        final int variableId = scope.getLocalVariableIndex(variableName);
        final Optional<Expression> expressionOption = assignment.getExpression();
        if(assignment instanceof ArrayAssignment) {
            if(expressionOption.isPresent()) {
                Expression expression = expressionOption.get();
                methodVisitor.visitVarInsn(Opcodes.ALOAD, variableId);

                ((ArrayAssignment) assignment).getIndex().accept(expressionGenerator);
                expression.accept(expressionGenerator);

                LocalVariable localArray = scope.getLocalVariable(variableName);
                methodVisitor.visitInsn(localArray.type().getTypeSpecificOpcode().getStore());
            }
        } else {
            if(expressionOption.isPresent()) {
                Expression expression = expressionOption.get();
                expression.accept(expressionGenerator);
                final Type type = expression.type();
                methodVisitor.visitVarInsn(type.getTypeSpecificOpcode().getStore(), variableId);
            }
        }
    }

    public void generate(ArrayDeclaration array) {
        Type arrayType = array.getType();
        Expression arrayLength = array.getLength();
        arrayLength.accept(expressionGenerator);
        if(arrayType == BuiltInType.STRING_ARR) {
            methodVisitor.visitTypeInsn(arrayType.getTypeSpecificOpcode().getNew(), "Ljava/lang/String;");
        } else {
            methodVisitor.visitIntInsn(arrayType.getTypeSpecificOpcode().getNew(), arrayType.getTypeSpecificOpcode().getAsmType());
        }
        String name = array.getName();
        int variableIndex = scope.getLocalVariableIndex(name);
        methodVisitor.visitVarInsn(Opcodes.ASTORE, variableIndex);
    }
}
