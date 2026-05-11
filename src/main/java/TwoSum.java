package main.java;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        record Case(String description, int[] nums, int target, int[] expected) {}
        Case[] cases = {
            new Case("basic example",           new int[]{2, 7, 11, 15}, 9,  new int[]{0, 1}),
            new Case("answer at end",           new int[]{3, 2, 4},      6,  new int[]{1, 2}),
            new Case("duplicate values",        new int[]{3, 3},         6,  new int[]{0, 1}),
            new Case("negative numbers",        new int[]{-3, 4, 3, 90}, 0,  new int[]{0, 2}),
            new Case("larger array",            new int[]{1, 5, 3, 7, 2}, 9, new int[]{3, 4}),
            new Case("target needs first+last", new int[]{0, 4, 3, 0},  0,  new int[]{0, 3}),
        };

        int passed = 0;
        for (Case c : cases) {
            int[] result = solver.twoSum(c.nums, c.target);
            boolean ok = result.length == 2
                && result[0] == c.expected[0]
                && result[1] == c.expected[1];
            System.out.printf("[%s] %s — expected=[%d,%d] got=%s%n",
                ok ? "PASS" : "FAIL", c.description,
                c.expected[0], c.expected[1],
                result.length == 2 ? "[" + result[0] + "," + result[1] + "]" : "[]");
            if (ok) passed++;
        }
        System.out.printf("%nResult: %d/%d passed%n", passed, cases.length);
    }
}
