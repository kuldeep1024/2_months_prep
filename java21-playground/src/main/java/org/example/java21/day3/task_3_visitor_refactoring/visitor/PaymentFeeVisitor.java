package org.example.java21.day3.task_3_visitor_refactoring.visitor;

public class PaymentFeeVisitor implements PaymentVisitor<Integer> {

    @Override
    public Integer visit(Card card) {
        return 20;
    }

    @Override
    public Integer visit(BankTransfer transfer) {
        return 10;
    }

    @Override
    public Integer visit(Wallet wallet) {
        return 5;
    }
}