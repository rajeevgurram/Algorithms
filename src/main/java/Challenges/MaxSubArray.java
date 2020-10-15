package Challenges;

/**
 * find the series of contiguous elements with the maximum
 * sum in any given array.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] array = {-3, 1, -8, 4, -1, 2, 1, -5, 5};
        MaxSubArray solution = new MaxSubArray();
        solution.findMaxSubArray_BruteForce(array);
        solution.findMaxSubArray(array);
    }

    // Brute force way, find the sum of all sub arrays
    // Time complexity: O(N)^2
    private void findMaxSubArray_BruteForce(int[] array) {
        int fromIndex = 0, toIndex = 0, maxSum = 0;

        for(int i = 0; i < array.length; i ++) {
            int sum = array[i];
            for(int j = (i + 1); j < array.length; j ++) {
                sum += array[j];
                if(sum > maxSum) {
                    maxSum = sum;
                    fromIndex = i;
                    toIndex = j;
                } else {
                    break;
                }
            }
        }

        printSolution(fromIndex, toIndex, maxSum);
    }

    public void printSolution(int from, int to, int maxSum) {
        System.out.println("from : " +
                from + ", to : " +
                to + ", maxSum : " +
                maxSum);
    }

    // Kadane's Algorithm
    public void findMaxSubArray(int[] array) {
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

        printSolution(fromIndex, toIndex, maxSum);
    }
}
