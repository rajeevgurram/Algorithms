package Leetcode.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad" dabab
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        final String input = "babad";
        //System.out.println(solution.longestPalindromicSubstring(input));
        System.out.println(solution.longestPalindromicSubstring_usingDynamic_Programming(input));
    }

    // Solution 1: Brute force. O(N^3)
    public String longestPalindromicSubstring(final String word) {
        int length = 0;
        String longestPalindromicSubstring = null;
        for(int i = 0; i < word.length(); i ++) {
            for(int j = i + 1; j < word.length(); j ++) {
                final String subStr = word.substring(i, j);
                boolean isPalindrome = isPalindrome(subStr);
                if(isPalindrome) {
                    final int currentLength = j - i;
                    if(length < currentLength) {
                        length = currentLength;
                        longestPalindromicSubstring = subStr;
                    }
                }
            }
        }
        return longestPalindromicSubstring;
    }

    private boolean isPalindrome(final String word) {
        for(int i = 0; i < word.length() / 2; i ++) {
            if(word.charAt(i) != word.charAt((word.length() - 1) - i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Solution 2: Using Dynamic Programming.
     * Reverse the word and find the longest common substring using matrix
     */
    public String longestPalindromicSubstring_usingDynamic_Programming(final String word) {
        int length = 0, from = 0, to = 0;
        StringBuilder longestPalindromicSubstring = new StringBuilder();

        final String reverseWord = new StringBuilder(word).reverse().toString();

        int[][] matrix = new int[word.length() + 1][word.length() + 1];

        for(int i = 1; i <= word.length(); i ++) {
            for(int j = 1; j <= reverseWord.length(); j ++) {
                if(word.charAt(i - 1) == reverseWord.charAt(j - 1)) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                    if(matrix[i][j] > length) {
                        length = matrix[i][j];
                        from = i;
                        to = j;
                    }
                }
            }
        }

        for(int i = from, j = to; i >=1 && j >= 1; i--, j--) {
            longestPalindromicSubstring.append(word.charAt(i));
        }

        printMatrix(matrix);
        return longestPalindromicSubstring.toString();
    }

    private void printMatrix(int[][] matrix) {
        for(int i = 1; i < matrix.length; i ++) {
            for(int j = 1; j < matrix.length; j ++) {
                System.out.print(" " + matrix[i][j]);
            }

            System.out.println(" ");
        }
    }
}
