package main.java;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {


    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {

            if (!map.containsKey(c)) {
                return false;
            }

            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        int passed = 0, total = 0;

        Object[][] cases = {
            {"anagram", "nagaram", true},
            {"rat", "car", false},
            {"a", "a", true},
            {"ab", "a", false},
            {"", "", true},
            {"aab", "bba", false},
            {"aacc", "ccac", false},
        };

        for (Object[] c : cases) {
            total++;
            String s = (String) c[0], t = (String) c[1];
            boolean expected = (boolean) c[2];
            boolean result = isAnagram(s, t);
            if (result == expected) {
                System.out.println("[PASS] isAnagram(\"" + s + "\", \"" + t + "\") = " + result);
                passed++;
            } else {
                System.out.println("[FAIL] isAnagram(\"" + s + "\", \"" + t + "\") = " + result + ", expected " + expected);
            }
        }

        System.out.println("Result: " + passed + "/" + total + " passed");
    }
}
