import java.io.File;
import java.util.Queue;

public class Compiler {
    public static void main(String[] args) throws Exception {
        new Compiler().compile(args);
    }

    public void compile(String[] args) throws Exception{
        File enkelFile = new File(args[0]);
        String fileName = enkelFile.getName();
        String fileAbsPath = enkelFile.getAbsolutePath();
        //String className = StringUtils.remove(fileName, ".enk");
        Queue<Instruction> instructionQueue = new SyntaxTreeTraverser().getInstructions(fileAbsPath);

        // TODO: generate bytecode
    }
}
