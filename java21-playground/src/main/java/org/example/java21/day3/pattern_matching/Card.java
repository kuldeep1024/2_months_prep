package org.example.java21.day3.pattern_matching;

record Card(String number) implements PaymentMethod {
    public int calculateCardFee() {
        //
        return 10;
    }
}