package Leetcode.easy;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] data = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findMaxSubArray(data));
    }

    // Kadane's Algorithm
    public static int findMaxSubArray(int[] array) {
        int fromIndex = 0, toIndex = 0;
        int maxSum = 0, sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > (sum + array[i])) {
                fromIndex = i;
                sum = array[i];
            } else {
                sum = sum + array[i];
            }

            if (sum > maxSum) {
                maxSum = sum;
                toIndex = i;
            }
        }

        return maxSum;
    }
}
