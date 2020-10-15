package Leetcode.medium;

/**
 * Given two string sequences write an algorithm to find, find the length of longest substring present in both of them.
 *
 * https://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-substring/
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        LongestCommonSubstring l = new LongestCommonSubstring();
        System.out.println(l.findLongestCommonSubstring("tutorialpoint", "dynamictutorials"));
        System.out.println(l.findLongestCommonSubstring_Bruteforce("tutorialpoint", "dynamictutorials"));
    }

    private int findLongestCommonSubstring_Bruteforce(final String s1, final String s2) {
        int result = 0, tempSize = 0;

        char[] A = s1.toCharArray();
        char[] B = s2.toCharArray();

        for(int i = 0; i < A.length; i ++) {
            for(int j = i + 1; j < B.length; j ++) {
                if(A[i] == B[j]) {
                    tempSize ++;
                    result = Integer.max(tempSize, result);
                    i++;
                } else {
                    tempSize = 0;
                }
            }
        }


        return result;
    }

    // Dynamic Programming using 2 dimensional array
    private int findLongestCommonSubstring(final String s1, final String s2) {
        char[] A = s1.toCharArray();
        char[] B = s2.toCharArray();

        int[][] LCS = new int[A.length + 1][B.length + 1];

        // if B is null
        for(int i = 0; i <= A.length; i ++) {
            LCS[i][0] = 0;
        }

        // if A is null
        for(int i = 0; i <= B.length; i ++) {
            LCS[0][i] = 0;
        }

        int length = 0, from = 0, to = 0;

        for(int i = 1; i <= A.length; i ++) {
            for(int j = 1; j <= B.length; j ++) {
                if(A[i-1] == B[j-1]) {
                    LCS[i][j] = 1 + LCS[i-1][j-1];

                    if(LCS[i][j] > length) {
                        length = LCS[i][j];
                        from = i;
                        to = j;
                    }
                } else {
                    LCS[i][j] = 0;
                }
            }
        }

        System.out.println(s2.substring(from - 1, to));
        return length;
    }
}
