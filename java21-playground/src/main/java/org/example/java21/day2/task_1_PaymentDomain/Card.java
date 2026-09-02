package org.example.java21.day2.task_1_PaymentDomain;

public record Card(String cardNumber, double amount) implements PaymentMethod {

    public Card {
        if (cardNumber == null || cardNumber.length() != 16)
            throw new IllegalArgumentException("cardNumber cannot be null or less than 16 characters");

        if (amount < 0)
            throw new IllegalArgumentException("amount cannot be negative");
    }
}
