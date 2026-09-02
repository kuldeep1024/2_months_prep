package org.example.java21.day2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstUniqueChar {
    static void main(String[] args) {
        String str = "loveleetcode";

        System.out.println(findFirstUniqueChar(str));
        System.out.println(findFirstUniqueCharFindIndex(str));
        System.out.println(findFirstUniqueCharArray(str));
        System.out.println(findFirstUniqueCharJava8(str));
    }

    public static Character findFirstUniqueChar(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str.toCharArray()) {
            if (freqMap.get(ch) == 1) {
                return ch;
            }
        }

        return null;
    }

    public static Integer findFirstUniqueCharFindIndex(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (freqMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static Character findFirstUniqueCharArray(String str) {
        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch - 'a'] == 1)
                return ch;
        }

        return null;
    }

    public static Character findFirstUniqueCharJava8(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(e-> e.getKey())
                .findFirst()
                .orElse(null);
    }
}
