package main.java;

import java.util.Arrays;

public class RotateArrayWithKSteps {

    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        =>         {7, 8, 9, 1, 2, 3, 4, 5, 6}
        System.out.println("Original Array: \n" + Arrays.toString(arr));
        rotate(arr, 3);
    }

//    public static int[] rotate(int[] arr, int k) {
//
//
//        for (int i = 0; i < k; i++) {
//            int last = arr.length - k + i;
//            int temp = arr[i];
//            arr[i] = arr[last];
//            arr[last] = temp;
//        }
//
//        return arr;
//
//    }


    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1); // đảo toàn bộ
        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, k - 1); // đảo K phần tử đầu
        System.out.println(Arrays.toString(nums));
        reverse(nums, k, n - 1); // đảo phần còn lại
        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

}
