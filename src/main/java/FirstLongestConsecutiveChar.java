package main.java;

public class FirstLongestConsecutiveChar {

    public static char findLongestConsecutiveChar(String s) {
//        String s = "aaabbcccc";

        int[] longest = new int[26];

        int count = 1;

        char resultChar = s.charAt(0);
        int maxCount = 0;

        for (int i = 1; i <= s.length(); i++) {

            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {

                count++;

            } else {

                char c = s.charAt(i - 1);

                /*
                'a' - 'a' = 0
                'b' - 'a' = 1
                'c' - 'a' = 2
                 */
                int index = c - 'a';

                longest[index] = Math.max(longest[index], count);

                // Find global maximum
                if (longest[index] > maxCount) {
                    maxCount = longest[index];
                    System.out.println(String.format("Max count is %s, of char %s", maxCount, c));
                    resultChar = c;
                }

                count = 1;
            }
        }

        return resultChar;
    }

    public static void main(String[] args) {
        int passed = 0;
        int total = 0;

        String[][] cases = {
//            {"abcddeeeffff",      "f"},  // ffff = 4
//            {"aaaa",              "a"},  // aaaa = 4
//            {"ffffdddffffddddd",  "d"},  // ddddd = 5 beats ffff = 4
            {"aaabbccccaaaa",         "c"},  // cccc = 4
//            {"aaaabbcccc",         "a"},  // cccc = 4
//            {"a",                 "a"},  // single char
//            {"aabb",              "a"},  // tie — aa seen first
//            {"abcd",              "a"},  // all length 1, first wins
//            {"zzzaaa",            "z"},  // tie — zzz seen first
        };

        for (String[] tc : cases) {
            String input    = tc[0];
            char   expected = tc[1].charAt(0);
            char   result   = findLongestConsecutiveChar(input);
            total++;
            if (result == expected) {
                System.out.println("[PASS] \"" + input + "\" → '" + result + "'");
                passed++;
            } else {
                System.out.println("[FAIL] \"" + input + "\" → expected '" + expected + "' but got '" + result + "'");
            }
        }

        System.out.println("Result: " + passed + "/" + total + " passed");
    }
}
