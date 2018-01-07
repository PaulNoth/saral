java -jar antlr-4.7.1.jar Saral.g4 -visitor -package com.pidanic.saral.grammar -encoding UTF8

mv Saral.tokens SaralBaseListener.java SaralBaseVisitor.java SaralLexer.java SaralLexer.tokens SaralListener.java SaralParser.java SaralVisitor.java Saral.interp SaralLexer.interp src/main/java/com/pidanic/saral/grammar