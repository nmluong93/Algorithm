package main.java;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeat {


    static void main() {
        String input = "abcabcxbb";

        int maxLengthOfSub = lengthOfLongestSubstring(input);

        System.out.printf("Longest substring without repeating char of %s is %s%n", input, maxLengthOfSub);


        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
    }


    /**
     * "abcabcbb"
     *  ↑        left, right cùng bắt đầu ở 0
     *
     * [a]           → OK, size=1
     * [a,b]         → OK, size=2
     * [a,b,c]       → OK, size=3  ← maxLen=3
     * [b,c,a]       → gặp 'a' trùng, bỏ 'a' cũ, left tiến
     * [c,a,b]       → gặp 'b' trùng, bỏ 'b' cũ, left tiến
     * ...
     */
    private static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, length = s.length();
        int maxSize = 0;
        for (int right = 0; right < length; right++) {

            char c = s.charAt(right);
            if (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxSize = Math.max(maxSize, set.size());
        }


        return maxSize;
    }
}
