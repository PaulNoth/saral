package com.pidanic.saral.generator;

import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.block.Function;
import com.pidanic.saral.domain.ReturnStatement;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.DescriptorFactory;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Collection;
import java.util.Optional;

public class CallableStatementGenerator extends StatementGenerator {

    private final ClassWriter classWriter;
    private final Scope scope;

    public CallableStatementGenerator(ClassWriter classWriter, Scope scope) {
        super();
        this.classWriter = classWriter;
        this.scope = scope;
    }

    public void generate(Function function) {
        Scope scope = function.getScope();
        String procedureName = function.getName();

        String descriptor = DescriptorFactory.getMethodDescriptor(function);
        Collection<Statement> statements = function.getStatements();
        int access = Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC;
        MethodVisitor mw = classWriter.visitMethod(access, procedureName, descriptor, null, null);
        mw.visitCode();

        StatementGenerator simpleStatementGenerator = new SimpleStatementGenerator(mw, scope);
        StatementGenerator statementGenerator = new BlockStatementGenerator(mw, scope);
        statements.forEach(statement -> {
            if(statement instanceof SimpleStatement) {
                statement.accept(simpleStatementGenerator);
            } else {
                statement.accept(statementGenerator);
            }
        });

        Optional<ReturnStatement> ret = function.getReturnStatement();
        generateReturnStatement(scope, mw, ret);
    }

    private void generateReturnStatement(Scope scope, MethodVisitor mw, Optional<ReturnStatement> returnStatement) {
        ReturnStatementGenerator returnStatementGenerator = new ReturnStatementGenerator(scope, mw);
        if(returnStatement.isPresent()) {
            returnStatementGenerator.generate(returnStatement.get());
        } else {
            mw.visitInsn(Opcodes.RETURN);
        }
        mw.visitMaxs(-1, -1);
        mw.visitEnd();
    }
}
