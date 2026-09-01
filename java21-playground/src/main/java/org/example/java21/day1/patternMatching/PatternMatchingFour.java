package org.example.java21.day1.patternMatching;

public class PatternMatchingFour {
    public static void evaluateShape(Object obj) {
        // Refactored from manual casting inside code block
        if (obj instanceof Circle c) {
            System.out.println("Circle radius: " + c.radius);
        } else {
            System.out.println("Not a circle");
        }
    }

    static class Circle {
        double radius = 5.5;
    }

    public static void main(String[] args) {
        evaluateShape(new Circle());
        evaluateShape(null);
    }
}