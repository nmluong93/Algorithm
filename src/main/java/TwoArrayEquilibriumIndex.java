package main.java;


/**
 * <pre>
 * Problem Description
 *
 * Given two arrays A and B of the same length, find an index K such that:
 *
 *     A[0]+...+A[K]=A[K]+...+A[N−1]=B[0]+...+B[K]=B[K]+...+B[N−1]
 *
 * Return the index K.
 *
 * If no such index exists, return -1.
 *
 * Example
 *     A = [2, 3, 2]
 *     B = [1, 4, 1]
 *
 *     At K = 1:
 *
 *         A left  = 2 + 3 = 5
 *         A right = 3 + 2 = 5
 *
 *         B left  = 1 + 4 = 5
 *         B right = 4 + 1 = 5
 *
 *     Return: 1
 * </pre>
 */
public class TwoArrayEquilibriumIndex {

    public static int findIndex(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        int leftSumA = 0;
        int leftSumB = 0;
        for (int i = 0; i < A.length; i++) {
            int rightSumA = sumA - leftSumA;
            leftSumA += A[i];

            int rightSumB = sumB - leftSumB;
            leftSumB += B[i];

            if (leftSumA == rightSumA
                    && leftSumA == leftSumB
                    && leftSumA == rightSumB) {
                return i;
            }
        }


        return -1;
    }

    static void main() {
        int[] A = new int[]{2, 3, 2};
        int[] B = new int[]{1, 4, 1};

        System.out.println(findIndex(A, B));

        A = new int[]{2, 3, 1, 4, 1, 3, 2};
        B = new int[]{1, 4, 1, 4, 1, 4, 1};

        System.out.println(findIndex(A, B));
    }
}
