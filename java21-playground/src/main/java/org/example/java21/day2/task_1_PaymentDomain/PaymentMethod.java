package org.example.java21.day2.task_1_PaymentDomain;

public sealed interface PaymentMethod permits Card, Wallet, BankTransfer {
}
