package com.pidanic.saral;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Queue;

public class Compiler {
    public static void main(String[] args) throws Exception {
        new Compiler().compile(args);
    }

    public void compile(String[] args) throws Exception{
        File saralFile = new File(args[0]);
        String fileName = saralFile.getName();
        String fileAbsPath = saralFile.getAbsolutePath();
        String className = fileName.substring(0, fileName.lastIndexOf('.'));
        Queue<Instruction> instructionQueue = new SyntaxTreeTraverser().getInstructions(fileAbsPath);

        byte[] bytecode = new ByteCodeGenerator().generateByteCode(instructionQueue, className);
        saveBytecodeToClassFile(fileName, bytecode);
    }

    private static void saveBytecodeToClassFile(String fileName, byte[] byteCode) throws IOException {
        final String classFile = fileName.substring(0, fileName.lastIndexOf('.')) + ".class";
        OutputStream os = new FileOutputStream(classFile);
        os.write(byteCode);
        os.close();
    }
}
