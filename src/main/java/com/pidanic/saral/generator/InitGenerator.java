package com.pidanic.saral.generator;

import com.pidanic.saral.domain.*;
import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.block.BlockStatement;
import com.pidanic.saral.domain.block.CallableStatement;
import com.pidanic.saral.domain.block.Function;
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
        MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);


        List<Statement> instructionQueue = statements.getStatements();

        CallableStatementGenerator callableStatementGenerator = new CallableStatementGenerator(classWriter, scope);
        List<Function> functions = instructionQueue.stream()
                .filter(stmt -> stmt instanceof CallableStatement)
                .map(statement -> (Function) statement)
                .collect(Collectors.toList());
        functions.forEach(procedure -> procedure.accept(callableStatementGenerator));

        StatementGenerator simpleStatementGenerator = new SimpleStatementGenerator(mv, scope);
        StatementGenerator blockStatementGenerator = new BlockStatementGenerator(mv, scope);
        List<Statement> notCallableStatements = instructionQueue.stream()
                .filter(stmt -> !(stmt instanceof CallableStatement))
                .collect(Collectors.toList());
        for(Statement ins : notCallableStatements) {
            if(ins instanceof SimpleStatement) {
                ins.accept(simpleStatementGenerator);
            } else if (ins instanceof BlockStatement) {
                ins.accept(blockStatementGenerator);
            }
        }

        closeSystemInIfCreated(scope, mv);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(-1, -1);
        mv.visitEnd();

        classWriter.visitEnd();
        return classWriter;
    }

    private void closeSystemInIfCreated(Scope scope, MethodVisitor mv) {
        if(scope.existsLocalVariable(LocalVariable.SYSTEM_IN)) {
            int systemInIndex = scope.getVariableIndex(LocalVariable.SYSTEM_IN);
            mv.visitVarInsn(Opcodes.ALOAD, systemInIndex);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/util/Scanner;", "close", "()V", false);
        }
    }
}
