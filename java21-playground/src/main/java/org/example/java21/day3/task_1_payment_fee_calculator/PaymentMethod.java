package org.example.java21.day3.task_1_payment_fee_calculator;

public sealed interface PaymentMethod permits Card, BankTransfer, Wallet {
}

//Break the hierarchy deliberately
// public sealed interface PaymentMethod permits Card, BankTransfer

//Now Wallet is not permitted to implement PaymentMethod.
//We should get a compile-time error on:
//implements PaymentMethod because Wallet is not in the permits list.