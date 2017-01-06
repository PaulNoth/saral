import java.util.Collection;
import java.util.stream.Collectors;

public class DescriptorFactory {
    public static String getMethodDescriptor(Function function) {
        Collection<FunctionParameter> arguments = function.getArguments();
        Type returnType = function.getReturnType();
        return getMethodDescriptor(arguments, returnType);
    }

    public static String getMethodDescriptor(FunctionSignature signature) {
        Collection<FunctionParameter> arguments = signature.getArguments();
        Type returnType = signature.getReturnType();
        return getMethodDescriptor(arguments, returnType);
    }

    private static String getMethodDescriptor(Collection<FunctionParameter> args, Type retType) {
        String argumentDescriptor = args.stream().map(arg -> arg.getType().getDescriptor())
                .collect(Collectors.joining("", "(", ")"));
        String returnTypeDescriptor = retType.getDescriptor();
        return argumentDescriptor + returnTypeDescriptor;
    }
}
