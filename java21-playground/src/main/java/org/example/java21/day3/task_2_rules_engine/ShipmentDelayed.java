package org.example.java21.day3.task_2_rules_engine;

public record ShipmentDelayed(String orderId, int delayHours) implements Event {
}