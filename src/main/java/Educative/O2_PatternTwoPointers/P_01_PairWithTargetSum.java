package Educative.O2_PatternTwoPointers;

import java.util.Arrays;

/**
 * Problem Statement #
 * Given an array of sorted numbers and a target sum,
 * find a pair in the array whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers
 * (i.e. the pair) such that they add up to the given target.
 *
 * Example 1:
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * Example 2:
 *
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */

public class P_01_PairWithTargetSum {
    public static void main(String[] args) {
        int[] data = {2, 5, 9, 11};
        System.out.println(Arrays.toString(solution(data, 6)));
    }

    private static int[] solution(final int[] data, final int sum) {
        final int[] response = new int[2];
        int pointer1 = 0, pointer2 = data.length - 1;

        while (pointer1 < pointer2) {
            int currentSum = data[pointer1] + data[pointer2];
            if(currentSum == sum) {
                return new int[] {pointer1, pointer2};
            } else if(currentSum > sum) {
                pointer2 --;
            } else {
                pointer1 ++;
            }
        }

        return new int[] {-1, -1};
    }
}
