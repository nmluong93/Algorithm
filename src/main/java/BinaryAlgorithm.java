package main.java;

public class BinaryAlgorithm {

    static void main() {
        String a = "1010";

        // 0 * 2^0 + 1 * 2^1 + 0 * 2^2 + 1* 2^3

        int result = Integer.parseInt(a, 2);
        System.out.printf("String %s having base 10 = %s", a, result);
    }
}
