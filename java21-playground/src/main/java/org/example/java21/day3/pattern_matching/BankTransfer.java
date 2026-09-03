package org.example.java21.day3.pattern_matching;

record BankTransfer(String account) implements PaymentMethod {
    public int calculateBankFee() {
        return 20;
    }
}