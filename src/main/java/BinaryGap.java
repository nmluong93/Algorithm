package main.java;

/**
 * Find the  longest sequence of consecutive 0s that is surrounded by 1s on both sides in the binary representation of a number.
 * 9  -> binary 1001
 * Binary gap = 2
 * N = 529
 * Binary = 1000010001 => 1 0000 1 000 1 => 4
 * <p>
 * <p>
 * N = 20
 * Binary = 10100 => 1 0 1 00 => 1
 */
public class BinaryGap {

    public static int searchLongestSequenceOfZeroBouncedByOne(int number) {

        int maxCount = 0;
        int currentCount = -1;

        while (number > 0) {

            if ((number & 1) == 1) {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            } else {
                if (currentCount != -1) {
                    currentCount++;
                }
            }

            number = number >> 1;
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[][] cases = {
            {9,          2},
            {529,        4},
            {20,         1},
            {1,          0},
            {2,          0},
            {6,          0},
            {15,         0},
            {1041,       5},
            {32,         0},
            {74901729,   4},
            {1073741825, 29},
            {2097153,    20},
            {33554433,   24},
            {2147483647, 0},
        };

        int passed = 0;
        for (int[] tc : cases) {
            int input = tc[0], expected = tc[1];
            int result = searchLongestSequenceOfZeroBouncedByOne(input);
            boolean ok = result == expected;
            if (ok) passed++;
            System.out.printf("[%s] Input: %d (binary: %s) => gap = %d (expected: %d)%n",
                ok ? "PASS" : "FAIL", input, Integer.toBinaryString(input), result, expected);
        }
        System.out.printf("Result: %d/%d passed%n", passed, cases.length);
    }
}
