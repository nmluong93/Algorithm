package main.java;

import java.util.Arrays;

/**
 * [1,1,2,2,3] => 1, 2, 3 => result = 3 (3 elements)
 */
public class RemoveDuplicatesFromSortedArr {

    static void main() {
        int [] arr = {1,1,1,1,1 ,2, 2, 3, 4, 4, 4};
        var result = removeDuplicates(arr);
        System.out.println(result);
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int slow = 1;

        for (int fast = 1; fast < nums.length; fast++) {

            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        System.out.println(Arrays.toString(nums));

        return slow;
    }
}
