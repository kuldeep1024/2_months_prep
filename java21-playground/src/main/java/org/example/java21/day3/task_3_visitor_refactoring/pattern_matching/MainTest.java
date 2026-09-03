package org.example.java21.day3.task_3_visitor_refactoring.pattern_matching;

public class MainTest {
    static void main(String[] args) {
        Payment payment = new Card("12345", 1000);

        PaymentProcessor processor = new PaymentProcessor();
        System.out.println(processor.calculateFee(payment));
    }
}
