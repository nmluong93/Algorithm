package main.java;

import java.util.Arrays;

public class TripletSumRefactored {

    public static boolean hasSumOfThreeElementsMatchTarget(int[] arr, int target) {

        if (arr == null || arr.length < 3) {
            return false;
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (hasPairWithSum(arr, i + 1, arr.length - 1, target - arr[i])) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasPairWithSum(int[] arr, int left, int right, int target) {
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return true;
            if (sum < target) left++;
            else right--;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 22;

        System.out.println(hasSumOfThreeElementsMatchTarget(arr, target));
    }
}