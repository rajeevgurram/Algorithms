package Educative.O1_PatternSlidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘k’,
 * find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */
public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] data = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSumSubArray(data, k));
    }

    public static int maxSumSubArray(final int[] data, int k) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = 0;

        for(int windowEnd = 0; windowEnd < data.length; windowEnd ++) {
            windowSum += data[windowEnd];

            if(windowEnd >= k - 1) {
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= data[windowStart++];
            }
        }

        return maxSum;
    }
}
