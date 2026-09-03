package org.example.java21.day3.task_3_visitor_refactoring.pattern_matching;

public class PaymentProcessor {

    public int calculateFee(Payment payment) {

        return switch (payment) {

            case Card(String cardNumber, double amount) -> 20;

            case BankTransfer(String accountNumber, double amount) -> 10;

            case Wallet(String walletId, double amount) -> 5;
        };
    }
}