package Leetcode.medium;

/**
 * https://leetcode.com/problems/single-number-ii/
 *
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 *
 * explanation: https://www.youtube.com/watch?v=XPFp9Ct_-ek
 * best explanation: https://www.youtube.com/watch?v=wuo4g9hciO4
 */
public class SingleNumber_ii {
    public static void main(String[] args) {
        int[] data = {2, 2, 40, 2};
        int response = 0;
        String easySolution = "";

        for(int bits = 0; bits < 32; bits ++) {
            int numberOfOnes = 0;

            for(int digit : data) {
                if((digit >> bits & 1) == 1) {
                    System.out.println(String.format("1 found for number %s, bits %s ",
                            digit, bits));
                    numberOfOnes++;
                }
            }

            easySolution = (numberOfOnes % 3) + easySolution;
            if(numberOfOnes % 3 != 0) {
                response = response | (1 << bits);
                System.out.println(String.format("number of one's %s, response %s, bits %s",
                        numberOfOnes, response, bits));
            }
        }
        System.out.println(response);
        System.out.println(easySolution);
        System.out.println(Integer.parseInt(easySolution, 2));
    }
}
