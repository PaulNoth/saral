package com.pidanic.saral;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class SaralCompilationUnitParser {
    public CompilationUnit getCompilationUnit(String fileAbsolutePath) throws IOException{
        CharStream charStream = new ANTLRFileStream(fileAbsolutePath);
        SaralLexer saralLexer = new SaralLexer(charStream);
        CommonTokenStream commonTokenStream  = new CommonTokenStream(saralLexer);
        SaralParser saralParser = new SaralParser(commonTokenStream);

        BaseErrorListener errorListener = new SaralTreeWalkErrorListener();
        saralParser.addErrorListener(errorListener);

        CompilationUnitVisitor cuVisitor = new CompilationUnitVisitor();
        return saralParser.compilationUnit().accept(cuVisitor);
    }
}
