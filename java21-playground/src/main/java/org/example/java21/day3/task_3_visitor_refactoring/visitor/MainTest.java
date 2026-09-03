package org.example.java21.day3.task_3_visitor_refactoring.visitor;

public class MainTest {
    static void main(String[] args) {
        Payment payment = new Card("1234567890123456", 1000);

        int fee = payment.accept(new PaymentFeeVisitor());

        System.out.println(fee);
    }
}
