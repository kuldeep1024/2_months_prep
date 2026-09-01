package org.example.java21.day1.patternMatching;

public class PatternMatchingTwo {
    public static void processNumber(Object obj) {
        // Refactored from explicit instanceof check and cast inside body
        if (obj instanceof Integer i) {
            System.out.println("Square value: " + (i * i));
        } else {
            System.out.println("Not an integer");
        }
    }

    public static void main(String[] args) {
        processNumber(12);
        processNumber("Twelve");
    }
}