package com.pidanic.saral.generator;

import com.pidanic.saral.domain.Statement;
import com.pidanic.saral.domain.Statements;
import com.pidanic.saral.scope.Scope;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public class StatementsGenerator {

    private ClassWriter classWriter;

    public StatementsGenerator(ClassWriter classWriter) {
        this.classWriter = classWriter;
    }

    public ClassWriter generate(Statements statements) {
        Scope scope = statements.getScope();
        MethodVisitor mw = classWriter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

        List<Statement> instructionQueue = statements.getStatements();
        StatementGenerator statementGenerator = new StatementGenerator(mw, scope);
        for(Statement ins : instructionQueue) {
            ins.accept(statementGenerator);
        }

        mw.visitInsn(Opcodes.RETURN);
        mw.visitMaxs(-1, -1);
        mw.visitEnd();

        classWriter.visitEnd();
        return classWriter;
    }
}
