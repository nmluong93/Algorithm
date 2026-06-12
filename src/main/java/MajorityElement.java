package main.java;

public class MajorityElement {

    public static int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            /*
             Here we decide if the number is not candidate => decreasing count otherwise, increase it.
             E.g if number X occur 2 times and next is number D occurs 3 times, then we would say that,
                D occur 1 more time than X => consider D as candidate => it obviously occurs more time than X
            */
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement(nums));
    }
}
