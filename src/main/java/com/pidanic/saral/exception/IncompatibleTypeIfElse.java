package com.pidanic.saral.exception;

import com.pidanic.saral.scope.Scope;

public class IncompatibleTypeIfElse extends RuntimeException {
    public IncompatibleTypeIfElse(Scope scope, String type) {
        super("if else statements are allowed only with boolean expressions. actual type " + type + ", found in scope " + scope);
    }
}
