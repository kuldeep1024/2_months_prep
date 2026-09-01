package org.example.java21.day1.textBlock;

public class TextBlockMultiline {
    public static void main(String[] args) {
        String paragraph = """
                The quick brown fox jumps over the lazy dog.
                Text blocks make multi-line strings extremely clean
                by eliminating the need for explicit concatenation or \\n.
                """;
        System.out.println(paragraph);
    }
}