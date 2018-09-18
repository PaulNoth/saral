package com.pidanic.saral;

import com.pidanic.saral.domain.Init;
import com.pidanic.saral.error.SaralTreeWalkErrorListener;
import com.pidanic.saral.grammar.SaralLexer;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.visitor.InitVisitor;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;

public class SaralCompilationUnitParser {
    public Init getCompilationUnit(File preprocessedTempFile, String className) throws IOException{
        String fileAbsPath = preprocessedTempFile.getAbsolutePath();

        CharStream charStream = CharStreams.fromFileName(fileAbsPath);
        SaralLexer saralLexer = new SaralLexer(charStream);
        CommonTokenStream commonTokenStream  = new CommonTokenStream(saralLexer);
        SaralParser saralParser = new SaralParser(commonTokenStream);

        BaseErrorListener errorListener = new SaralTreeWalkErrorListener();
        saralParser.addErrorListener(errorListener);

        InitVisitor initVisitor = new InitVisitor(className);
        return saralParser.init().accept(initVisitor);
    }
}
