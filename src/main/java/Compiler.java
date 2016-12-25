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

        CompilationUnit compilationUnit = new EnkelCompilationUnitParser().getCompilationUnit(fileAbsPath);

        saveBytecodeToClassFile(compilationUnit);
    }

    private static void saveBytecodeToClassFile(CompilationUnit compilationUnit) throws IOException {
        byte[] byteCode = new ByteCodeGenerator().generateByteCode(compilationUnit);
        final String classFile = compilationUnit.getClassName() + ".class";
        OutputStream os = new FileOutputStream(classFile);
        os.write(byteCode);
        os.close();
    }
}
