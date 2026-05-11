package main.java;

public class MaxSubArray {

    public static int maxSubArrayLength(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decision: extend the current subarray or start a new one?
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max sum: " + maxSubArrayLength(nums)); // 6
    }


    public static int[] maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        int tempStart = 0;
        int start = 0, end = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                // Reset: start a new subarray at i
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{maxSum, start, end};

    }
//
//    static void main() {
////        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {1, 2, -10, 1, 100};
//        int result1 = MaxSubarray.maxSubArray(nums);
//
//
//        nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] result = maxSubArray(nums);
//        System.out.println("Max sum : " + result[0]);          // 6
//        System.out.println("Start index: " + result[1]);       // 3
//        System.out.println("End index  : " + result[2]);       // 6
//
//        System.out.print("Subarray: ");
//        for (int i = result[1]; i <= result[2]; i++) {
//            System.out.print(nums[i] + " ");                   // 4 -1 2 1
//        }
//    }
}
