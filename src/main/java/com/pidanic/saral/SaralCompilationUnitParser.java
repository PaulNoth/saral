package com.pidanic.saral;

import com.pidanic.saral.domain.Statements;
import com.pidanic.saral.error.SaralTreeWalkErrorListener;
import com.pidanic.saral.grammar.SaralLexer;
import com.pidanic.saral.grammar.SaralParser;
import com.pidanic.saral.visitor.StatementsVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.IOException;

public class SaralCompilationUnitParser {
    public Statements getCompilationUnit(File file) throws IOException{
        String fileName = file.getName();
        String fileAbsPath = file.getAbsolutePath();
        String className = fileName.substring(0, fileName.lastIndexOf('.'));

        CharStream charStream = new ANTLRFileStream(fileAbsPath);
        SaralLexer saralLexer = new SaralLexer(charStream);
        CommonTokenStream commonTokenStream  = new CommonTokenStream(saralLexer);
        SaralParser saralParser = new SaralParser(commonTokenStream);

        BaseErrorListener errorListener = new SaralTreeWalkErrorListener();
        saralParser.addErrorListener(errorListener);

        StatementsVisitor statementsVisitor = new StatementsVisitor(className);
        return saralParser.statements().accept(statementsVisitor);
    }
}
