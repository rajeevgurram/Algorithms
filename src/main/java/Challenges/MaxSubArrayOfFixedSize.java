package Challenges;

/**
 * find the maximum sum from a fixed sub array
 * ex:
 * Input: [1, 2, 3, 4, 1, 2], fixedSize = 3
 * output: 9 => [2, 3, 4]
 */
public class MaxSubArrayOfFixedSize {
    public static void main(String[] args) {
        int sum = maxSubArrayOfFixedSize(new int[] {1, 2, 3, 4, 1, 2, 3}, 3);
        System.out.println(sum);
    }

    public static int maxSubArrayOfFixedSize(int[] data, int subArraySize) {
        int sum = 0, currentSum = 0;

        for(int i = 0; i < data.length; i ++) {
            currentSum += data[i];

            if(i >= subArraySize - 1) {
                sum = Integer.max(sum, currentSum);
                currentSum -= data[i - (subArraySize - 1)];
            }
        }

        return sum;
    }
}
