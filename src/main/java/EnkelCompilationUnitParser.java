import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class EnkelCompilationUnitParser {
    public CompilationUnit getCompilationUnit(String fileAbsolutePath) throws IOException{
        CharStream charStream = new ANTLRFileStream(fileAbsolutePath);
        EnkelLexer enkelLexer = new EnkelLexer(charStream);
        CommonTokenStream commonTokenStream  = new CommonTokenStream(enkelLexer);
        EnkelParser enkelParser = new EnkelParser(commonTokenStream);

        BaseErrorListener errorListener = new EnkelTreeWalkErrorListener();
        enkelParser.addErrorListener(errorListener);

        CompilationUnitVisitor cuVisitor = new CompilationUnitVisitor();
        return enkelParser.compilationUnit().accept(cuVisitor);
    }
}
