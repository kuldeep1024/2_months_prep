package org.example.java21.day3.pattern_matching;

sealed interface PaymentMethod
        permits Card, BankTransfer, Wallet {
}