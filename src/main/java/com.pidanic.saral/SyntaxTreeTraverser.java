package com.pidanic.saral;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.Queue;

public class SyntaxTreeTraverser {
    public Queue<Instruction> getInstructions(String fileAbsolutePath) throws IOException{
        CharStream charStream = new ANTLRFileStream(fileAbsolutePath);
        SaralLexer saralLexer = new SaralLexer(charStream);
        CommonTokenStream commonTokenStream  = new CommonTokenStream(saralLexer);
        SaralParser saralParser = new SaralParser(commonTokenStream);
        SaralTreeWalkListener enkelTreeWalkListener = new SaralTreeWalkListener();

        BaseErrorListener errorListener = new SaralTreeWalkErrorListener();
        saralParser.addParseListener(enkelTreeWalkListener);
        saralParser.addErrorListener(errorListener);
        saralParser.compilationUnit();
        return enkelTreeWalkListener.getInstructionsQueue();
    }
}
