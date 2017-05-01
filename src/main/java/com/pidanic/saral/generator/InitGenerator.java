package com.pidanic.saral.generator;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.scope.Scope;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.stream.Collectors;

public class InitGenerator {

    private ClassWriter classWriter;

    public InitGenerator(ClassWriter classWriter) {
        this.classWriter = classWriter;
    }

    public ClassWriter generate(Init statements) {
        Scope scope = statements.getScope();
        MethodVisitor mw = classWriter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);


        List<Statement> instructionQueue = statements.getStatements();

        BlockStatementGenerator blockStatementGenerator = new BlockStatementGenerator(classWriter, scope);
        List<BlockStatement> procedures = instructionQueue.stream()
                .filter(stmt -> stmt instanceof BlockStatement)
                .map(statement -> (BlockStatement) statement)
                .collect(Collectors.toList());
        procedures.forEach(procedure -> procedure.accept(blockStatementGenerator));

        StatementGenerator statementGenerator = new SimpleStatementGenerator(mw, scope);
        List<SimpleStatement> simpleStatements = instructionQueue.stream()
                .filter(stmt -> stmt instanceof SimpleStatement)
                .map(statement -> (SimpleStatement) statement)
                .collect(Collectors.toList());
        for(Statement ins : simpleStatements) {
            ins.accept(statementGenerator);
        }

        mw.visitInsn(Opcodes.RETURN);
        mw.visitMaxs(-1, -1);
        mw.visitEnd();

        classWriter.visitEnd();
        return classWriter;
    }
}
