package com.pidanic.saral.util;

import com.pidanic.saral.domain.block.Argument;
import com.pidanic.saral.domain.block.Function;
import com.pidanic.saral.domain.block.Procedure;

import java.util.Collection;
import java.util.stream.Collectors;

public class DescriptorFactory {
    public static String getMethodDescriptor(Procedure procedure) {
        Collection<Argument> arguments = procedure.getArguments();
        Type returnType = BuiltInType.VOID;
        return getMethodDescriptor(arguments, returnType);
    }

    public static String getMethodDescriptor(Function function) {
        Collection<Argument> arguments = function.getArguments();
        Type returnType = function.getReturnType();
        return getMethodDescriptor(arguments, returnType);
    }

    private static String getMethodDescriptor(Collection<Argument> args, Type retType) {
        String argumentDescriptor = args.stream()
                .map(arg -> arg.getType().getDescriptor())
                .collect(Collectors.joining("", "(", ")"));
        String returnTypeDescriptor = retType.getDescriptor();
        return argumentDescriptor + returnTypeDescriptor;
    }
}
