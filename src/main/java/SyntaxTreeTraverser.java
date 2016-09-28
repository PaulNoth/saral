import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.Queue;

public class SyntaxTreeTraverser {
    public Queue<Instruction> getInstructions(String fileAbsolutePath) throws IOException{
        CharStream charStream = new ANTLRFileStream(fileAbsolutePath);
        EnkelLexer enkelLexer = new EnkelLexer(charStream);
        CommonTokenStream commonTokenStream  = new CommonTokenStream(enkelLexer);
        EnkelParser enkelParser = new EnkelParser(commonTokenStream);
        EnkelTreeWalkListener enkelTreeWalkListener = new EnkelTreeWalkListener();

        BaseErrorListener errorListener = new EnkelTreeWalkErrorListener();
        enkelParser.addParseListener(enkelTreeWalkListener);
        enkelParser.addErrorListener(errorListener);
        enkelParser.compilationUnit();
        return enkelTreeWalkListener.getInstructionsQueue();
    }
}
