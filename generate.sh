java -jar lib/antlr-4.7.1-complete.jar Saral.g4 -visitor -package com.pidanic.saral.grammar -encoding UTF8

mv Saral.tokens SaralBaseListener.java SaralBaseVisitor.java SaralLexer.java SaralLexer.tokens SaralListener.java SaralParser.java SaralVisitor.java src/main/java/com/pidanic/saral/grammar