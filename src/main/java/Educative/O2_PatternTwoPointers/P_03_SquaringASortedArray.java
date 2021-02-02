package Educative.O2_PatternTwoPointers;

import java.util.Arrays;

/**
 * Problem Statement #
 * Given a sorted array, create a new array containing
 * squares of all the number of the input array in the sorted
 * order.
 *
 * Example 1:
 *
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * Example 2:
 *
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0 1 1 4 9]
 */
public class P_03_SquaringASortedArray {
    public static void main(String[] args) {
        final int[] data = {-3, -1, 0, 1, 2};
        System.out.println(Arrays.toString(solution(data)));
    }

    public static int[] solution(final int[] data) {
        int[] arr = new int[data.length];
        int left = 0, right = data.length - 1;
        int index = data.length - 1;
        while (left < right) {
            int leftSum = data[left] * data[left];
            int rightSum = data[right] * data[right];
            if(leftSum > rightSum) {
                arr[index--] = leftSum;
                left++;
            } else {
                arr[index--] = rightSum;
                right--;
            }
        }
        return arr;
    }
}
