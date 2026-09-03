package org.example.java21.day3.pattern_matching;

record Wallet(String id) implements PaymentMethod {
    public int calculateWalletFee() {
        return 30;
    }
}