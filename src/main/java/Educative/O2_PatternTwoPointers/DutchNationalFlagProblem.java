package Educative.O2_PatternTwoPointers;

import java.util.Arrays;

/**
 * Problem Statement #
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 *
 * The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
 *
 * Example 1:
 *
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 * Example 2:
 *
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0 0 1 2 2 2 ]
 */
public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0};
        System.out.println(Arrays.toString(solution(arr)));
    }

    private static int[] solution(int[] arr) {
        int left = 0, right = arr.length - 1;
        for(int i = 0; i <= right;) {
            if(arr[i] == 0) {
                swap(arr, i, left);
                left++;
                i++;
            } else if(arr[i] == 1) {
                i++;
            } else  {
                swap(arr, i, right);
                right--;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
