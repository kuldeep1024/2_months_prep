package org.example.java21.day3.record_patterns;

public class MainTest {
    static void main(String[] args) {
        Customer cust = new Customer("kuldeep", "PREMIUM");
        Order order = new Order(cust, 1000);

        //Traditional code:
        if (order != null) {
            Customer customer = order.customer();

            String name = customer.name();
            String tier = customer.tier();

            double total = order.total();

            System.out.println(name);
            System.out.println(tier);
            System.out.println(total);
        }

        //Record patterns allow us to deconstruct the record.
        if (order instanceof Order(Customer(var name, var tier), var total)) {
            System.out.println(name);
            System.out.println(tier);
            System.out.println(total);
        }

        String str = switch (order) {
            case Order(Customer(var name, var tier), var total) -> name + " " + tier + " " + total;
        };

    }
}
