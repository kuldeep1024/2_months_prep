package org.example.java21.day1.patternMatching;

public class PatternMatchingOne {
    public static void printStringDetails(Object obj) {
        // Refactored from: 
        // if (obj instanceof String) { String s = (String) obj; ... }
        if (obj instanceof String s) {
            System.out.println("Length: " + s.length());
        } else {
            System.out.println("Not a string");
        }
    }

    public static void main(String[] args) {
        printStringDetails("Hello Pattern Matching");
        printStringDetails(42);
    }
}