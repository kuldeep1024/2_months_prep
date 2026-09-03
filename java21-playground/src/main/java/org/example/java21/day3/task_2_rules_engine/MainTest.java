package org.example.java21.day3.task_2_rules_engine;

public class MainTest {
    public static void main(String[] args) {

        EventProcessor processor = new EventProcessor();

        System.out.println(processor.process(new OrderPlaced("ORD-1", 500)));

        System.out.println(processor.process(new PaymentFailed("ORD-2", 15000)));

        System.out.println(processor.process(new PaymentFailed("ORD-3", 500)));

        System.out.println(processor.process(new ShipmentDelayed("ORD-4", 30)));

        System.out.println(processor.process(new ShipmentDelayed("ORD-5", 5)));
    }
}
