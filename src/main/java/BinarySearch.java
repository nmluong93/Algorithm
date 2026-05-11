package main.java;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {

        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        while (leftIdx <= rightIdx) {

            // Prevent integer overflow
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            // Target found
            if (arr[midIdx] == target) {
                return midIdx;
            }

            // Search right half
            if (arr[midIdx] < target) {
                leftIdx = midIdx + 1;
            }

            // Search left half
            else {
                rightIdx = midIdx - 1;
            }
        }

        // Not found
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int target, int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx) return -1;

        int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

        if (arr[midIdx] == target) return midIdx;
        if (arr[midIdx] < target) return binarySearchRecursive(arr, target, (midIdx + 1), rightIdx);
        return binarySearchRecursive(arr, target, leftIdx, (midIdx - 1));
    }

    public static void main(String[] args) {

//        int[] numbers = {1, 3, 5, 7, 9, 11, 15};
//
//        int target = 1;
//
//        int result = binarySearch(numbers, target);
//
//        if (result != -1) {
//            System.out.println("Found at index: " + result + " for value: " + numbers[result]);
//        } else {
//            System.out.println("Not found");
//        }

        String a = "abcdefgz";
        for (int i = 0; i < a.length(); i++) {
            System.out.println((int)a.toCharArray()[i]);
        }

        char a1 = 97;
        char a2 = 98;
        StringBuilder sb = new StringBuilder();
        sb.append(a1);sb.append(a2);
        System.out.println(sb.toString());
    }
}
