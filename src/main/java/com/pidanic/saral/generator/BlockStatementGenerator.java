package com.pidanic.saral.generator;


import com.pidanic.saral.domain.Procedure;
import com.pidanic.saral.domain.SimpleStatement;
import com.pidanic.saral.scope.Scope;
import com.pidanic.saral.util.DescriptorFactory;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Collection;

public class BlockStatementGenerator extends StatementGenerator {

    private final ClassWriter classWriter;
    private final Scope scope;

    public BlockStatementGenerator(ClassWriter classWriter, Scope scope) {
        super();
        this.classWriter = classWriter;
        this.scope = scope;
    }

    public void generate(Procedure procedure) {
        Scope scope = procedure.getScope();
        String procedureName = procedure.getName();

        String descriptor = DescriptorFactory.getMethodDescriptor(procedure);
        Collection<SimpleStatement> statements = procedure.getSimpleStatements();
        int access = Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC;
        MethodVisitor mw = classWriter.visitMethod(access, procedureName, descriptor, null, null);
        mw.visitCode();

        StatementGenerator statementGenerator = new SimpleStatementGenerator(mw, scope);
        statements.forEach(statement -> statement.accept(statementGenerator));
        mw.visitInsn(Opcodes.RETURN);
        mw.visitMaxs(-1, -1);
        mw.visitEnd();
    }
}
