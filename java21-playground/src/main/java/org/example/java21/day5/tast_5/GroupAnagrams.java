package org.example.java21.day5.tast_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(arr));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] freq = new int[26];

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                freq[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    key.append((char) i + 'a');
                    key.append(freq[i]);
                }
            }

            String keyString = key.toString();

            List<String> list = map.get(keyString);

            if (list == null) {
                list = new ArrayList<>();
                map.put(keyString, list);
            }

            list.add(word);
        }
        return new ArrayList<>(map.values());
    }
}