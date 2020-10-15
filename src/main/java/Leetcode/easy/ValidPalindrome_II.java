package Leetcode.easy;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 *
 *  Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 *
 * Input: "aba"
 * Output: True
 *
 * Example 2:
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindrome_II {
    public static void main(String[] args) {
        final String word = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(isValidPalindrome2(word, 0, word.length() - 1, 0));
    }

    public static boolean isValidPalindrome2(final String word,
                                             int startIndex,
                                             int endIndex,
                                             int counter) {

        while (startIndex <= endIndex) {
            if(word.charAt(startIndex) != word.charAt(endIndex)) {
                counter++;
                if(counter > 1) {
                    return false;
                }

                return isValidPalindrome2(word, startIndex + 1, endIndex, counter) ||
                        isValidPalindrome2(word, startIndex, endIndex - 1, counter);
            } else {
                startIndex++;
                endIndex--;
            }
        }

        return true;
    }
}
