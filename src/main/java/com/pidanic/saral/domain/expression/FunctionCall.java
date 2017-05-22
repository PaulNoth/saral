package com.pidanic.saral.domain.expression;

import com.pidanic.saral.domain.CalledArgument;
import com.pidanic.saral.domain.Function;
import com.pidanic.saral.generator.ExpressionGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionCall extends Expression {

    private Function function;
    private List<CalledArgument> arguments;

    public List<CalledArgument> getCalledArguments() {
        return Collections.unmodifiableList(arguments);
    }

    public Function getFunction() {
        return function;
    }

    public FunctionCall(Function function, List<CalledArgument> calledArguments) {
        super(function.getReturnType());
        this.function = function;
        this.arguments = new ArrayList<>(calledArguments);
    }


    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
