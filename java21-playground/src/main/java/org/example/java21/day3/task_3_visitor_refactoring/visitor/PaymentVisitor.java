package org.example.java21.day3.task_3_visitor_refactoring.visitor;

public interface PaymentVisitor<R> {

    R visit(Card card);

    R visit(BankTransfer transfer);

    R visit(Wallet wallet);
}