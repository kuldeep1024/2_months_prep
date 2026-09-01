package org.example.java21.day1.var;

public class MethodReturnVar {

    public static String computeGreeting() {
        return "Hello, Java Developer!";
    }

    public static void main(String[] args) {
        var greeting = computeGreeting();
        System.out.println(greeting);
    }
}