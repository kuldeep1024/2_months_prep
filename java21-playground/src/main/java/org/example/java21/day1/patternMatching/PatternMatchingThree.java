package org.example.java21.day1.patternMatching;

public class PatternMatchingThree {
    public static void checkEmployee(Object obj) {
        // Refactored from legacy instanceof + cast
        if (obj instanceof Employee emp) {
            System.out.println("Employee Name: " + emp.name);
        } else {
            System.out.println("Unknown entity");
        }
    }

    static class Employee {
        String name = "Alice";
    }

    public static void main(String[] args) {
        checkEmployee(new Employee());
        checkEmployee(new Object());
    }
}