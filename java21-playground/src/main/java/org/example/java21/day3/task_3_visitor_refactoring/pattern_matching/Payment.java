package org.example.java21.day3.task_3_visitor_refactoring.pattern_matching;

public sealed interface Payment
        permits Card, BankTransfer, Wallet {
}