package org.example.java21.day3.task_2_rules_engine;

public record OrderPlaced(String orderId, double amount) implements Event {
}