import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Optional;

public class ExpressionGenerator {
    private MethodVisitor methodVisitor;
    private Scope scope;

    public ExpressionGenerator(MethodVisitor mw, Scope scope) {
        this.methodVisitor = mw;
        this.scope = scope;
    }

    public void generate(VarReference var) {
        String name = var.getVarName();
        int index = scope.getLocalVariableIndex(name);
        LocalVariable localVariable = scope.getLocalVariable(name);
        Type type = localVariable.getType();
        if(type == BuiltInType.INT) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, index);
        } else {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, index);
        }
    }

    public void generate(FunctionParameter param) {
        String name = param.getName();
        int index = scope.getLocalVariableIndex(name);
        Type type = param.getType();
        if(type == BuiltInType.INT) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, index);
        } else {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, index);
        }
    }

    public void generate(Value value) {
        Type type = value.getType();
        String stringValue = value.getValue();
        if(type == BuiltInType.INT) {
            methodVisitor.visitVarInsn(Opcodes.BIPUSH, Integer.parseInt(stringValue));
        } else if(type == BuiltInType.STRING) {
            stringValue = StringUtils.removeStart(stringValue, "\"");
            stringValue = StringUtils.removeEnd(stringValue, "\"");
            methodVisitor.visitLdcInsn(stringValue);
        }
    }

    public void generate(FunctionCall functionCall) {
        Collection<Expression> parameters = functionCall.getParameters();
        parameters.forEach(param -> param.accept(this));
        Type owner = functionCall.getOwner().orElse(new ClassType(scope.getClassName()));
        String methodDescriptor = getFunctionDescriptor(functionCall);
        String ownerDescriptor = owner.getInternalName();
        String funcName = functionCall.getFunctionName();
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, ownerDescriptor, funcName, methodDescriptor, false);
    }

    private String getFunctionDescriptor(FunctionCall functionCall) {
        return Optional.of(getDescriptorForFunctionInScope(functionCall))
                .orElse(getDescriptorForFunctionOnClasspath(functionCall))
                .orElseThrow(() -> new CalledFunctionDoesNotExistException(functionCall));
    }

    private Optional<String> getDescriptorForFunctionInScope(FunctionCall functionCall) {
        return Optional.ofNullable(DescriptorFactory.getMethodDescriptor(functionCall.getSignature()));
    }

    private Optional<String> getDescriptorForFunctionOnClasspath(FunctionCall functionCall) {
        try {
            String functionName = functionCall.getFunctionName();
            Collection<Expression> parameters = functionCall.getParameters();
            Optional<Type> owner = functionCall.getOwner();
            String className = owner.isPresent() ? owner.get().getName() : scope.getClassName();
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(functionName);
            String methodDescriptor = org.objectweb.asm.Type.getMethodDescriptor(method);
            return Optional.of(methodDescriptor);
        } catch(ReflectiveOperationException ex) {
            return Optional.empty();
        }
    }
}
