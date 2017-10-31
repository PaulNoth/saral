package com.pidanic.saral;

import com.pidanic.saral.domain.Init;
import com.pidanic.saral.generator.ByteCodeGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class Compiler {
    public static void main(String[] args) throws Exception {
        new Compiler().compile(args);
    }

    public void compile(String[] args) throws Exception {
        File file = new File(args[0]);
        String fileName = file.getName();
        String className = fileName.substring(0, fileName.lastIndexOf('.'));
        File preprocessedTempFile = new Preprocessor().preprocess(file);
        Init compilationUnit = new SaralCompilationUnitParser().getCompilationUnit(preprocessedTempFile, className);

        saveBytecodeToClassFile(compilationUnit);
        Files.delete(preprocessedTempFile.toPath());
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
