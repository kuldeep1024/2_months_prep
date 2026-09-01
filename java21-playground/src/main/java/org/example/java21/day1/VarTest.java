package org.example.java21.day1;

public class VarTest {
    static void main(String[] args) {

        String name = "Kuldeep";
        System.out.println(name);

        // Using 'var' to declare a variable
        var message = "Hello, Java 21!";
        var name2 = "Kuldeep";

        //name2=100; // This will cause a compilation error because 'name2' is inferred as String

        System.out.println(message);
        System.out.println(name2);
    }
}
