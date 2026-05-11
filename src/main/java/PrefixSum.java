package main.java;

/**
 * Prefix Sum (Cumulative Sum)
 * <p>
 * Problem: Given an array, answer multiple range sum queries [L, R] efficiently.
 * <p>
 * Naive approach: iterate from L to R for each query — O(n) per query.
 * Prefix Sum approach: precompute cumulative sums once, then answer each query in O(1).
 * <p>
 * Key idea:
 * prefix[i] = arr[0] + arr[1] + ... + arr[i]
 * sum(L, R) = prefix[R] - prefix[L-1]  (special case: if L == 0, return prefix[R])
 * <p>
 * Time:  O(n) build + O(1) per query
 * Space: O(n)
 * <p>
 * Use when: many range sum queries on a static (unchanging) array.
 */
public class PrefixSum {

    static int[] buildPrefix(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    static int query(int[] prefix, int L, int R) {
        if (L == 0) return prefix[R];
        return prefix[R] - prefix[L - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] prefix = buildPrefix(arr);

        System.out.println(query(prefix, 2, 5)); // 4+1+5+9 = 19
        System.out.println(query(prefix, 0, 3)); // 3+1+4+1 = 9
        System.out.println(query(prefix, 5, 7)); // 9+2+6   = 17
    }
}