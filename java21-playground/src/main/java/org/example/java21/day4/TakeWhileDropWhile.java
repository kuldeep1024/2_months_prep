package org.example.java21.day4;

import java.util.List;

public class TakeWhileDropWhile {
    static void main(String[] args) {
        List<Integer> numbers =
                List.of(2, 4, 6, 7, 8, 10);

        //Takes values while condition remains true.
        List<Integer> numbers1 =  numbers.stream()
                .takeWhile(n -> n % 2 == 0)
                .toList();
        System.out.println(numbers1);

        //Drops values while condition remains true.
        List<Integer> numbers2 =  numbers.stream()
                .dropWhile(n -> n % 2 == 0)
                .toList();
        System.out.println(numbers2);
    }
}
