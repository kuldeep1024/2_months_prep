package org.example.java21.day2.sealed_test;

public sealed interface PaymentMethod permits Card, BankTransfer, Wallet {
}

//A sealed interface restricts which classes can implement it.

//Only (Card, BankTransfer, Wallet) can directly implement it.

// sealed       Restricts inheritance.
// permits       Defines allowed implementations.
// non-sealed   Opens the hierarchy again.