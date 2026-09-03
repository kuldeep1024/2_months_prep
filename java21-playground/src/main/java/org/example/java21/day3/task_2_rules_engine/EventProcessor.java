package org.example.java21.day3.task_2_rules_engine;

public class EventProcessor {

    public String process(Event event) {

        return switch (event) {

            case OrderPlaced o -> "Order placed: " + o.orderId();

            case PaymentFailed p when p.amount() > 10000 -> "Escalate immediately";

            case PaymentFailed p -> "Retry payment";

            case ShipmentDelayed s when s.delayHours() > 24 -> "Escalate shipment delay";

            case ShipmentDelayed s -> "Notify customer about delay";
        };
    }
}