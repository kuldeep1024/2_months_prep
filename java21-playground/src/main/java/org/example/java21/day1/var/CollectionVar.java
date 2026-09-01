package org.example.java21.day1.var;

import java.util.List;
import java.util.Map;

public class CollectionVar {
    public static void main(String[] args) {
        var fruitNames = List.of("Apple", "Banana", "Cherry");
        var scoreMap = Map.of("Math", 95, "Science", 90);

        System.out.println("Fruits: " + fruitNames);
        System.out.println("Scores: " + scoreMap);
    }
}