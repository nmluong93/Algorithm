package main.java;

import java.util.Arrays;

public class TripletSum {

/**
 * Determines whether any three elements in the array sum to the given target.
 *
 * <p>Approach: Sort the array, then for each element {@code arr[i]}, use two pointers
 * ({@code left} and {@code right}) to find a pair in the remaining subarray whose sum
 * equals {@code target - arr[i]}. Time complexity: O(n log n) for sorting + O(n²) for
 * the search = O(n²). Space complexity: O(1) extra space (in-place sort).
 *
 * @param arr    the input array of integers (may be unsorted)
 * @param target the integer value the three elements must sum to
 * @return {@code true} if a triplet exists whose sum equals {@code target},
 * {@code false} if no such triplet exists or the array has fewer than 3 elements, or null.
 */
public static boolean hasSumOfThreeElementsMatchingTarget(int[] arr, int target) {

    if (arr == null || arr.length < 3) {
        return false;
    }
    Arrays.sort(arr);

    for (int i = 0; i < arr.length - 2; i++) {

        int left = i + 1;
        int right = arr.length - 1;

        while (left < right) {

            int sum = arr[i] + arr[left] + arr[right];

            if (sum == target) {
                return true;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    return false;
}

    public static void main(String[] args) {

        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 22;

        System.out.println(hasSumOfThreeElementsMatchingTarget(arr, target));


        /*

        1,  3,  4,  2,  2

        0   1   2   3   4






         */



    }
}