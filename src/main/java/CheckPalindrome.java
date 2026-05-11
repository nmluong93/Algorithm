package main.java;

public class CheckPalindrome {

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }

    static void main() {
        boolean isPalindrome = isPalindrome("abcdcba");
        System.out.println("Is abcdcba palindrome " + isPalindrome);
    }
}
