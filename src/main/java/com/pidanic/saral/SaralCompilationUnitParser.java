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

import java.io.IOException;

public class SaralCompilationUnitParser {
    public Statements getCompilationUnit(String fileAbsolutePath) throws IOException{
        CharStream charStream = new ANTLRFileStream(fileAbsolutePath);
        SaralLexer saralLexer = new SaralLexer(charStream);
        CommonTokenStream commonTokenStream  = new CommonTokenStream(saralLexer);
        SaralParser saralParser = new SaralParser(commonTokenStream);

        BaseErrorListener errorListener = new SaralTreeWalkErrorListener();
        saralParser.addErrorListener(errorListener);

        StatementsVisitor statementsVisitor = new StatementsVisitor();
        return saralParser.statements().accept(statementsVisitor);
    }
}
