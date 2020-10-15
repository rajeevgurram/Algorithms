package Challenges;

/**
 * Find longest subarray by sum
 * ex: [1, 2, 3, 4, 5, 0, 0, 0, 0, 6, 7, 8], sum = 15
 * response: [1, 9] => Longest Subarray
 *
 * IN PROGRESS
 */
public class LongestSubarrayBySum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 0, 0, 0, 0, 6, 7, 8};
        int sum = 15;

        findLongestSubarrayBySum(array, sum);
    }

    public static void findLongestSubarrayBySum(int[] array, int sum) {
        int index = 0;
        int result = array[index];

        for(int i = 1; i < array.length; i ++) {
            if(sum > result) {
                result += array[i];
            } else if(sum < result) {
                result -= array[index];
                index ++;
                i--;
            } else {
                System.out.println(index + " --> " + i);
            }
        }
    }
}
