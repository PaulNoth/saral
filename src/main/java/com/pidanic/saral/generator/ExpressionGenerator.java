package com.pidanic.saral.generator;

import com.pidanic.saral.domain.block.Argument;
import com.pidanic.saral.domain.CalledArgument;
import com.pidanic.saral.domain.expression.string.Concatenation;
import com.pidanic.saral.exception.VariableNotFound;
import com.pidanic.saral.scope.LocalVariable;
import com.pidanic.saral.domain.expression.*;
import com.pidanic.saral.domain.expression.cast.CastExpression;
import com.pidanic.saral.domain.expression.logic.And;
import com.pidanic.saral.domain.expression.logic.Negation;
import com.pidanic.saral.domain.expression.logic.Or;
import com.pidanic.saral.domain.expression.math.*;
import com.pidanic.saral.exception.FunctionCallNotFound;
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

    private static final int NULL_CHAR = '\0';

    private MethodVisitor methodVisitor;
    private Scope scope;

    public ExpressionGenerator(MethodVisitor methodVisitor, Scope scope) {
        this.methodVisitor = methodVisitor;
        this.scope = scope;
    }

    public void generate(Value val) {
        final Type type = val.type();
        if(TypeResolver.isLong(type)) {
            Long value = Long.valueOf(val.getValue());
            methodVisitor.visitLdcInsn(value);
        } else if(TypeResolver.isBoolean(type)) {
            String boolValue = val.getValue();
            Integer value = Logic.getFromString(boolValue).getIntValue();
            methodVisitor.visitLdcInsn(value);
        } else if(TypeResolver.isDouble(type)) {
            Double value = Double.valueOf(val.getValue());
            methodVisitor.visitLdcInsn(value);
        } else if(TypeResolver.isChar(type)) {
            String stringValue = val.getValue();
            stringValue = StringUtils.removeStart(stringValue, "\'");
            stringValue = StringUtils.removeEnd(stringValue, "\'");
            Character charr = stringValue.charAt(0);
            methodVisitor.visitLdcInsn(charr);
        } else if(TypeResolver.isString(type)) {
            String stringValue = val.getValue();
            stringValue = StringUtils.removeStart(stringValue, "\"");
            stringValue = StringUtils.removeEnd(stringValue, "\"");
            methodVisitor.visitLdcInsn(stringValue);
        }
    }

    public void generate(VariableRef varRef) {
        String varName = varRef.name();
        int index = scope.getLocalVariableIndex(varName);

        Optional<LocalVariable> localVariable = scope.getLocalVariable(varName);
        if(!localVariable.isPresent()) {
            throw new VariableNotFound(scope, varName);
        }
        Type type = localVariable.get().type();
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
        Type type = parameter.getType();
        int index = scope.getLocalVariableIndex(localVariableName);
        methodVisitor.visitVarInsn(type.getTypeSpecificOpcode().getLoad(), index);
    }

    private String getFunctionDescriptor(FunctionCall functionCall) {
        return Optional.of(getDescriptorForFunctionInScope(functionCall))
                .orElse(getDescriptorForFunctionOnClasspath(functionCall))
                .orElseThrow(() -> new FunctionCallNotFound(functionCall));
    }

    private Optional<String> getDescriptorForFunctionInScope(FunctionCall functionCall) {
        return Optional.ofNullable(DescriptorFactory.getMethodDescriptor(functionCall.getFunction()));
    }

    private Optional<String> getDescriptorForFunctionOnClasspath(FunctionCall functionCall) {
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

    public void generate(Addition expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.type().getTypeSpecificOpcode().getAdd());
    }

    public void generate(Substraction expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.type().getTypeSpecificOpcode().getSubstract());
    }

    public void generate(Multiplication expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.type().getTypeSpecificOpcode().getMultiply());
    }

    public void generate(Division expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.type().getTypeSpecificOpcode().getDivide());
    }

    public void generate(Modulo expression) {
        generateBinaryExpressionComponents(expression);
        methodVisitor.visitInsn(expression.type().getTypeSpecificOpcode().getModulo());
    }

    public void generate(CompareExpression expression) {
        generateBinaryExpressionComponents(expression);
        Sign compareSign = expression.getSign();
        Label endLabel = new Label();
        Label falseLabel = new Label();
        Type leftExpressionType = expression.getLeft().type();
        if(leftExpressionType == BuiltInType.STRING || leftExpressionType == BuiltInType.CHAR) {
            methodVisitor.visitInsn(Opcodes.ISUB);
        } else if (leftExpressionType == BuiltInType.LONG) {
            methodVisitor.visitInsn(Opcodes.LCMP);
        } else if (leftExpressionType == BuiltInType.DOUBLE) {
            methodVisitor.visitInsn(Opcodes.DCMPG);
        }
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

        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.SKOROOSAL.getIntValue());
        Label endLabel = new Label();
        Label falseLabel = new Label();
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, falseLabel);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.SKOROOSAL.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);
        methodVisitor.visitLabel(falseLabel);
        expr.accept(this);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.PRAVDA.getIntValue());
        methodVisitor.visitInsn(Opcodes.IXOR);
        methodVisitor.visitLabel(endLabel);
    }

    public void generate(And expression) {
        generateBinaryExpressionComponents(expression);

        Label endLabel = new Label();
        Label falseLabel = new Label();
        Label falseLabel2 = new Label();
        Label falseLabel3 = new Label();
        // comparing value of the right expression it is "false"
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.OSAL.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, falseLabel);
        methodVisitor.visitInsn(Opcodes.POP);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.OSAL.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);

        methodVisitor.visitLabel(falseLabel);

        // comparing value of the right expression again it if it "true"
        expression.getRight().accept(this);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.PRAVDA.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, falseLabel2);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);
        methodVisitor.visitLabel(falseLabel2);

        // comparing value of the left expression if "false"
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.OSAL.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, falseLabel3);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.OSAL.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);

        methodVisitor.visitLabel(falseLabel3);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.SKOROOSAL.getIntValue());

        methodVisitor.visitLabel(endLabel);
    }

    public void generate(Or expression) {
        generateBinaryExpressionComponents(expression);

        Label endLabel = new Label();
        Label falseLabel = new Label();
        Label falseLabel2 = new Label();
        Label falseLabel3 = new Label();
        // comparing value of the right expression if "true"
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.PRAVDA.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, falseLabel);
        methodVisitor.visitInsn(Opcodes.POP);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.PRAVDA.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);

        methodVisitor.visitLabel(falseLabel);

        // comparing value of the right expression again if "false"
        expression.getRight().accept(this);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.OSAL.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, falseLabel2);

        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);
        methodVisitor.visitLabel(falseLabel2);

        // comparing value of the left expression if "true"
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.PRAVDA.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, falseLabel3);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.PRAVDA.getIntValue());
        methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);

        methodVisitor.visitLabel(falseLabel3);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, Logic.SKOROOSAL.getIntValue());

        methodVisitor.visitLabel(endLabel);
    }

    public void generate(UnaryMinus unaryMinus) {
        Expression expression = unaryMinus.getExpression();
        expression.accept(this);
        methodVisitor.visitInsn(expression.type().getTypeSpecificOpcode().getNegation());
    }

    public void generate(CastExpression castExpression) {
        Expression expression = castExpression.getExpression();
        expression.accept(this);
        methodVisitor.visitInsn(castExpression.getSign().getOpcode());
    }

    public void generate(ArrayRef arrayRef) {
        if(arrayRef.type() == BuiltInType.STRING) {
            int arrayIndex = scope.getLocalVariableIndex(arrayRef.name());
            methodVisitor.visitVarInsn(Opcodes.ALOAD, arrayIndex);

            Expression index = arrayRef.getIndex();
            index.accept(this);

            // duplicate index and reference
            index.accept(this);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, arrayIndex);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/lang/String;", "length", "()I", false);

            Label trueLabel = new Label();
            Label endLabel = new Label();
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, trueLabel);

            // throw away index
            methodVisitor.visitInsn(Opcodes.POP);
            // throw away reference
            methodVisitor.visitInsn(Opcodes.POP);
            methodVisitor.visitIntInsn(Opcodes.BIPUSH, NULL_CHAR);

            methodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);
            methodVisitor.visitLabel(trueLabel);
            // true label
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/lang/String;", "charAt", "(I)C", false);
            methodVisitor.visitLabel(endLabel);
        } else {
            int arrayIndex = scope.getLocalVariableIndex(arrayRef.name());
            Optional<LocalVariable> array = scope.getLocalVariable(arrayRef.name());
            if(!array.isPresent()) {
                throw new VariableNotFound(scope, arrayRef.name());
            }

            methodVisitor.visitVarInsn(Opcodes.ALOAD, arrayIndex);

            Expression index = arrayRef.getIndex();
            index.accept(this);

            methodVisitor.visitInsn(array.get().type().getTypeSpecificOpcode().getLoad());
        }
    }

    public void generate(Concatenation concatenation) {
        Expression left = concatenation.getLeft();
        Expression right = concatenation.getRight();
        left.accept(this);
        if(left.type() != BuiltInType.STRING) {
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/String",
                    "valueOf", "(" + left.type().getDescriptor() + ")Ljava/lang/String;", false);
        }
        right.accept(this);
        if(right.type() != BuiltInType.STRING) {
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/String",
                    "valueOf", "(" + right.type().getDescriptor() + ")Ljava/lang/String;", false);
        }
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String",
                "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
    }
}
