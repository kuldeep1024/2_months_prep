package org.example.java21.day3.guarded_patterns;

public class MainTest {
    static void main(String[] args) {

        //type pattern + additional condition = guarded pattern
        Customer c = new Customer("name", "PREMIUM");
        System.out.println(test(c));

        Customer c2 = new Customer("name", "NON-PREMIUM");
        System.out.println(test(c2));

    }

    public static String test(Customer customer) {

        String benefits = switch (customer) {
            case Customer c when c.tier().equalsIgnoreCase("PREMIUM") -> "Give premium benefits";
            case Customer c -> "Give standard benefits";
        };

        return benefits;
    }
}
