package org.example.java21.day3.task_3_visitor_refactoring.visitor;

public interface Payment {
    <R> R accept(PaymentVisitor<R> visitor);
}