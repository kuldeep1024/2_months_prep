package org.example.java21.day3.task_1_payment_fee_calculator;

public record Wallet(String walletId, double amount)
        implements PaymentMethod {
}