package org.example.java21.day3.task_1_payment_fee_calculator;

public record Card(String cardNumber, double amount)
        implements PaymentMethod {
}