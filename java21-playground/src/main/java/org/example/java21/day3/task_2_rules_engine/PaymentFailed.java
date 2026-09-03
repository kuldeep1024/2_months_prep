package org.example.java21.day3.task_2_rules_engine;

public record PaymentFailed(String orderId, double amount) implements Event {
}