package org.example.java21.day1.textBlock;

public class TextBlockWhitespaceEscaping {
    public static void main(String[] args) {
        // Using \ to suppress a new line, and \s to preserve trailing spaces
        String formatted = """
                This is a single long line split across \
                multiple lines in the source code for readability.\s
                Notice the trailing space preserved above using \\s.
                """;
        System.out.println(formatted);
    }
}