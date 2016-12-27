package com.pidanic.saral;

import com.pidanic.saral.domain.CompilationUnit;
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
        File enkelFile = new File(args[0]);
        String fileName = enkelFile.getName();
        String fileAbsPath = enkelFile.getAbsolutePath();
        String className = fileName.substring(0, fileName.lastIndexOf('.'));

        CompilationUnit compilationUnit = new SaralCompilationUnitParser().getCompilationUnit(fileAbsPath);

        saveBytecodeToClassFile(compilationUnit, className);
    }

    private static void saveBytecodeToClassFile(CompilationUnit compilationUnit, String className) throws IOException {
        byte[] byteCode = new ByteCodeGenerator().generateByteCode(compilationUnit, className);
        final String classFile = className + ".class";
        OutputStream os = new FileOutputStream(classFile);
        os.write(byteCode);
        os.close();
    }
}
