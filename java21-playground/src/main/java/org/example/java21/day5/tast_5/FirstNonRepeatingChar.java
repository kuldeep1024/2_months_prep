package org.example.java21.day5.tast_5;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    static void main() {
        String str = "abcabde";

        Optional<Character> res = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)
                .map(c -> c.getKey())
                .findFirst();

        System.out.println(res.get());

    }
}
