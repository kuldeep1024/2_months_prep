package org.example.java21.day3.dsa;

public class LongestCommonPrefix {
    static void main(String[] args) {
        String[] arr = {"flow", "flower", "flight"};
        System.out.println(longestCommonPrefix2(arr));
    }

    public static String longestCommonPrefix(String[] strs) {
        // If the input array is null or empty, return an empty string.
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Initialize prefix with the first string in the array.
        String prefix = strs[0];

        // Iterate through the other strings in the array.
        for (int i = 1; i < strs.length; i++) {
            // Keep checking if the current string starts with the prefix.
            // If not, shorten the prefix by one character from the end.
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, there is no common prefix, return "".
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return the found common prefix.
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0].toString();
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
