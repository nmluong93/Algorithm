package main.java;

import java.util.Arrays;

public class FindDuplicate {

    /**
     * Finds the duplicate number in an array of n+1 integers where each value is in [1, n].
     *
     * <p>Constraints: exactly one duplicate exists; the array must not be modified.
     *
     * @param nums array of n+1 integers, each in range [1, n]
     * @return the duplicate integer
     * <p>
     * Time:  O(n)
     * Space: O(1)
     */
    public static int findDuplicate(int[] nums) {

        // Phase 1: Find intersection point
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Phase 2: Find entrance of cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}
