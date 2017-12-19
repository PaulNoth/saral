package com.pidanic.saral;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Preprocessor {
    private static final String INDENT = "__INDENT";
    private static final String DEDENT = "__DEDENT";
    private static final String INCLUDE = "falda";
    private static final String INCLUDE_DIR = "include";
    private static final String DEFAULT_EXTENSION = "srl";

    private Stack<Integer> indents = new Stack<>();

    public File preprocess(File file) throws IOException {
        Stream<String> lines = readLines(file);
        Stream<String> preprocessedLines = createIndentDedent(lines);

        Calendar now = Calendar.getInstance();
        File temp = File.createTempFile(String.valueOf(now.getTimeInMillis()), "." + DEFAULT_EXTENSION);
        BufferedWriter bos = new BufferedWriter(new FileWriter(temp));
        preprocessedLines.forEach(line -> {
            try {
                bos.write(line);
                bos.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bos.flush();
        bos.close();
        return temp;
    }

    private Stream<String> readLines(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<String> allLines = bufferedReader.lines().collect(Collectors.toList());
            allLines.add("");
            return expandIncludes(file, allLines.stream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Stream.empty();
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

    private Stream<String> createIndentDedent(Stream<String> lines) {
        Stream<String> linesWithIndentation = lines.filter(line -> !line.isEmpty()).map(line -> {
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
        return linesWithIndentation;
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

    private Stream<String> expandIncludes(File compiledFile, Stream<String> lines) {
        String relativePath = compiledFile.getPath();
        String relativeDir = relativePath.substring(0, relativePath.lastIndexOf(File.separator));
        return lines.flatMap(line -> {
            if(line.contains(INCLUDE)) {
                int indexOfFalda = line.indexOf(INCLUDE);
                String fileName = line.trim().substring(indexOfFalda + INCLUDE.length()).trim();
                File fileToRead = new File(getFaldaFilePath(INCLUDE_DIR, fileName));
                if(!fileToRead.exists()) {
                    fileToRead = new File(getFaldaFilePath(relativeDir, fileName));
                }
                return readLines(fileToRead);
            }
            else {
                return Stream.of(line);
            }
        });
    }

    private String getFaldaFilePath(String relativeDir, String fileName) {
        return relativeDir + File.separator +  fileName + "." + DEFAULT_EXTENSION;
    }
}
