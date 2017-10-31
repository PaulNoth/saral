package com.pidanic.saral;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Preprocessor {
    private static final String INDENT = "__INDENT";
    private static final String DEDENT = "__DEDENT";

    public static void main(String[] args) {
        new Preprocessor().preprocess(new File("examples/while_loop.srl"));
    }

    private Stack<Integer> indents = new Stack<>();

    public void preprocess(File file) {
        List<String> lines = readLines(file);
        Stream<String> preprocessedLines = lines.stream().map(line -> {
            String spaces = getAllSpacesFromLineBeginning(line);

            int lineIndent = getIndentationCount(spaces);
            int previousIndent = indents.isEmpty() ? 0 : indents.peek();
            String newLine = line;
            if(lineIndent > previousIndent) {
                newLine = newLine.replaceAll("^\\s+", INDENT);
                indents.push(lineIndent);
            } else if (lineIndent < previousIndent) {
                while(!indents.isEmpty() && indents.peek() > lineIndent) {
                    newLine = newLine.replaceAll("^\\s*", DEDENT);
                    indents.pop();
                }
            }
            return newLine;
        });
        System.out.println(preprocessedLines.collect(Collectors.joining("\n")));
    }

    private List<String> readLines(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<String> allLines = bufferedReader.lines().collect(Collectors.toList());
            allLines.add("");
            return allLines;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * Calculates the indentation of the provided spaces, taking the
     * following rules into account:
     *
     * "Tabs are replaced (from left to right) by one to eight spaces
     *  such that the total number of characters up to and including
     *  the replacement is a multiple of eight [...]"
     */
    private static int getIndentationCount(String spaces) {
        int count = 0;

        for(char ch : spaces.toCharArray()) {
            switch(ch) {
                case '\t':
                    count += 8 - (count % 8);
                    break;
                default:
                    count++;
            }
        }
        return count;
    }

    private String getAllSpacesFromLineBeginning(String line) {
        int index = 0;
        while(index < line.length()) {
            if(line.charAt(index) != ' ' && line.charAt(index) != '\t') {
                break;
            }
            index++;
        }
        return line.substring(0, index);
    }
}
