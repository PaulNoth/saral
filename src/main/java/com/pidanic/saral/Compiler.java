package com.pidanic.saral;

import com.pidanic.saral.domain.Init;
import com.pidanic.saral.generator.ByteCodeGenerator;

import java.io.*;
import java.nio.file.Files;

public class Compiler {
    public static void main(String[] args) {
        new Compiler().compile(args);
    }

    public void compile(String[] args) {
        File file = new File(args[0]);
        String fileName = file.getName();
        String className = fileName.substring(0, fileName.lastIndexOf('.'));
        try {
            File preprocessedTempFile = new Preprocessor().preprocess(file);

            Init compilationUnit = new SaralCompilationUnitParser().getCompilationUnit(preprocessedTempFile, className);

            saveBytecodeToClassFile(compilationUnit);
            Files.delete(preprocessedTempFile.toPath());
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
