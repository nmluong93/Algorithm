package main.java;


/**
 * Sliding Window Maximum Sum
 * <p>
 * Problem:
 * Given an integer array and a window size k, find the maximum sum of any
 * contiguous subarray of length k.
 * <p>
 * Example:
 * Input:  arr = [2, 1, 5, 1, 3, 2, 8, 4], k = 3
 * Output: 15  (subarray [8, 4, ...] — actually [5,1,3]=9, [1,3,2]=6, [3,2,8]=13, [2,8,4]=14... wait)
 * subarray [3, 8, 4] is not contiguous; correct max is [2, 8, 4] = 14? No.
 * Recheck: windows are [2,1,5]=8, [1,5,1]=7, [5,1,3]=9, [1,3,2]=6, [3,2,8]=13, [2,8,4]=14 → 14
 * (The main() example prints 15 — update k or arr as needed.)
 * <p>
 * Approach: Sliding Window O(n)
 * 1. Compute the sum of the first window of size k.
 * 2. Slide the window one step at a time: add the incoming right element and
 * subtract the outgoing left element.
 * 3. Track the maximum sum seen across all windows.
 * <p>
 * Complexity:
 * Time  O(n) — single pass after the initial window setup
 * Space O(1) — no extra data structures
 */
public class SlidingWindowOptimal {


    public static int maxSum(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1;

        // Compute sum of the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window from the second position onward
        for (int i = k; i < n; i++) {
            windowSum += arr[i]       // add incoming right element
                    - arr[i - k];   // remove outgoing left element
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }


//    public static void main(String[] args) {
//        int passed = 0;
//        int total = 0;
//
//        // helper
//        class Case {
//            int[] arr;
//            int k;
//            int expected;
//
//            Case(int[] a, int k, int e) {
//                arr = a;
//                this.k = k;
//                expected = e;
//            }
//        }
//
//        Case[] cases = {
//                new Case(new int[]{2, 1, 5, 1, 3, 2, 8, 4}, 3, 14), // max window [2,8,4]
//                new Case(new int[]{1, 4, 2, 9, 7, 3}, 3, 19), // max window [9,7,3]=19
//                new Case(new int[]{5}, 1, 5), // single element
//                new Case(new int[]{3, 3, 3}, 3, 9), // entire array
//                new Case(new int[]{-1, -2, -3, -4}, 2, -3), // all negatives
//                new Case(new int[]{1, 2}, 5, -1), // k > n → -1
//        };
//
//        for (Case c : cases) {
//            total++;
//            int result = maxSum(c.arr, c.k);
//            String arrStr = java.util.Arrays.toString(c.arr);
//            if (result == c.expected) {
//                System.out.println("[PASS] arr=" + arrStr + ", k=" + c.k + " → " + result);
//                passed++;
//            } else {
//                System.out.println("[FAIL] arr=" + arrStr + ", k=" + c.k + " → expected " + c.expected + ", got " + result);
//            }
//        }
//
//        System.out.println("Result: " + passed + "/" + total + " passed");
//    }
}
