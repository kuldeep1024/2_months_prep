package org.example.java21.day4.dsa;

public class ValidPalindrome {
    static void main(String[] args) {
        System.out.println(isValidPalindrome("a man, a plan, a canal: panama"));
    }

    public static boolean isValidPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(str.charAt(left)))
                left++;
            else if (!Character.isLetterOrDigit(str.charAt(right)))
                right--;
            else {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
