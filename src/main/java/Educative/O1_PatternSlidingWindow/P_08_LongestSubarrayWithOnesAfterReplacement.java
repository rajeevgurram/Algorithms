package Educative.O1_PatternSlidingWindow;

/**
 * Problem Statement #
 * Given an array containing 0s and 1s, if you are allowed to replace no more than
 * ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 *
 * Example 1:
 *
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous
 * subarray of 1s having length 6.
 * Example 2:
 *
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous
 * subarray of 1s having length 9.
 */
public class P_08_LongestSubarrayWithOnesAfterReplacement {
    public static void main(String[] args) {
        int[] data = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        System.out.println(solution(data, 3));
    }

    private static int solution(final int[] data, int k) {
        int windowStart = 0;
        int longestSubArray = Integer.MIN_VALUE;
        int numberOfZeros = 0;

        for(int windowEnd = 0; windowEnd < data.length; windowEnd ++) {
            if(data[windowEnd] == 0) {
                numberOfZeros++;
            }

            if(numberOfZeros > k) {
                while (windowStart < windowEnd) {
                    if(data[windowStart++] == 0) {
                        break;
                    }
                }
                numberOfZeros--;
            }

            longestSubArray = Math.max(longestSubArray, (windowEnd - windowStart + 1));
        }

        return longestSubArray;
    }
}
