package org.example.java21.day3;

public class PatternDominance {
    public static void main(String[] args) {
        Object value = "";

        //The first pattern already catches every String.
        //Therefore the second pattern can never be reached.
        //This is called pattern dominance

        /*String obj= switch (value) {
            case Object o -> "Object";
            case String s -> "String";
        }
         */


        //Correct
        String obj2 = switch (value) {
            case String s1 -> "String";
            case Object o1 -> "Object";
        };
    }
}
