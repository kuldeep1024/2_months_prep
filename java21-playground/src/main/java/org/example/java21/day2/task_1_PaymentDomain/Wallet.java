package org.example.java21.day2.task_1_PaymentDomain;

public record Wallet(String walletId, double amount) implements PaymentMethod {

    public Wallet {
        if (walletId == null || walletId.isBlank())
            throw new IllegalArgumentException("walletId cannot be null or blank");
        if (amount < 0)
            throw new IllegalArgumentException("amount cannot be negative");
    }
}
