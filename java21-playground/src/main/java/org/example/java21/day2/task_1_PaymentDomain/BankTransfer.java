package org.example.java21.day2.task_1_PaymentDomain;

public record BankTransfer(String accountNumber, double amount) implements PaymentMethod {
    public BankTransfer {

        if (accountNumber == null || accountNumber.isBlank())
            throw new IllegalArgumentException("accountNumber cannot be null or blank");
        if (amount < 0)
            throw new IllegalArgumentException("amount cannot be negative");
    }
}
