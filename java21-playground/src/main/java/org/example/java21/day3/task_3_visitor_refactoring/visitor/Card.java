package org.example.java21.day3.task_3_visitor_refactoring.visitor;

public record Card(String cardNumber, double amount)
        implements Payment {

    @Override
    public <R> R accept(PaymentVisitor<R> visitor) {
        return visitor.visit(this);
    }
}