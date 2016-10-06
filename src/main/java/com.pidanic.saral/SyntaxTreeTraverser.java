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
        SaralLexer enkelLexer = new SaralLexer(charStream);
        CommonTokenStream commonTokenStream  = new CommonTokenStream(enkelLexer);
        SaralParser enkelParser = new SaralParser(commonTokenStream);
        SaralTreeWalkListener enkelTreeWalkListener = new SaralTreeWalkListener();

        BaseErrorListener errorListener = new SaralTreeWalkErrorListener();
        enkelParser.addParseListener(enkelTreeWalkListener);
        enkelParser.addErrorListener(errorListener);
        enkelParser.compilationUnit();
        return enkelTreeWalkListener.getInstructionsQueue();
    }
}
