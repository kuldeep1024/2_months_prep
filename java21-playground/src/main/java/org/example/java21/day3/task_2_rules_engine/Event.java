package org.example.java21.day3.task_2_rules_engine;

public sealed interface Event permits OrderPlaced, PaymentFailed, ShipmentDelayed {
}