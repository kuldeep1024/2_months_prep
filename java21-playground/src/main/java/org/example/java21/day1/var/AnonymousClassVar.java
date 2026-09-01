package org.example.java21.day1.var;

public class AnonymousClassVar {

    interface Greeter {
        void greet();
    }

    public static void main(String[] args) {
        var customGreeter = new Greeter() {
            @Override
            public void greet() {
                System.out.println("Hello from an anonymous class initialized with var!");
            }
        };

        customGreeter.greet();

        Greeter greeter = ()-> {
            System.out.println("Hello from an lambda initialized with var!");
        };

        greeter.greet();
    }
}