package com.pidanic.saral.domain;

import com.pidanic.saral.generator.StatementGenerator;

public interface Statement {
    void accept(StatementGenerator generator);
}