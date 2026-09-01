package org.example.java21.day1.var;

import java.util.ArrayList;

public class VarWorseDiamondOperator {
    public static void main(String[] args) {
        // Bad: Because of the diamond operator <> with var, 
        // the compiler infers ArrayList<Object> instead of ArrayList<String>.
        var items = new ArrayList<>();

        items.add("Hello");
        items.add(123); // Compiles fine because type is ArrayList<Object>!

        System.out.println("Items: " + items);
    }
}