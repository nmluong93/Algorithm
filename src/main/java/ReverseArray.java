package main.java;

import java.util.Arrays;

public class ReverseArray {

    static void main() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(String.format("Original array: %s. \nReverse array %s", Arrays.toString(arr), Arrays.toString(revertArray(arr))));
    }


    private static int[] revertArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
        return array;
    }
}
