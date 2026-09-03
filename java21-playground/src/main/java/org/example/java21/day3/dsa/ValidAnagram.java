package org.example.java21.day3.dsa;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    static void main(String[] args) {
        String s = "anagram";
        String t = "nagaraa";

        System.out.println(isAnagramFreqMap(s, t));
        System.out.println(isAnagramFreqArray(s, t));
        System.out.println(isAnagramFreqArraySingleLoop(s, t));
    }

    public static boolean isAnagramFreqMap(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }
        return true;
    }

    public static boolean isAnagramFreqArray(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }

        for (char ch : t.toCharArray()) {
            freq[ch-'a']--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }
        return true;
    }
    public static boolean isAnagramFreqArraySingleLoop(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i =0; i<s.length();i++) {
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }
        return true;
    }
}
