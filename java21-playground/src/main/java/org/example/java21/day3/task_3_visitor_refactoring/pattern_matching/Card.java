package org.example.java21.day3.task_3_visitor_refactoring.pattern_matching;

public record Card(
        String cardNumber,
        double amount
) implements Payment {
}