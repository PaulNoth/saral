package com.pidanic.saral;

import com.pidanic.saral.domain.Init;
import com.pidanic.saral.domain.Statements;
import com.pidanic.saral.generator.ByteCodeGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Compiler {
    public static void main(String[] args) throws Exception {
        new Compiler().compile(args);
    }

    public void compile(String[] args) throws Exception{
        File file = new File(args[0]);
        Init compilationUnit = new SaralCompilationUnitParser().getCompilationUnit(file);

        saveBytecodeToClassFile(compilationUnit);
    }

    private static void saveBytecodeToClassFile(Init compilationUnit) throws IOException {
        byte[] byteCode = new ByteCodeGenerator().generateByteCode(compilationUnit);
        String className = compilationUnit.getScope().getClassName();
        final String classFile = className + ".class";
        OutputStream os = new FileOutputStream(classFile);
        os.write(byteCode);
        os.close();
    }
}
