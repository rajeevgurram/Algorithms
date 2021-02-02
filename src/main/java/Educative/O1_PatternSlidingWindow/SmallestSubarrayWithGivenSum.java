package Educative.O1_PatternSlidingWindow;

/**
 * Problem Statement #
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 */
public class SmallestSubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] data = {2, 1, 5, 2, 8};
        int s = 7;
        System.out.println(findSmallestSubarrayWithSum(data, s));
    }

    public static int findSmallestSubarrayWithSum(int[] data, int s) {
        int windowStart = 0;
        int windowEnd = 0;
        int windowSum = 0;
        int minSubArrayLength = Integer.MAX_VALUE;

        while (windowStart <= windowEnd && windowStart < data.length) {
            if(windowSum >= s) {
                minSubArrayLength = Math.min(minSubArrayLength, (windowEnd - windowStart));
                windowSum -= data[windowStart++];
            } else {
                windowSum += data[windowEnd++];
            }
        }

        return minSubArrayLength;
    }
}
