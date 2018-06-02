package com.pidanic.saral.util;

import com.pidanic.saral.exception.VariableNameAlreadyExists;
import com.pidanic.saral.scope.LocalVariable;
import com.pidanic.saral.domain.block.Argument;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.scope.Scope;

import java.util.ArrayList;
import java.util.List;

public final class FunctionHelper {

    public static List<Argument> parseFunctionArguments(SaralParser.ArglistContext arglistContext, Scope scope) {
        List<Argument> arguments = new ArrayList<>();
        for(int i = 0; i < arglistContext.ID().size(); i++) {
            String argName = arglistContext.ID(i).getText();
            SaralParser.TypeContext typeContext = arglistContext.type(i);
            Type argType;
            if(typeContext.typeBasic() != null) {
                String argTypeName = typeContext.typeBasic().getText();
                argType = TypeResolver.getFromTypeName(argTypeName);
            } else {
                argType = TypeResolver.getArrayTypeFromTypeName(typeContext.typeArray().typeBasic().getText());
            }
            LocalVariable var = new LocalVariable(argName, argType, true);
            if(scope.existsLocalVariable(var.name())) {
                throw new VariableNameAlreadyExists(scope, var.name());
            }
            scope.addLocalVariable(var);
            arguments.add(new Argument(argName, argType));
        }
        return arguments;
    }
}
