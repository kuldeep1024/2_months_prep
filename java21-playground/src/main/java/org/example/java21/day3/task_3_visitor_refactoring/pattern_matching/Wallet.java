package org.example.java21.day3.task_3_visitor_refactoring.pattern_matching;

public record Wallet(
        String walletId,
        double amount
) implements Payment {
}