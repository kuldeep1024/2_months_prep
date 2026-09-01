package org.example.java21.day1.var;

public class VarNotWithFunctionalInterface {

    interface Greeter {
        void greet();
    }

    public static void main(String[] args) {

        // var greeter1 = () -> System.out.println("Hello from an lambda initialized with var!");
        //not possible because -  Cannot infer type: lambda expression requires an explicit target type


        Greeter greeter = () -> System.out.println("Hello from an lambda initialized with var!");

        greeter.greet();
    }
}

