package main.java;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * Example 3:
 *
 * Input: nums = [1,0,1,2]
 * Output: 3
 *
 * </pre>
 */
public class LongestConsecutive {

    static void main() {
        int[] arr = {8, 9, 100, 4, 200, 1, 2, 7}; // => 3
        var result = longestConsecutive(arr);
        System.out.println(result);
    }

    /**
     *
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNum = new HashSet<>();

        for (int num : nums) {
            uniqueNum.add(num);
        }

        int longest = 0;

        for (int num : uniqueNum) {

            // Only start from sequence e.g for {8, 9, 100, 4, 200, 1, 2, 7} => when checking 9 => skip, since it has 8, and the 8, has 7 => skip 8, and 9.
            //  only start from number 7 for calculating. => more efficient
            if (!uniqueNum.contains(num - 1)) {

                int current = num;
                int consecutiveNumberCount = 1;

                while (uniqueNum.contains(current + 1)) {
                    current++;
                    consecutiveNumberCount++;
                }

                longest = Math.max(longest, consecutiveNumberCount);
            }
        }

        return longest;
    }
}
